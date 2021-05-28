package ntou.cs.java2021.ex6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class PlayerInfoWriter {
    private static Formatter output; // outputs text to a file
    private String fileName; // target file name

    public PlayerInfoWriter(String fileName) {
        this.fileName = fileName;
    }

    // close file
    public static void closeFile() {
        if (output != null)
            output.close();
    }

    public void addPlayer(String firstName, String lastName, long salary) {
        openFile();
        addRecord(firstName, lastName, salary);
        closeFile();
    }

    public void openFile() {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            output = new Formatter(fw);
        } catch (SecurityException securityException) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // terminate the program
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminate the program
        } catch (IOException e) {
            System.err.println("I/O error. Terminating.");
            System.exit(1); // terminate the program
        }
    }

    // add records to file
    public void addRecord(String firstName, String lastName, long salary) {
        try {
            // output new record to file; assumes valid input
            FileWriter fw = new FileWriter(new File(fileName), true);
            fw.write(String.format("%s %s %,d\n", firstName, lastName, salary));
            fw.close();
        } catch (FormatterClosedException | IOException formatterClosedException) {
            System.err.println("Error writing to file. Terminating.");
        }
    }
}