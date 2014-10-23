/*
 * The MIT License
 *
 * Copyright 2014 Erik.
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

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author Erik
 */
public class SplashScreen extends JFrame implements ActionListener {
    
    JButton start, char1, char2, char3, level1, level2, level3;
    Image img;
    
    public SplashScreen() {
        
        setLayout(new GridLayout(6, 1));
        
        start = new JButton("Start Game");
        char1 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/yoshi-green.jpg")));
        char2 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/yoshi-yellow.jpg")));
        char3 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/yoshi-blue.jpg")));
       
        
        level1 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/background1-button.jpg")));
        level2 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/background2-button.jpg")));
        level3 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/background3-button.jpg")));
        
        add(start);
        add(char1);
        add(char2);
        add(char3);
        add(level1);
        add(level2);
        add(level3);
        setVisible(true);
       setSize(600,800);
       start.addActionListener(this);
       char1.addActionListener(this);
       char2.addActionListener(this);
       char3.addActionListener(this);
       level1.addActionListener(this);
       level2.addActionListener(this);
       level3.addActionListener(this);
       
       
       setDefaultCloseOperation(EXIT_ON_CLOSE);
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object obj = e.getSource();
      switch (obj.toString()) {
          
          
      }
    }
    
    
}
