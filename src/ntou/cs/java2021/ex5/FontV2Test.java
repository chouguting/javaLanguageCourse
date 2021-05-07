package ntou.cs.java2021.ex5;

// Test program for font display.

import javax.swing.JFrame;

public class FontV2Test {
    public static void main(String[] args) {
        FontFrameV2 myFontFrame = new FontFrameV2();
        myFontFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFontFrame.setSize(400, 200); // set frame size
        myFontFrame.setVisible(true); // display frame
    }
} // end class FontTest
