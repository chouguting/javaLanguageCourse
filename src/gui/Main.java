package gui;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Label("label 1"), BorderLayout.NORTH);
        frame.add(new Label("label 2"), BorderLayout.SOUTH);
        frame.add(new Label("label 3"), BorderLayout.CENTER);
        frame.add(new Label("label 4"), BorderLayout.CENTER);
        frame.add(new Label("label 5"), BorderLayout.WEST);
        frame.add(new Label("label 6"), BorderLayout.EAST);

        ImageIcon imageIcon = new ImageIcon("src/gui/smile.png");

        frame.setVisible(true);
        //new MyLabelFrame();

    }
}
