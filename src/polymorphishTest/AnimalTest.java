package polymorphishTest;

import javax.swing.*;

/**
 *
 */
public class AnimalTest {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.makeSound();
        Cat cat = new Cat();
        cat.前進();

        Object aa = 6;
        Object bb = animal;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        JTextField textField = new JTextField();

        frame.add(textField);


        frame.setVisible(true);


        System.out.println(aa);
    }
}
