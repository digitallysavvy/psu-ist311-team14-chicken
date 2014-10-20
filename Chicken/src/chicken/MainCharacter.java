/*
 * The MIT License
 *
 * Copyright 2014 Aldrich Fung, Hermes Frangoudis (hwf5000).
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

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Aldrich, hwf5000
 */
public class MainCharacter extends BoardObj implements KeyListener{

    
    public MainCharacter(ImageIcon g, Point p) {
        super(g,p);
    }


    /**
     *
     * @param direction
     */
    @Override
    public void moveTo(Direction direction) {
        switch(direction){
        case UP:
            //Sprite animation here
            break;
        
        case LEFT:
            //Sprite animation here

            break;
            
        case RIGHT:

            break;
            
        case DOWN:
            //Sprite animation here

            break;
                
    }
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
               
                break;
                
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:

                break;
                
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:

                break;
                
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:

                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
}
