

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


import java.awt.Dimension;
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
    Image background;
    MainCharacter yoshi;
    EnemyBullet bullet, bullet2;
    Timer movementTimer;
    Timer powerUptimer;
    ArrayList<BoardObj> enemies;
    PowerUp powerUp;
    
    BoardObj[][] board = new BoardObj[20][30];

    public GameBoard(int h, int w, Image bg) {
        
        //Set up the board layout and listeners
        setLayout(null);
        setFocusable(true); 
        addKeyListener(this);
        height =  h;
        width = w;
        
        enemies = new ArrayList<>();
        
        background = bg;
        Dimension dimensions = new Dimension (bg.getWidth(null), bg.getHeight(null));
        setPreferredSize(dimensions);
        setMinimumSize(dimensions);
        setMaximumSize(dimensions);
        setSize(dimensions);
        setLayout(null);
        
        
        //Create Yoshi and add to board
        yoshi = new MainCharacter(new ImageIcon(getClass().getClassLoader().getResource("yoshi.png")), new Point(500,300));
        add(yoshi); 
        yoshi.setBounds(yoshi.location.x, yoshi.location.y, yoshi.getWidth(), yoshi.getHeight());
        
        //Create Bullet and add to board
        bullet = new EnemyBullet(new ImageIcon(getClass().getClassLoader().getResource("bullet.png")), new Point(0,100));
        bullet2 = new EnemyBullet(new ImageIcon(getClass().getClassLoader().getResource("bullet2.png")), new Point(this.getWidth(),200));
        add(bullet);
        add(bullet2);
        bullet.setBounds(bullet.location.x, bullet.location.y, 33, 29);
        bullet2.setBounds(bullet2.location.x, bullet2.location.y, 33, 29);
        enemies.add(bullet);
        enemies.add(bullet2);
        bullet.setBounds(bullet.location.x, bullet.location.y, bullet.getWidth(), bullet.getHeight());
        
        //Create Movement Timer
        movementTimer = new Timer(100,this);
        movementTimer.addActionListener(this);
        movementTimer.start();
        
    }
    
    @Override
    public void paintComponent(Graphics g) {

    	super.paintComponent(g); 
        yoshi.setBounds(yoshi.location.x, yoshi.location.y, 30, 30);
        bullet.setBounds(bullet.location.x, bullet.location.y, 33, 29);
        bullet2.setBounds(bullet2.location.x, bullet2.location.y, 33, 29);
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
        for(int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).getBounds().intersects(yoshi.getBounds())){
                return true;
            }
            
        }
        
    return false;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == movementTimer){
            if(bullet.location.x <= this.getWidth()){               
                bullet.location.x += 2;
            }
            else{
                bullet.location.x = 0;
            }
            
            if(bullet2.location.x > 0){
                bullet2.location.x -= 2;
            }
            else{
                bullet2.location.x += this.getWidth();
            }
            if(collisionCheck() == true){
                System.out.println("collided");
            }
            repaint();
        }
    }
    
    

    

}
