package ntou.cs.java2021.ex6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalaryViewer extends JFrame {
    private static final String[] COLUME_NAMES = {"Fisrt Name", "Last Name", "Salary"};

    private JTable playersTable;
    private JScrollPane tableWithScrollBar;

    private JPanel recordPanel;
    private JButton addButton;
    private JButton updateButton;

    private PlayerInfoReader reader;
    private PlayerInfoWriter writer;

    // Constructor
    public SalaryViewer() {
        super("Player Salary");

        // create reader and writer
        reader = new PlayerInfoReader("players.txt");
        writer = new PlayerInfoWriter("players.txt");

        recordPanel = new JPanel();
        recordPanel.setLayout(new GridLayout(1, 2));
        addButton = new JButton("Add a Record");
        updateButton = new JButton("Update Table");

        MyEventHandler handler = new MyEventHandler();

        addButton.addActionListener(handler);
        updateButton.addActionListener(handler);

        recordPanel.add(addButton);
        recordPanel.add(updateButton);

        add(recordPanel, BorderLayout.SOUTH);

        fillData();
    }

    private void addPlayer() {
        String firstName;
        String lastName;
        long salary;

        String name = JOptionPane.showInputDialog(this, "Please input the player's name");

        int spaceIndex = name.indexOf(" ");
        if (spaceIndex != -1) {
            firstName = name.substring(0, spaceIndex);
            lastName = name.substring(spaceIndex + 1);
        } else {
            firstName = name;
            lastName = "";
        }

        String salaryString = JOptionPane.showInputDialog(SalaryViewer.this, "Please input the player's salary");

        try {
            salary = Long.valueOf(salaryString);
        } catch (NumberFormatException ex) {
            salary = 0;
        }

        // write a record to the text file
        writer.addRecord(firstName, lastName, salary);

        updateTable();
    }

    private void updateTable() {
        remove(tableWithScrollBar);
        fillData();
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void fillData() {

        // read all records from the text file
        String[][] data = reader.readAllPlayers();

        playersTable = new JTable(data, COLUME_NAMES);
        tableWithScrollBar = new JScrollPane(playersTable);
        add(tableWithScrollBar, BorderLayout.CENTER);
    }

    private class MyEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                addPlayer();
            } else if (e.getSource() == updateButton) {
                updateTable();
            }
        }
    }
}
