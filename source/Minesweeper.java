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

    public void setup() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if ((int) (Math.random() * 10) == 0) {
                    Block a1 = new Block(blockSize, true, x, y);
                    b[i][j] = a1;
                }else{
                    Block a1 = new Block(blockSize, false, x, y);
                    b[i][j] = a1;
                }
                x = x + blockSize;
            }
            y = y + blockSize;
            x = 0;
        }
    }

    public void draw() {
        background(100);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if(b[i][j].mine==true){
                    fill(235,52,52);
                    rect(b[i][j].blockX, b[i][j].blockY, b[i][j].size, b[i][j].size);
                }else{
                    fill(29,212,222);
                    rect(b[i][j].blockX, b[i][j].blockY, b[i][j].size, b[i][j].size);
                }

            }
        }
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
}
