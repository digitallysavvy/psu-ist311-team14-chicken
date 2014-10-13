/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChickenGame;

import javax.swing.ImageIcon;

/**
 *
 * @author Aldrich
 */
public class Powerup extends BoardObject{
    
    public Powerup(ImageIcon i){
        super(i);
        this.speed = 0; //Powerup doesn't move, right?
    }
}
