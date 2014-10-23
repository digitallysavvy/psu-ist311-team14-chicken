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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.*;


/**
 *
 * @author hwf5000, Aldrich
 */
public class GameBoard extends JPanel implements ActionListener, KeyListener{

    int height;
    int width;
    int delay = 100;
    Image background;
    MainCharacter yoshi;
    EnemyBullet bullet, bullet2;
    Timer movementTimer;
    Timer powerupTimer;
    ArrayList<BoardObj> enemies;
    PowerUp powerUp = null;
    Rectangle winArea;
    
    BoardObj[][] board = new BoardObj[20][30];

    public GameBoard(int h, int w, Image bg) {

        //Set up the board layout and listeners
        setLayout(null);
        setFocusable(true);
        addKeyListener(this);
        height = h;
        width = w;

        enemies = new ArrayList<>();
        winArea = new Rectangle(0, 0, 600, 40);
        
        
        background = bg;
        Dimension dimensions = new Dimension(bg.getWidth(null), bg.getHeight(null));
        setPreferredSize(dimensions);
        setMinimumSize(dimensions);
        setMaximumSize(dimensions);
        setSize(dimensions);
        setLayout(null);

        //Create Yoshi and add to board
        yoshi = new MainCharacter(new ImageIcon(getClass().getClassLoader().getResource("yoshi.png")), new Point(300,650));
        add(yoshi); 
        yoshi.setBounds(yoshi.location.x, yoshi.location.y, yoshi.getWidth(), yoshi.getHeight());
        
        //Create Bullet and add to board
        bullet = new EnemyBullet(new ImageIcon(getClass().getClassLoader().getResource("bullet.png")), new Point(0,100));
        bullet2 = new EnemyBullet(new ImageIcon(getClass().getClassLoader().getResource("bullet2.png")), new Point(this.getWidth(),220));
        add(bullet);
        add(bullet2);
        bullet.setBounds(bullet.location.x, bullet.location.y, bullet.width, bullet.height);
        bullet2.setBounds(bullet2.location.x, bullet2.location.y, bullet2.width, bullet2.height);
        enemies.add(bullet);
        enemies.add(bullet2);

        //Create Powerup;
        //Don't have egg.jpg yet. Using yoshi for now to test.
        powerUp = new PowerUp(new ImageIcon(getClass().getClassLoader().getResource("yoshi.png")), new Point(250, 600));
        powerUp.setBounds(powerUp.location.x, powerUp.location.y, powerUp.width, powerUp.height);
        add(powerUp);

        //Create Movement Timer
        movementTimer = new Timer(delay,this);
        movementTimer.addActionListener(this);
        movementTimer.start();
        
        //powerupTimer = new Timer(0,this); 
        //powerupTimer.addActionListener(this);
        //powerupTimer.start();
        
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        
        
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        yoshi.setBounds(yoshi.location.x, yoshi.location.y, yoshi.width, yoshi.height);
        bullet.setBounds(bullet.location.x, bullet.location.y, bullet.width, bullet.height);
        bullet2.setBounds(bullet2.location.x, bullet2.location.y, bullet2.width, bullet2.height);

        //if (powerupTimer > 50 && powerupTimer < 200) {
            //add(powerUp);
        //}
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            
            //Move up
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                yoshi.location.y -= 10;
                repaint();
                break;

            // Move Left
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                yoshi.location.x -= 10;
                repaint();
                break;

            // Move Right    
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                yoshi.location.x += 10;
                repaint();
                break;
            
            // Move Down
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                yoshi.location.y += 10;
                repaint();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public boolean collisionCheck() {
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getBounds().intersects(yoshi.getBounds())) {
                return true;
            }           
        }       
    return false;
    }
    
    public boolean powerupCollision(){
        if(powerUp.getBounds().intersects(yoshi.getBounds())){
            
            
            
            remove(powerUp);
            powerUp = null;
            int totalTime = 100; // in nanoseconds
            long startTime = System.currentTimeMillis();
            boolean toFinish = false;

                powerupTimer.setDelay(300);
        return true;
        }
        return false;
    }
    
    
    public void gameOver(){
                
        if(collisionCheck() == true){
            
            JLabel gameover = new JLabel("Game Over",SwingConstants.CENTER);
            gameover.setFont(new Font("serif", Font.PLAIN, 36));
            
            movementTimer.stop();
            JFrame gameoverFrame = new JFrame("Game Over");
            gameoverFrame.setLayout(new GridLayout(3,1));
            gameoverFrame.add(gameover);           
            JLabel lose = new JLabel("You lose", SwingConstants.CENTER);
            gameoverFrame.add(lose);
            gameoverFrame.setSize(300,300);
            gameoverFrame.setLocationRelativeTo(this);
            gameoverFrame.setVisible(true);
        }
        else if(gameWin() == true){
            
            JLabel gameover = new JLabel("Game Over",SwingConstants.CENTER);
            gameover.setFont(new Font("serif", Font.PLAIN, 36));
            
            movementTimer.stop();
            JFrame gameoverFrame = new JFrame("Game Over");
            gameoverFrame.setLayout(new GridLayout(3,1));
            gameoverFrame.add(gameover);           
            JLabel lose = new JLabel("You win", SwingConstants.CENTER);
            gameoverFrame.add(lose);
            gameoverFrame.setSize(300,300);
            gameoverFrame.setLocationRelativeTo(this);
            gameoverFrame.setVisible(true);
        }
  
    }
    
    public boolean gameWin(){
        if(yoshi.getBounds().intersects(winArea)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == movementTimer) {
            
            //Move bullet across the screen
            if (bullet.location.x <= this.getWidth()) {
                bullet.location.x += 2;
            } else {
                bullet.location.x = -30;
            }

            //Move bullet 2 across the screen
            if (bullet2.location.x > 0) {
                bullet2.location.x -= 2;
            } else {
                bullet2.location.x += this.getWidth();
            }
            // increment the power up counter
            //powerupTimer++;
            
            // temporarily add the power up to the screen
            if (powerupTimer == 50) {
                add(powerUp);
                powerUp.setBounds(powerUp.location.x, powerUp.location.y, powerUp.width, powerUp.height);
            //if (powerupTimer > 50 && powerupTimer < 200) {
                //add(powerUp);
                //powerUp.setBounds(powerUp.location.x, powerUp.location.y, powerUp.width, powerUp.height);
            //}
            //else{
                //remove(powerUp);
            //}
            
            if(powerUp != null){
                powerupCollision();
                
            }
            gameOver();
            
            repaint();
        }
        
        /*
        if(obj == powerupTimer){
            movementTimer.setDelay(200);
        }
        */
    }
    

}
