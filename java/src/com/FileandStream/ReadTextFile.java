package com.FileandStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {
    private static Scanner input;

    public static void main(String[] args) {
        openFile();
        readRecord();
        closeFile();
    }

    public static void openFile() {
        try {
            input = new Scanner(Paths.get("/Users/datnh0710/Desktop/test.txt"));
        } catch (IOException err) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // terminate the program
        }
    }

    public static void readRecord() {
        System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance");
        try {
            while (input.hasNext()) {
                // display record contents
                System.out.printf("%-10d%-12s%-12s%10.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed. Terminating.");
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file. Terminating.");
        }
    }

    public static void closeFile() {
        if (input != null) {
            input.close();
        }
    }

}
