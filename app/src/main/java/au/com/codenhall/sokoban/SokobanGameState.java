package au.com.codenhall.sokoban;

import java.io.Serializable;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class SokobanGameState implements Serializable {

	static class Undo implements Serializable {

		public char c1;
		public char c2;
		public char c3;

		public byte x1;
		public byte x2;
		public byte x3;

		public byte y1;
		public byte y2;
		public byte y3;
	}

	public static final char CHAR_DIAMOND_ON_FLOOR = '$';
	public static final char CHAR_DIAMOND_ON_TARGET = '*';
	public static final char CHAR_FLOOR = ' ';
	public static final char CHAR_MAN_ON_FLOOR = '@';
	public static final char CHAR_MAN_ON_TARGET = '+';
	public static final char CHAR_TARGET = '.';
	public static final char CHAR_WALL = '#';

	private static char newCharWhenDiamondPushed(char current) {
		return (current == CHAR_FLOOR) ? CHAR_DIAMOND_ON_FLOOR : CHAR_DIAMOND_ON_TARGET;
	}

	private static char newCharWhenManEnters(char current) {
		switch (current) {
		case CHAR_FLOOR:
		case CHAR_DIAMOND_ON_FLOOR:
			return CHAR_MAN_ON_FLOOR;
		case CHAR_TARGET:
		case CHAR_DIAMOND_ON_TARGET:
			return CHAR_MAN_ON_TARGET;
		}
		throw new RuntimeException("Invalid current char: '" + current + "'");
	}

	private static char originalCharWhenManLeaves(char current) {
		return (current == CHAR_MAN_ON_FLOOR) ? CHAR_FLOOR : CHAR_TARGET;
	}

	private static char[][] stringArrayToCharMatrix(String[] s) {
		char[][] result = new char[s[0].length()][s.length];
		for (int x = 0; x < s[0].length(); x++) {
			for (int y = 0; y < s.length; y++) {
				result[x][y] = s[y].charAt(x);
			}
		}
		return result;
	}

	private int currentLevel;
	final int currentLevelSet;
	final String currentLevelSetName;
	private char[][] map;
	private transient final int[] playerPosition = new int[2];
	private int stepCount = 0;
	private int pushCount = 0;
	private boolean isDone = false;
	final LinkedList<Undo> undos = new LinkedList<Undo>();

	public SokobanGameState(int level, int levelSet, String levelSetName) {
		currentLevel = level;
		currentLevelSet = levelSet;
		currentLevelSetName = levelSetName;
		loadLevel(currentLevel, levelSet);
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public int getHeightInTiles() {
		return map[0].length;
	}

	public char getItemAt(int x, int y) {
		return map[x][y];
	}

	public int[] getPlayerPosition() {
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				char c = map[x][y];
				if (CHAR_MAN_ON_FLOOR == c || CHAR_MAN_ON_TARGET == c) {
					playerPosition[0] = x;
					playerPosition[1] = y;
				}
			}
		}
		return playerPosition;
	}

	public int getWidthInTiles() {
		return map.length;
	}

	public boolean isDone() {
		for (int x = 0; x < map.length; x++)
			for (int y = 0; y < map[0].length; y++)
				if (map[x][y] == CHAR_DIAMOND_ON_FLOOR)
					return false;
		return true;
	}

	private void loadLevel(int level, int levelSet) {
		this.currentLevel = level;
		map = stringArrayToCharMatrix(SokobanLevels.levelMaps.get(levelSet)[level]);
	}

	public boolean performUndo() {
		this.isDone = false;
		if (undos.isEmpty())
			return false;
		Undo undo = undos.removeLast();
		this.stepCount--;
		map[undo.x1][undo.y1] = undo.c1;
		map[undo.x2][undo.y2] = undo.c2;
		if (undo.c3 != 0) {
			this.pushCount--;
			map[undo.x3][undo.y3] = undo.c3;
		}
		return true;
	}

	public void restart() {
		loadLevel(currentLevel, currentLevelSet);
		undos.clear();
		this.isDone = false;
		this.stepCount = 0;
		this.pushCount = 0;
	}

	/** Return whether something was changed. */
	public boolean tryMove(int dx, int dy) {
		if (dx == 0 && dy == 0)
			return false;

		if (dx != 0 && dy != 0) {
			throw new IllegalArgumentException("Can only move straight lines. dx=" + dx + ", dy=" + dy);
		}

		int steps = Math.max(Math.abs(dx), Math.abs(dy));
		int stepX = (dx == 0) ? 0 : (int) Math.signum(dx);
		int stepY = (dy == 0) ? 0 : (int) Math.signum(dy);

		boolean somethingChanged = false;

		int playerX = -1;
		int playerY = -1;
		// find player position
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				char c = map[x][y];
				if (CHAR_MAN_ON_FLOOR == c || CHAR_MAN_ON_TARGET == c) {
					playerX = x;
					playerY = y;
				}
			}
		}

		for (int i = 0; i < steps; i++) {
			if (this.isDone) {
				return false;
			}

			int newX = playerX + stepX;
			int newY = playerY + stepY;

			boolean ok = false;
			boolean pushed = false;

			switch (map[newX][newY]) {
			case CHAR_FLOOR:
				// move to empty space
			case CHAR_TARGET:
				// move to empty target
				ok = true;
				break;
			case CHAR_DIAMOND_ON_FLOOR:
				// pushing away diamond on floor
			case CHAR_DIAMOND_ON_TARGET:
				// pushing away diamond on target
				char pushTo = map[newX + stepX][newY + stepY];
				ok = (pushTo == CHAR_FLOOR || pushTo == CHAR_TARGET);
				// ok if pushing to empty space
				if (ok) {
					pushed = true;
				}
				break;
			}

			if (ok) {
				Undo undo;
				if (undos.size() > 200000) {
					// size of undo: 9 bytes + object overhead = 25?
					// reuse and clear undo object
					undo = undos.removeFirst();
					undo.c3 = 0;
				} else {
					undo = new Undo();
				}
				undos.add(undo);
				this.stepCount++;
				somethingChanged = true;

				if (pushed) {
					this.pushCount++;
					byte pushedX = (byte) (newX + stepX);
					byte pushedY = (byte) (newY + stepY);
					undo.x3 = pushedX;
					undo.y3 = pushedY;
					undo.c3 = map[pushedX][pushedY];
					map[pushedX][pushedY] = newCharWhenDiamondPushed(map[pushedX][pushedY]);
				}

				undo.x1 = (byte) playerX;
				undo.y1 = (byte) playerY;
				undo.c1 = map[playerX][playerY];
				map[playerX][playerY] = originalCharWhenManLeaves(map[playerX][playerY]);
				undo.x2 = (byte) newX;
				undo.y2 = (byte) newY;
				undo.c2 = map[newX][newY];
				map[newX][newY] = newCharWhenManEnters(map[newX][newY]);

				playerX = newX;
				playerY = newY;
				if (isDone()) {
					// if moving multiple steps at once, stop if an intermediate step may finish the game:
					this.isDone = true;
					return true;
				}
			}
		}
		return somethingChanged;
	}

	public String getGameSolutionString() {
		StringBuilder sb = new StringBuilder();
		for (Undo undo : this.undos) {
			char move = '_';
			boolean push = undo.c3 != 0;
			if (undo.x1 > undo.x2) {
				move = push ? 'L' : 'l';
			} else if (undo.x1 < undo.x2) {
				move = push ? 'R' : 'r';
			} else if (undo.y1 > undo.y2) {
				move = push ? 'U' : 'u';
			} else if (undo.y1 < undo.y2) {
				move = push ? 'D' : 'd';
			}

			sb.append(move);
		}
		return sb.toString();
	}

	public int getStepCount() {
		return this.stepCount;
	}

	public int getPushCount() {
		return this.pushCount;
	}
}
