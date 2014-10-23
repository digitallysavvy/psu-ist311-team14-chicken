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
/**
 *
 * @author hwf5000
 */
package chicken;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreen extends JPanel implements ActionListener{

    JButton greenCharacter, blueCharacter, yellowCharacter, streetsBg, conesBg, skiesBg, startButton;
    JPanel characterChooser, bgChooser;
    
    Image character, background;

    public StartScreen(){
        
        //Set Layout
        setLayout(new BoxLayout(this, Y_AXIS));
        
        //Character Choice Panel
        bgChooser = new JPanel();
        bgChooser.setLayout(new GridLayout(3, 1));
        
        // Background Choice Panel
        characterChooser = new JPanel();
        characterChooser.setLayout(new GridLayout(3, 1));

        //Create Character Choice Buttons
        greenCharacter = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/yoshi.png")));
        blueCharacter = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/yoshi-blue.png")));
        yellowCharacter = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/yoshi-yellow.png")));
        
        // Add choices to character chooser
        characterChooser.add(greenCharacter);
        characterChooser.add(blueCharacter);
        characterChooser.add(yellowCharacter);
        
        //Create Background Choice Buttons
        streetsBg = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/background1-button.jpg")));
        conesBg = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/background2-button.jpg")));
        skiesBg = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/background3-button.jpg")));
        
        // Add choices to background chooser
        bgChooser.add(streetsBg);
        bgChooser.add(conesBg);
        bgChooser.add(skiesBg);
        
        startButton = new JButton("Start Game");
        
        
        //Add listeners for user selection
        greenCharacter.addActionListener(this);
        blueCharacter.addActionListener(this);
        yellowCharacter.addActionListener(this);
        
        streetsBg.addActionListener(this);
        conesBg.addActionListener(this);
        skiesBg.addActionListener(this);
        
        add(characterChooser);
        add(bgChooser);
        add(startButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        
        if(obj.equals(greenCharacter)){
            character = new ImageIcon(getClass().getClassLoader().getResource("images/yoshi.png")).getImage();
            
        }
        else if(obj.equals(blueCharacter)){
            character = new ImageIcon(getClass().getClassLoader().getResource("images/yoshi-blue.png")).getImage();
            
        }
        else if(obj.equals(yellowCharacter)){
            character = new ImageIcon(getClass().getClassLoader().getResource("images/yoshi-yellow.png")).getImage();
        }
        
        if(obj.equals(streetsBg)){
            background = new ImageIcon(getClass().getClassLoader().getResource("images/street-bg.png")).getImage();            
        }
        else if(obj.equals(conesBg)){
            background = new ImageIcon(getClass().getClassLoader().getResource("images/cones-bg.png")).getImage();
        }
        else if(obj.equals(skiesBg)){
            background = new ImageIcon(getClass().getClassLoader().getResource("images/skies-bg.png")).getImage();      
        }
        
    }

}
