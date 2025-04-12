package au.com.codenhall.sokoban;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.HapticFeedbackConstants;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class SokobanGameView extends View {

  static class GameMetrics {
    boolean levelFitsOnScreen;
    int tileSize;
  }

  private Bitmap diamondOnFloorBitmap;
  private Bitmap diamondOnTargetBitmap;
  private Bitmap floorBitmap;
  final SokobanGameState game;
  private final boolean hapticFeedback;
  boolean ignoreDrag;
  private Bitmap manOnFloorBitmap;
  private Bitmap manOnTargetBitmap;
  GameMetrics metrics;
  private int offsetX;
  private int offsetY;
  private Bitmap outsideBitmap;
  private Bitmap targetBitmap;
  private Bitmap wallBitmap;

  private Rect previousLevelButtonRect;
  private Rect exitButtonRect;
  private Rect nextLevelButtonRect;
  private Rect resetButtonRect;

  public SokobanGameView(Context context, AttributeSet attributes) {
    super(context, attributes);

    hapticFeedback = getContext().getSharedPreferences(SokobanMenuActivity.SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    .getBoolean(SokobanMenuActivity.HAPTIC_FEEDBACK_PREFS_NAME,
        SokobanMenuActivity.HAPTIC_FEEDBACK_DEFAULT_VALUE);

    this.game = ((SokobanGameActivity) context).gameState;

    setOnTouchListener(new OnTouchListener() {
      private int xOffset;
      private int xTouch;
      private int yOffset;
      private int yTouch;

      @Override
      public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
          ignoreDrag = false;
          xTouch = (int) event.getX();
          yTouch = (int) event.getY();
          xOffset = 0;
          yOffset = 0;

          if (SokobanGameView.this.previousLevelButtonRect != null && SokobanGameView.this.previousLevelButtonRect.contains(xTouch, yTouch)) {
            goToPreviousLevel();
            return true;
          }
          if (SokobanGameView.this.exitButtonRect != null && SokobanGameView.this.exitButtonRect.contains(xTouch, yTouch)) {
            // Exit the game. The button is only shown when the game is at the start.
            // No need for a confirmation window, there is no progress to be lost.
            ((Activity) getContext()).finish();
            return true;
          }
          if (SokobanGameView.this.nextLevelButtonRect != null && SokobanGameView.this.nextLevelButtonRect.contains(xTouch, yTouch)) {
            int currentLevel = game.getCurrentLevel();
            int maxLevel = SokobanLevelMenuActivity.getMaxLevel(game.currentLevelSet, getContext());
            if (currentLevel < maxLevel-1) {
              goToNextLevel();
            }
            return true;
          }

          if (SokobanGameView.this.resetButtonRect != null && SokobanGameView.this.resetButtonRect.contains(xTouch, yTouch)) {
            // Show a confirmation window and reset the game if the user answer "Yes"
            SokobanGameView.this.confirmReset();
            return true;
          }

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
          // perhaps move to clicked tile? if not is moving?
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
          if (ignoreDrag)
            return true;

          // System.out.println("MOVING: " + event.getX() + ", " + event.getY());
          xOffset += xTouch - (int) event.getX();
          yOffset += yTouch - (int) event.getY();

          int dx = 0, dy = 0;

          if (Math.abs(xOffset) >= Math.abs(yOffset)) {
            // perhaps move x?
            dx = (xOffset) / metrics.tileSize;
            if (dx != 0) {
              yOffset = 0; // <= since we move horizontally, reset vertical offset
              xOffset -= dx * metrics.tileSize;
            }
          } else {
            // perhaps move y?
            dy = (yOffset) / metrics.tileSize;
            if (dy != 0) {
              xOffset = 0; // <= since we move vertically, reset horizontal offset
              yOffset -= dy * metrics.tileSize;
            }
          }

          performMove(-dx, -dy);

          xTouch = (int) event.getX();
          yTouch = (int) event.getY();
        }
        return true;
      }
    });

    setOnKeyListener(new OnKeyListener() {
      @Override
      public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != KeyEvent.ACTION_DOWN)
          return false;

        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_UP:
          performMove(0, -1);
          break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
          performMove(1, 0);
          break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
          performMove(0, 1);
          break;
        case KeyEvent.KEYCODE_DPAD_LEFT:
          performMove(-1, 0);
          break;
        default:
          return false;
        }
        return true;
      }
    });
  }

  private void confirmReset() {
    new AlertDialog.Builder(getContext())
        .setTitle("Confirm Reset")
        .setMessage("Are you sure you want to reset the level?")
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            // Reset the game state
            SokobanGameView.this.game.restart();
            // Redraw the game
            SokobanGameView.this.invalidate();
          }
        })
        .setNegativeButton("No", null)  // Just dismiss the dialog if "No" is clicked
        .show();
  }

  /** Called by our own activity. */
  public void backPressed() {
    if (game.performUndo()) {
      centerScreenOnPlayerIfNecessary();
      invalidate();
    }
  }

  private void centerScreenOnPlayer() {
    int[] playerPos = game.getPlayerPosition();
    int centerX = playerPos[0] * metrics.tileSize + metrics.tileSize / 2;
    int centerY = playerPos[1] * metrics.tileSize + metrics.tileSize / 2;
    // // offset + width/2 = centerX =>
    offsetX = centerX - getWidth() / 2;
    offsetY = centerY - getHeight() / 2;

    offsetX = -offsetX;
    offsetY = -offsetY;
  }

  private void centerScreenOnPlayerIfNecessary() {
    if (metrics.levelFitsOnScreen) {
      return;
    }

    int[] playerPos = game.getPlayerPosition();
    int playerX = playerPos[0];
    int playerY = playerPos[1];

    int tileSize = metrics.tileSize;
    int tilesLeftOfPlayer = (playerX * tileSize + offsetX) / tileSize;
    int tilesRightOfPlayer = (getWidth() - playerX * tileSize - offsetX) / tileSize;
    int tilesAboveOfPlayer = (playerY * tileSize + offsetY) / tileSize;
    int tilesBelowOfPlayer = (getHeight() - playerY * tileSize - offsetY) / tileSize;

    final int THRESHOLD = 1;
    if (tilesLeftOfPlayer <= THRESHOLD || tilesRightOfPlayer <= THRESHOLD || tilesAboveOfPlayer <= THRESHOLD
        || tilesBelowOfPlayer <= THRESHOLD) {
      centerScreenOnPlayer();
      ignoreDrag = true;
    }
  }

  private void computeMetrics() {
    metrics = new GameMetrics();
    metrics.tileSize = SokobanGameActivity.IMAGE_SIZE;
    // "-1" since the whole border tiles does not need to fit on screen:
    metrics.levelFitsOnScreen = ((game.getWidthInTiles() - 1) * metrics.tileSize <= getWidth() && (game
        .getHeightInTiles() - 1)
        * metrics.tileSize <= getHeight());
  }

  public void customSizeChanged() {
    computeMetrics();

    Resources resources = getResources();
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inScaled = false;

    diamondOnFloorBitmap = BitmapFactory.decodeResource(resources, R.drawable.diamond_on_floor_96, options);
    diamondOnTargetBitmap = BitmapFactory.decodeResource(resources, R.drawable.diamond_on_target_96, options);
    floorBitmap = BitmapFactory.decodeResource(resources, R.drawable.floor_96, options);
    manOnFloorBitmap = BitmapFactory.decodeResource(resources, R.drawable.man_on_floor_96, options);
    manOnTargetBitmap = BitmapFactory.decodeResource(resources, R.drawable.man_on_target_96, options);
    outsideBitmap = BitmapFactory.decodeResource(resources, R.drawable.outside_96, options);
    targetBitmap = BitmapFactory.decodeResource(resources, R.drawable.target_96, options);
    wallBitmap = BitmapFactory.decodeResource(resources, R.drawable.wall_96, options);

    float scaleFactor = metrics.tileSize / 96.0f;
    Matrix matrix = new Matrix();
    matrix.postScale(scaleFactor, scaleFactor);

    int imageSize = 96;
    // recreate the new Bitmap
    diamondOnFloorBitmap = Bitmap.createBitmap(diamondOnFloorBitmap, 0, 0, imageSize, imageSize, matrix, true);
    diamondOnTargetBitmap = Bitmap.createBitmap(diamondOnTargetBitmap, 0, 0, imageSize, imageSize, matrix, true);
    floorBitmap = Bitmap.createBitmap(floorBitmap, 0, 0, imageSize, imageSize, matrix, true);
    manOnFloorBitmap = Bitmap.createBitmap(manOnFloorBitmap, 0, 0, imageSize, imageSize, matrix, true);
    manOnTargetBitmap = Bitmap.createBitmap(manOnTargetBitmap, 0, 0, imageSize, imageSize, matrix, true);
    outsideBitmap = Bitmap.createBitmap(outsideBitmap, 0, 0, imageSize, imageSize, matrix, true);
    targetBitmap = Bitmap.createBitmap(targetBitmap, 0, 0, imageSize, imageSize, matrix, true);
    wallBitmap = Bitmap.createBitmap(wallBitmap, 0, 0, imageSize, imageSize, matrix, true);

    if (metrics.levelFitsOnScreen) {
      int w = game.getWidthInTiles() * metrics.tileSize;
      int h = game.getHeightInTiles() * metrics.tileSize;
      // 2*offsetX + w = getWidth() =>
      offsetX = (getWidth() - w) / 2;
      offsetY = (getHeight() - h) / 2;
    } else {
      centerScreenOnPlayer();
    }
  }

  @Override
  public void draw(Canvas canvas) {
    super.draw(canvas);
    canvas.drawColor(Color.BLACK);
    canvas.setDensity(Bitmap.DENSITY_NONE);

    final int widthInTiles = game.getWidthInTiles();
    final int heightInTiles = game.getHeightInTiles();
    final int tileSize = metrics.tileSize;

    for (int x = 0; x < widthInTiles; x++) {
      for (int y = 0; y < heightInTiles; y++) {
        int left = offsetX + tileSize * x;
        int top = offsetY + tileSize * y;

        Bitmap tileBitmap;
        char c = game.getItemAt(x, y);
        switch (c) {
        case '\'':
          tileBitmap = outsideBitmap;
          break;
        case SokobanGameState.CHAR_WALL:
          tileBitmap = wallBitmap;
          break;
        case SokobanGameState.CHAR_MAN_ON_FLOOR:
          tileBitmap = manOnFloorBitmap;
          break;
        case SokobanGameState.CHAR_MAN_ON_TARGET:
          tileBitmap = manOnTargetBitmap;
          break;
        case SokobanGameState.CHAR_FLOOR:
          tileBitmap = floorBitmap;
          break;
        case SokobanGameState.CHAR_DIAMOND_ON_FLOOR:
          tileBitmap = diamondOnFloorBitmap;
          break;
        case SokobanGameState.CHAR_DIAMOND_ON_TARGET:
          tileBitmap = diamondOnTargetBitmap;
          break;
        case SokobanGameState.CHAR_TARGET:
          tileBitmap = targetBitmap;
          break;
        default:
          throw new IllegalArgumentException(String.format("Invalid character at (%d,%d): %c", x, y, c));
        }

        canvas.drawBitmap(tileBitmap, left, top, null);
      }
    }

    int availableLevels = SokobanLevels.levelMaps.get(this.game.currentLevelSet).length;


    // Set up the Paint object for text drawing
    Paint levelTextPaint = new Paint();
    levelTextPaint.setColor(Color.WHITE);
    levelTextPaint.setTextSize(50);
    levelTextPaint.setAntiAlias(true);
    levelTextPaint.setTypeface(Typeface.DEFAULT_BOLD);

    // Draw the text at the top left
    canvas.drawText(this.game.currentLevelSetName, 20, 60, levelTextPaint);

    String levelText = String.format(
      "%d/%d",
      this.game.getCurrentLevel() + 1,
      availableLevels
    );
    levelTextPaint.setTextSize(40);
    levelTextPaint.setAntiAlias(true);
    levelTextPaint.setTypeface(Typeface.DEFAULT);

    // Draw the text at the top left
    canvas.drawText(levelText, 20, 110, levelTextPaint);

    // Paint for the steps counter (bottom-left)
    Paint stepsTextPaint = new Paint();
    stepsTextPaint.setColor(Color.WHITE);
    stepsTextPaint.setTextSize(40);
    stepsTextPaint.setAntiAlias(true);
    stepsTextPaint.setTypeface(Typeface.DEFAULT);

    // Get canvas height to position text at the bottom
    float canvasHeight = canvas.getHeight();
    canvas.drawText(this.game.getStepCount() + "/" + this.game.getPushCount(), 20, canvasHeight - 20, stepsTextPaint);

    if (this.game.getStepCount() > 0) {
      this.drawResetButton(canvas);
    } else {
      this.drawExitButton(canvas);
    }
  }

  private void drawExitButton(Canvas canvas) {
    int padding = 20;

    int prevButtonWidth = 70;
    int exitButtonWidth = 120;
    int nextButtonWidth = 70;

    int nextX = canvas.getWidth() - prevButtonWidth - padding;
    int exitX = nextX - exitButtonWidth - padding;
    int prevX = exitX - nextButtonWidth - padding;
    int y = padding;

    this.resetButtonRect = null;

    int currentLevel = game.getCurrentLevel();
    int maxLevel = SokobanLevelMenuActivity.getMaxLevel(game.currentLevelSet, getContext());

    this.previousLevelButtonRect = drawButton(canvas, "<", prevButtonWidth, prevX, y, currentLevel > 0);
    this.exitButtonRect = drawButton(canvas, "Exit", exitButtonWidth, exitX, y, true);
    this.nextLevelButtonRect = drawButton(canvas, ">", nextButtonWidth, nextX, y, currentLevel < maxLevel-1);
  }

  private void drawResetButton(Canvas canvas) {
    int buttonWidth = 300;
    int padding = 20;
    int x = canvas.getWidth() - buttonWidth - padding;
    int y = padding;

    this.previousLevelButtonRect = null;
    this.exitButtonRect = null;
    this.nextLevelButtonRect = null;

    this.resetButtonRect = drawButton(canvas, "Reset", buttonWidth, x, y, true);
  }

  private Rect drawButton(Canvas canvas, String text, int buttonWidth, int x, int y, boolean enabled) {
    int buttonHeight = 80;

    Rect button = new Rect(x, y, x + buttonWidth, y + buttonHeight);

    // Draw button background
    Paint paint = new Paint();
    paint.setColor(enabled ? Color.LTGRAY : Color.DKGRAY);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(5);
    canvas.drawRect(button, paint);

    paint.setColor(enabled ? Color.DKGRAY : Color.BLACK);
    paint.setStyle(Paint.Style.FILL);
    canvas.drawRect(button, paint);

    // Draw text
    paint.setColor(enabled ? Color.WHITE : Color.DKGRAY);
    paint.setTextSize(40);
    paint.setTextAlign(Paint.Align.CENTER);
    canvas.drawText(text, x + buttonWidth / 2, y + buttonHeight / 2 + 15, paint);

    return button;
  }

  void gameOver() {
    if (hapticFeedback) {
      Vibrator vibrator = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
      vibrator.vibrate(300);
    }
    invalidate();

    SharedPreferences prefs = getContext().getSharedPreferences(SokobanMenuActivity.SHARED_PREFS_NAME,
        Context.MODE_PRIVATE);
    final String maxLevelPrefName = SokobanLevelMenuActivity.getMaxLevelPrefName(game.currentLevelSet);
    int currentMaxLevel = prefs.getInt(maxLevelPrefName, 1);
    int newMaxLevel = game.getCurrentLevel() + 2; // zero based level from getCurrentLevel()
    String message = "Level already cleared - no new level unlocked!";
    boolean levelSetDone = false;
    if (newMaxLevel > currentMaxLevel) {
      if (newMaxLevel - 1 >= SokobanLevels.levelMaps.get(game.currentLevelSet).length) {
        newMaxLevel--;
        message = "You completed all levels!";
        levelSetDone = true;
      } else {
        Editor editor = prefs.edit();
        editor.putInt(maxLevelPrefName, newMaxLevel);
        editor.commit();
        message = "New level unlocked!";
      }
    }

    // Add score
    message += "\nSolution: " + this.game.getStepCount() + "/" + this.game.getPushCount();

    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
    alert.setCancelable(false);
    alert.setMessage(message);
    alert.setTitle("Congratulations");
    final int levelDestination = newMaxLevel - 1; // newMaxLevel was one based
    final boolean levelSetDoneFinal = levelSetDone;
    alert.setPositiveButton("Save", (dialog, which) -> {
      ((SokobanGameActivity) getContext()).downloadSolution();
    });
    alert.setNeutralButton("Continue", (dialog, which) -> {
      goToNextLevel();
    });
    alert.show();
  }

  public void goToPreviousLevel() {
    int levelDestination = game.getCurrentLevel() - 1;
    if (levelDestination < 0) {
      return;
    }

    ((Activity) getContext()).finish();
    Intent intent = new Intent();
    intent.putExtra(SokobanGameActivity.GAME_LEVEL_INTENT_EXTRA, levelDestination);
    intent.putExtra(SokobanGameActivity.GAME_LEVEL_SET_EXTRA, game.currentLevelSet);
    intent.putExtra(SokobanGameActivity.GAME_LEVEL_SET_NAME_EXTRA, game.currentLevelSetName);
    intent.setClass(getContext(), SokobanGameActivity.class);
    getContext().startActivity(intent);
  }

  public void goToNextLevel() {
    boolean levelSetDoneFinal = false;
    int levelDestination = game.getCurrentLevel() + 1;
    if (levelDestination >= SokobanLevels.levelMaps.get(game.currentLevelSet).length) {
      levelSetDoneFinal = true;
    }

    ((Activity) getContext()).finish();
    if (!levelSetDoneFinal) {
      Intent intent = new Intent();
      intent.putExtra(SokobanGameActivity.GAME_LEVEL_INTENT_EXTRA, levelDestination);
      intent.putExtra(SokobanGameActivity.GAME_LEVEL_SET_EXTRA, game.currentLevelSet);
      intent.putExtra(SokobanGameActivity.GAME_LEVEL_SET_NAME_EXTRA, game.currentLevelSetName);
      intent.setClass(getContext(), SokobanGameActivity.class);
      getContext().startActivity(intent);
    }
  }

  @Override
  protected void onSizeChanged(int width, int height, int oldw, int oldh) {
    super.onSizeChanged(width, height, oldw, oldh);
    customSizeChanged();
  }

  void performMove(int dx, int dy) {
    if (game.tryMove(dx, dy)) {
      if (hapticFeedback) {
        performHapticFeedback(HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
      }
      centerScreenOnPlayerIfNecessary();
      invalidate();

      if (game.isDone()) {
        gameOver();
      }
    }
  }
}
