package ntou.cs.java2021.ex5;

// Displays text using font.

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FontFrameV2 extends JFrame {
    private JButton increaseButton; // button to increase font size
    private JButton decreaseButton; // button to decrease font size
    private JTextArea text; // displays example text
    private int fontSize = 20; // current font size

    public FontFrameV2() {
        super("Font Test");

        MyEventListner handler = new MyEventListner();
        // create buttons and add action listeners
        increaseButton = new JButton("Increase Font size");
        decreaseButton = new JButton("Decrease font size");

        increaseButton.addActionListener(handler);
        decreaseButton.addActionListener(handler);

        // create text area and set initial font
        text = new JTextArea("Test");
        text.setFont(new Font("Consolos", Font.PLAIN, fontSize));

        // add GUI components to frame
        JPanel panel = new JPanel(); // used to get proper layout
        panel.add(decreaseButton);
        panel.add(increaseButton);

        add(panel, BorderLayout.NORTH); // add buttons at top
        add(new JScrollPane(text)); // allow scrolling
    }

    private class MyEventListner implements ActionListener {
        // change font size when user clicks on a button
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == increaseButton) {
                if (fontSize >= 160) {
                    JOptionPane.showMessageDialog(FontFrameV2.this, "No, it cannot be larger!");
                    return;
                }
                fontSize += 2;
                text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
            }
            if (e.getSource() == decreaseButton) {
                if (fontSize <= 8) {
                    JOptionPane.showMessageDialog(FontFrameV2.this, "No, it cannot be smaller!");
                    return;
                }
                fontSize -= 2;
                text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
            }
        }
    }
} // end class EcofontFrame
