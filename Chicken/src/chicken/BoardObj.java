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

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author hwf5000
 */
public abstract class BoardObj extends JLabel {
    
    Point location;
    int height;
    int width;
    ImageIcon graphic;
    
    public BoardObj(ImageIcon g){
        graphic = g;
        height = graphic.getIconHeight();
        width = graphic.getIconWidth();
    }
    
    // All board objects must be able to detect collision with another object.
    abstract int collisioncheck(BoardObj obj1, BoardObj obj2);
    
    // Most board objects move around in some way .
    abstract void moveTo(Point p);
    
}