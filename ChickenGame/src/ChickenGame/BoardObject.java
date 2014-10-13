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
    int x, y; //dimensions
    int speed; //delay value for timer
    
    
    public BoardObject(ImageIcon i){
        image = i;
        setIcon(image);
    }
    
    public boolean checkCollision(){
        
        return false;
    } 
}
