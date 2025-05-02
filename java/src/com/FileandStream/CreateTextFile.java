package com.FileandStream;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    private static Formatter outputFormatter;

    public static void main(String[] args) {
        openFile();
        addRecords();
        closeFile();

    }

    public static void openFile() {
        try {
            outputFormatter = new Formatter("/Users/datnh0710/Desktop/test.txt");
        } catch (SecurityException err) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // terminate the program
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminate the program
        }
    }

    public static void addRecords() {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s%n%s%n? ",
                "Enter account number, first name, last name and balance.", "Enter end-of-file indicator to end input.");
        while (input.hasNext()) {
            try {
                // output new record to file; assumes valid input
                outputFormatter.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error writing to file. Terminating.");
                break;
            } catch (NoSuchElementException elementException) {
                System.err.println("Invalid input. Please try again.");
                input.nextLine(); // discard input so user can try again
            }
            System.out.print("? ");
        }

    }

    public static void closeFile() {
        if (outputFormatter != null) {
            outputFormatter.close();
        }
    }
}
