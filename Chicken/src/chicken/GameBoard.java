

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


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author hwf5000, Aldrich
 */
public class GameBoard extends JPanel implements ActionListener, KeyListener{

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
        setLayout(null);
        
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
        
        yoshi = new MainCharacter(g, new Point(100,300));
        add(yoshi); 
        setFocusable(true);
        yoshi.setBounds(yoshi.location.x, yoshi.location.y, 100, 100);
        yoshi.setBackground(Color.red);
        addKeyListener(this);
        
        
        //enemies.set(0, new EnemyBullet(g, new Point(5,5)));
  
    }
    
    @Override
    public void paintComponent(Graphics g) {

    	super.paintComponent(g); 
        yoshi.setBounds(yoshi.location.x, yoshi.location.y, 100, 100);
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                yoshi.location.y -= 2;
                repaint();
                break;
                
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                yoshi.location.x -= 2;
                repaint();
                break;
                
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                yoshi.location.x += 2;
                repaint();
                break;
                
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                yoshi.location.y += 2;
                repaint();
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
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
