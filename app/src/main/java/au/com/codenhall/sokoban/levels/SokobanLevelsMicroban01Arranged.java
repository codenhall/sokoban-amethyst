package au.com.codenhall.sokoban.levels;

public class SokobanLevelsMicroban01Arranged extends AbstractSokobanLevels {
    public String[][] getLevels() {
        return new String[][] {
            {
                "  #####",
                "  #   #",
                "  # # #######",
                "  #  *  #   #",
                "  ## ##   # #",
                "  #   * #*  #",
                "### # # # ###",
                "#  *#$+   #",
                "# #   ## ##",
                "#   #  *  #",
                "####### # #",
                "      #   #",
                "      #####"
            }, {
                "   #####",
                "   # @ #",
                "  ##   ##",
                "###.$$$.###",
                "#  $...$  #",
                "#  $.#.$  #",
                "#  $.*.$  #",
                "###.$$$.###",
                "  ## . ##",
                "   #   #",
                "   #####"
            }, {
                " #######",
                "##  .  ##",
                "# .$$$. #",
                "# $ + $ #",
                "#.$.*.$.#",
                "# $ . $ #",
                "# .$$$. #",
                "##  .  ##",
                " #######"
            }
        };
    }
}

