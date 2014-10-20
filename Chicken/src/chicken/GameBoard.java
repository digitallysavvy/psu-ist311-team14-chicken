

/*
 * The MIT License
 *
 * Copyright 2014 Hermes Frangoudis (hwf5000), Aldrich Fung.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package chicken;


import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author hwf5000, Aldrich
 */
public class GameBoard extends JPanel{

    int height;
    int width;
    int row;
    int col;
    ImageIcon background;
    MainCharacter yoshi;
    Timer movementTimer;
    Timer powerUptimer;
    ArrayList<BoardObj> enemies;
    PowerUp powerUp;

    public GameBoard() {
        row = 20;
        col = 30;
        ImageIcon g;
        try {
            g = new ImageIcon(ImageIO.read(getClass().getResource("images/yoshi.png")));
        } catch (IOException ex) {
            g = null;
        }
        yoshi = new MainCharacter(g);
        BoardObj[][] panelHolder = new BoardObj[row][col];    
        setLayout(new GridLayout(row,col));

        for(int m = 0; m < row; m++) {
            for(int n = 0; n < col; n++) {
                panelHolder[m][n] = null;
                add(panelHolder[m][n]);
   }
}
    }

    public boolean collisionCheck() {
        //check if main character has 
        return false;
    }

}
