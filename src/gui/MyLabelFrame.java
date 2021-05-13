package gui;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyLabelFrame extends JFrame {
    JComboBox<String> theBox;

    public MyLabelFrame() {
        String[] lists = {"A", "B", "C"};
        theBox = new JComboBox<>(lists);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println(theBox.getSelectedIndex());
                }
            }
        });


        this.add(theBox);
        this.pack();
        this.setVisible(true);
    }
}
