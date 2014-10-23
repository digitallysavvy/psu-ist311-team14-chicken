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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreen extends JPanel {

    JButton greenCharacter, blueCharacter, yellowCharacter, streetsBg, conesBg, skiesBg, startButton;
    JPanel characterChooser, bgChooser;

    public StartScreen(){
        
        //Set Layout
        setLayout(new BorderLayout());
        
        //Character Choice Panel
        bgChooser = new JPanel();
        bgChooser.setLayout(new GridLayout(3, 1));
        
        // Background Choice Panel
        characterChooser = new JPanel();
        characterChooser.setLayout(new GridLayout(3, 1));

        //Create Character Choice Buttons
        greenCharacter = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/yoshi-green.jpg")));
        blueCharacter = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/yoshi-blue.jpg")));
        yellowCharacter = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/yoshi-yellow.jpg")));
        
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
        
        add(characterChooser);
        add(bgChooser);
        add(startButton);
    }

}
