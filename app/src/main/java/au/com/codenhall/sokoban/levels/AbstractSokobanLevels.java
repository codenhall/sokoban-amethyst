package au.com.codenhall.sokoban.levels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractSokobanLevels {
    // Legend
    // ' = Void
    // # = Wall
    //   = Floor
    // $ = Diamond on flood
    // . = Target
    // * = Diamond on targer
    // @ = Man on flood
    // + = Man on target
    public abstract String[][] getLevels();

    // Used with level set that contains too many levels
    // - SokobanLevelsSvensCollection
    // - SokobanLevelsBugs1005Collections
    public String[][] mergeLevels(String[][]... levelsParts) {
        List<String[]> mergedLevels = new ArrayList<>();

        for (String[][] levelsPart : levelsParts) {
            Collections.addAll(mergedLevels, levelsPart);
        }

        return mergedLevels.toArray(new String[0][]);
    }

    public String[][] getSanitisedLevels() {
        String[][] levels = this.getLevels();
        int nbLevel = levels.length;
        String[][] parsedLevels = new String[nbLevel][];

        for (int levelIdx = 0; levelIdx < nbLevel; levelIdx++){
            parsedLevels[levelIdx] = this.sanitiseLevel(levels[levelIdx]);
        }

        return parsedLevels;
    }

    private String[] sanitiseLevel(String[] level) {
        char[][] charLevel = this.convertLevelToChar(level);

        int nbRow = charLevel.length;

        int rowLength = 0;
        // Find the maximum row length.
        for (char[] row : charLevel) {
            int curRowLength = row.length;
            if (curRowLength > rowLength) {
                rowLength = curRowLength;
            }
        }

        char[][] sanitisedLevel = new char[nbRow][];
        for (int i = 0; i < nbRow; i++) {
            sanitisedLevel[i] = this.sanitiseRow(charLevel[i], rowLength);
        }

        return this.convertLevelToString(sanitiseColumns(sanitisedLevel, rowLength));
    }

    private char[][] convertLevelToChar(String[] level) {
        int nbRow = level.length;
        char[][] charLevel = new char[nbRow][];

        for (int i = 0; i < nbRow; i++) {
            charLevel[i] = level[i].toCharArray();
        }

        return charLevel;
    }

    private String[] convertLevelToString(char[][] charLevel) {
        int nbRow = charLevel.length;
        String[] level = new String[nbRow];

        for (int i = 0; i < nbRow; i++) {
            level[i] = new String(charLevel[i]);
        }

        return level;
    }

    private char[] sanitiseRow(char[] row, int expectedLength) {
        int curRowLength = row.length;
        char[] sanitisedRow = new char[expectedLength];

        // Replace first " " with "'"
        boolean inVoid = true;
        int i=0;
        for (; i < curRowLength; i++) {
            if (inVoid && row[i] == '#') {
                inVoid = false;
            }
            sanitisedRow[i] = inVoid ? '\'' : row[i];
        }

        // Add "'" at the end of the row, until its length matches the others.
        for (; i < expectedLength; i++) {
            sanitisedRow[i] = '\'';
        }

        return sanitisedRow;
    }

    private char[][] sanitiseColumns(char[][] charLevel, int nbCol) {
        int nbRow = charLevel.length;

        for (int colIdx = 0; colIdx < nbCol; colIdx++) {
            // Change " " to "'", at the top
            for (int rowIdx = 0; rowIdx < nbRow; rowIdx++) {
                if (charLevel[rowIdx][colIdx] == '#') {
                    break;
                } else {
                    charLevel[rowIdx][colIdx] = '\'';
                }
            }
            // Change " " to "'", at the bottom
            for (int rowIdx = nbRow-1; rowIdx > 0; rowIdx--) {
                if (charLevel[rowIdx][colIdx] == '#') {
                    break;
                } else {
                    charLevel[rowIdx][colIdx] = '\'';
                }
            }
        }

        return charLevel;
    }
}
