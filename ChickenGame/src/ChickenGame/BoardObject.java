/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChickenGame;


import javax.swing.*;

/**
 *
 * @author Aldrich
 */
public class BoardObject extends JLabel{
    
    ImageIcon image;
    int currentX, currentY;
    int speed; //delay value for timer
    
    
    public BoardObject(ImageIcon i){
        image = i;
        JLabel s = new JLabel("");
        setIcon(image);
    }
    
    public boolean checkCollision(){
        
        return false;
    } 
}
