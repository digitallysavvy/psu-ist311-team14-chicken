

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


import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author hwf5000, Aldrich
 */
public class GameBoard extends JPanel implements ActionListener{

    int height;
    int width;
    ImageIcon background;
    MainCharacter yoshi;
    Timer movementTimer;
    Timer powerUptimer;
    ArrayList<BoardObj> enemies;
    PowerUp powerUp;
    
    BoardObj[][] board = new BoardObj[20][30];

    public GameBoard(int h, int w) {
        movementTimer = new Timer(50,this);
        
        /*
        setLayout(new GridLayout(20,30));
        
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 30; j++){
                board[i][j] = new BoardObj(null, new Point(i,j));
                add(board[i][j]);              
            }
        }*/
        
        
        ImageIcon g;
        height =  h;
        width = w;
        g = new ImageIcon(getClass().getClassLoader().getResource("yoshi.png"));
        
        yoshi = new MainCharacter(g, new Point(10,30));
        add(yoshi);
        
        //enemies.set(0, new EnemyBullet(g, new Point(5,5)));
  
    }
    
    @Override
    public void paintComponent(Graphics g) {

    	super.paintComponent(g); 
        Image i = createImage(yoshi.location.x,yoshi.location.y);
        g.drawImage(i,yoshi.location.x,yoshi.location.y, this);
        
    }

    public boolean collisionCheck() {
        //check if main character has 
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == movementTimer){
            repaint();
            
        }
    }
    
    

    

}
