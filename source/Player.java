import java.util.ArrayList;

public class Player {

    int row;
    int col;
    Block playerBlock = null;
    int mines = 0;

    public Player(int row, int col) {
        this.row = row;
        this.col = col;

    }

    void showMines( Minesweeper ms){
        if( playerBlock!=null ){
            ms.fill(0);
            ms.textSize(50);
            ms.text(mines, playerBlock.blockX+12,playerBlock.blockY+45) ;
        }
    }

    ArrayList<Block> getSurroundBlocks(Block[][] map) {
        ArrayList<Block> surrBlocks = new ArrayList<>();
        mines = 0;
        // row : 4
        // col : 7

        for (int i = row - 1; i <= row + 1; i++) { // i:3,4,5
            for (int j = col - 1; j <= col + 1; j++) { //j:6,7,8
                if(i==row && j==col){
                    playerBlock = map[i][j];
                }

                if (i < 0 || j < 0 ||
                        i >= map.length ||
                        j >= map[0].length) {
                    continue;
                }
                surrBlocks.add(map[i][j]);
            }
        }
        for (int i = 0; i < surrBlocks.size(); i++) {
            if(surrBlocks.get(i).mine == true){
                mines = mines + 1;
            }
        }

        return surrBlocks;

    }
}
