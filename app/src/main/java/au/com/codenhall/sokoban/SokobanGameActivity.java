package au.com.codenhall.sokoban;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SokobanGameActivity extends Activity {

  /** Key under which the {@link SokobanGameState} is stored in the saved instance state bundle. */
  private static final String GAME_KEY = "GAME";
  /** Key under which the level to launch is set as an extra Intent attribute. */
  public static final String GAME_LEVEL_INTENT_EXTRA = "GAME_LEVEL";
  public static final String GAME_LEVEL_SET_EXTRA = "GAME_LEVEL_SET";
  public static final String GAME_LEVEL_SET_NAME_EXTRA = "GAME_LEVEL_SET_NAME";
  public static final String GAME_LEVEL_SET_DONE_EXTRA = "GAME_LEVEL_SET_DONE";
  public static final String GAME_LEVEL_DESTINATION_EXTRA = "GAME_LEVEL_DESTINATION";
  public static final String GAME_SOLUTION_FILENAME_EXTRA = "GAME_SOLUTION_FILENAME";
  public static int IMAGE_SIZE;
  /** Key under which the image size is stored. */
  public static final String IMAGE_SIZE_PREFS_KEY = "image_size";
  /** If the help should be shown (when max level is one). */
  public static final String SHOW_HELP_INTENT_EXTRA = "SHOW_HELP";
  private static final int CREATE_FILE_REQUEST_CODE = 1;
  public SokobanGameState gameState;

  private SokobanGameView view;

  // Undos
  private int undoCount = 0;
  private Handler undoHandler = new Handler();  // To handle repeated undos
  private Runnable undoRunnable = new Runnable() {
    @Override
    public void run() {
      if (SokobanGameActivity.this.undoCount > 0) {
        int delay = SokobanGameActivity.this.undoCount == 1 ? 300 : 100;
        SokobanGameActivity.this.view.backPressed();
        SokobanGameActivity.this.undoHandler.postDelayed(this, delay);
        SokobanGameActivity.this.undoCount++;
      }
    }
  };

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState != null) {
      gameState = (SokobanGameState) savedInstanceState.getSerializable(GAME_KEY);
    }
    if (gameState == null) {
      int level = 0;
      Intent intent = getIntent();
      int levelSet = 0;
      String levelSetName = "Unknown";
      if (intent != null && intent.getExtras() != null) {
        level = intent.getExtras().getInt(GAME_LEVEL_INTENT_EXTRA, 0);
        if (intent.getExtras().getBoolean(SHOW_HELP_INTENT_EXTRA, false))
          showHelp(); // show when starting first level from menu
        levelSet = intent.getExtras().getInt(GAME_LEVEL_SET_EXTRA, 0);
        levelSetName = intent.getExtras().getString(GAME_LEVEL_SET_NAME_EXTRA, "Unknown");
      }
      gameState = new SokobanGameState(level, levelSet, levelSetName);
    }
    setContentView(R.layout.main);

    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    int defaultImageSize = Math.min(metrics.widthPixels, metrics.heightPixels) / 11; // 11 = tile size of first level

    if (defaultImageSize % 2 != 0)
      defaultImageSize--;
    IMAGE_SIZE = getSharedPreferences(SokobanMenuActivity.SHARED_PREFS_NAME, MODE_PRIVATE).getInt(
        IMAGE_SIZE_PREFS_KEY, defaultImageSize);

    view = (SokobanGameView) findViewById(R.id.memoryview);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);
    return true;
  }

  /** Overridden to handle back button - see {@link SokobanGameActivity#onBackPressed() } */
  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      if (this.undoCount == 0) {
        this.undoCount++;
        this.undoHandler.post(this.undoRunnable);
      }
      return true;
    } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
      if (IMAGE_SIZE < 68)
        setImageSize(IMAGE_SIZE + 2);
      return true;
    } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
      if (IMAGE_SIZE > 12)
        setImageSize(IMAGE_SIZE - 2);
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }


  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_VOLUME_UP || keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
      // avoid the beep when pressing the buttons
      return true;
    }
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      this.undoCount = 0;  // Stop the undo loop
      this.undoHandler.removeCallbacks(this.undoRunnable);  // Stop undos immediately
      return true;  // Prevent the default "Back" action
    }

    return super.onKeyUp(keyCode, event);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.restart_menu) {
      gameState.restart();
      view.invalidate();
    } else if (item.getItemId() == R.id.back_menu) {
      finish();
    } else if (item.getItemId() == R.id.help_menu) {
      showHelp();
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putSerializable(GAME_KEY, gameState);
  }

  private void setImageSize(int newSize) {
    IMAGE_SIZE = newSize;
    SharedPreferences prefs = getSharedPreferences(SokobanMenuActivity.SHARED_PREFS_NAME, MODE_PRIVATE);
    Editor editor = prefs.edit();
    editor.putInt(IMAGE_SIZE_PREFS_KEY, newSize);
    editor.commit();
    view.customSizeChanged();
    view.invalidate();
  }

  public void showHelp() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder
    .setMessage("Push all amethyst crystals on the green targets to complete a level. Complete levels to unlock new ones.\n\nZoom in and out using the volume control.\n\nUndo moves with the back button.");
    builder.setPositiveButton("Ok", null);
    builder.create().show();
  }

  public void downloadSolution() {
    String filename = String.format(
        "%s%d_%d-%d.zip",
        (this.gameState.currentLevelSetName + "_")
            .replaceAll("[^a-zA-Z0-9-]", "_")
            .replaceAll("_+", "_"),
        this.gameState.getCurrentLevel() + 1,
        this.gameState.getStepCount(),
        this.gameState.getPushCount());

    // Create an Intent to prompt the user to choose a location
    Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
    intent.addCategory(Intent.CATEGORY_OPENABLE);
    intent.setType("application/zip");
    intent.putExtra(Intent.EXTRA_TITLE, filename);

    // Launch the file picker
    this.startActivityForResult(intent, CREATE_FILE_REQUEST_CODE);
  }

  // Handle the result of the file picker
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == CREATE_FILE_REQUEST_CODE && resultCode == RESULT_OK) {
      if (data != null) {
        String solutionFilename = String.format(
            "%s%d_%d-%d.txt",
            (this.gameState.currentLevelSetName + "_")
                .replaceAll("[^a-zA-Z0-9-]", "_")
                .replaceAll("_+", "_"),
            this.gameState.getCurrentLevel() + 1,
            this.gameState.getStepCount(),
            this.gameState.getPushCount());

        Uri uri = data.getData();  // The URI of the file chosen by the user

        try {
          // Write content to the selected location
          OutputStream outputStream = getContentResolver().openOutputStream(uri, "w");
          ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
          zipOutputStream.putNextEntry(new ZipEntry(solutionFilename == null ? "solution.txt" : solutionFilename));

          String fileContent = this.gameState.getGameSolutionString();
          zipOutputStream.write(fileContent.getBytes());
          zipOutputStream.flush();

          zipOutputStream.closeEntry();
          zipOutputStream.close();

          // Optionally, notify the user
          Toast.makeText(getApplicationContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
          Toast.makeText(getApplicationContext(), "Error saving file: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }

        view.goToNextLevel();
      }
    }
  }

}
