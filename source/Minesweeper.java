import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
public class Minesweeper extends PApplet {
    //window size --> 500 by 500
    // block size -->  50 by 50
    final int windowWidth = 500;
    final int windowHeight = 500;
    final int blockSize = 50;
    Block[][] b = new Block[10][10];
    Player player = new Player(4, 4);

    public void setup() {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if ((int) (Math.random() * 10) == 0) {
                    Block a1 = new Block(blockSize, true, i, j);
                    b[i][j] = a1;
                } else {
                    Block a1 = new Block(blockSize, false, i, j);
                    b[i][j] = a1;
                }
            }
        }
    }

    public void draw() {
        background(100);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j].draw(this);
            }
        }
        ArrayList<Block> sblocks = player.getSurroundBlocks(b);
        for (Block block : sblocks) {
            block.drawPlayer(this);
        }
        player.showMines(this);
    }

    public void settings() {
        size(windowWidth, windowHeight);
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"Minesweeper"};
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }

    public void keyPressed() {
        System.out.println(keyCode);
        if (player.row > 1) {
            if (keyCode == 38) { // UP
                player.row = player.row - 1;
            }
        }

        if (player.row < 8) {
            if (keyCode == 40) { // DOWN
                player.row = player.row + 1;
            }
        }


        if (keyCode == 37 && player.col > 1) { // LEFT
            player.col = player.col - 1;
        }

        if (keyCode == 39 && player.col < 8) { // Right
            player.col = player.col + 1;
        }


        // check out bound ??
    }
}

