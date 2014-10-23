/*
 * The MIT License
 *
 * Copyright 2014 Hermes Frangoudis (hwf5000).
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

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author hwf5000
 */
public class ShellPanel extends JPanel implements ActionListener{
    
    GameBoard gameboard;
    StartScreen startScreen;
    Image character, background;
    
    public ShellPanel(){
        super();
        setLayout(new BorderLayout());
        
        startScreen = new StartScreen();
        startScreen.startButton.addActionListener(this);
        add(startScreen);

    }
    
    public void createGameBoard(Image bg, Image c){
        int x = this.getRootPane().getParent().getHeight();
        int y = this.getRootPane().getParent().getWidth();
        gameboard = new GameBoard(x,y,bg, c);
        add(gameboard);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj.equals(startScreen.startButton)){
            if(startScreen.character == null){
                character = new ImageIcon(getClass().getClassLoader().getResource("yoshi.png")).getImage();
            }
            else {
                character = startScreen.character;
            }
        }
        
        if(obj.equals(startScreen.startButton)){
            if(startScreen.background == null){
                background = new ImageIcon(getClass().getClassLoader().getResource("street-bg.png")).getImage();
            }
            else {
                background = startScreen.background;
            }
        }
        
        int x = this.getRootPane().getParent().getHeight();
        int y = this.getRootPane().getParent().getWidth();
        gameboard = new GameBoard(x,y,background, character);
        remove(startScreen);
        startScreen.startButton.removeActionListener(this);
        
        add(gameboard);
        gameboard.getTopLevelAncestor().requestFocus();
        gameboard.requestFocusInWindow();
    }
}
