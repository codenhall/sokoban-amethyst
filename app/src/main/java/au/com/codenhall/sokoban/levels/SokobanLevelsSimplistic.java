package au.com.codenhall.sokoban.levels;

public class SokobanLevelsSimplistic extends AbstractSokobanLevels {
    public String[][] getLevels() {
        return new String[][] {
            {
                "  #####",
                "###   ###",
                "# $ #   #",
                "# ..$.. #",
                "# $ #   #",
                "###$#####",
                "  #   #",
                "  # @ #",
                "  #   #",
                "  #####"
            }, {
                " #######",
                " #  #  ###",
                "##$.#  $ #",
                "# $.   . #",
                "#   ######",
                "### ##  @#",
                "# ..  .$ #",
                "# $$ #.$##",
                "###  #  #",
                "  #######"
            }
        };
    }
}

