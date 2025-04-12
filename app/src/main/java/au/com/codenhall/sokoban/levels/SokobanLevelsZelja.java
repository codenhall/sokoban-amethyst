package au.com.codenhall.sokoban.levels;

public class SokobanLevelsZelja extends AbstractSokobanLevels {
    public String[][] getLevels() {
        return new String[][] {
            {
                "##############",
                "##          ##",
                "# # $    $ $ #",
                "#  # $ $ ##..#",
                "# $ # $ #  ..#",
                "#    #@##  ..#",
                "#     # ###..#",
                "##        #  #",
                "# #          #",
                "#  # $ #     #",
                "#   #   #    #",
                "##   #   #  ##",
                "##############"
            }, {
                "##############",
                "###          #",
                "##          ##",
                "#   ##   ##  #",
                "#   # # #  ..#",
                "#  #   # # ..#",
                "#  $  # ## *.#",
                "#    # @ ##..#",
                "#   #  $$ #  #",
                "#  # $$  $ ###",
                "#      #   $ #",
                "#    ####    #",
                "##############"
            }
        };
    }
}

