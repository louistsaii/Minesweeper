
public class Block {
    int size;
    boolean mine;
    int blockX;
    int blockY;

    public Block(int size, boolean mine, int row, int col) {
        this.size = size;
        this.mine = mine;
        this.blockX = getXY(col);
        this.blockY = getXY(row);
    }

    public int getXY(int index) {
        return index * size;
    }

    public void draw(Minesweeper ms) {

        // if safe
        //    set safe color
        //    return
        if (safe == true) {
            ms.fill(252, 207, 3);
            return;
        }


        if (mine == true) {
            ms.fill(29, 212, 222);
            ms.rect(blockX, blockY, size, size);
        } else {
            ms.fill(29, 212, 222);
            ms.rect(blockX, blockY, size, size);
        }
    }

    public void drawPlayer(Minesweeper ms) {

        ms.fill(200, 200, 0, 200);
        ms.rect(blockX, blockY, size, size);


    }


}