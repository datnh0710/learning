package com.FileandStream;

import com.homework.Account;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CreateSequentialFile {
    private static ObjectOutputStream output;

    public static void main(String[] args) {
        openFile();
        addRecord();
        closeFile();

    }

    static void openFile() {
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("/Users/datnh0710/Desktop/test.ser")));
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminate the program
        }

    }

    static void addRecord() {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s%n%s%n? ",
                "name and balance.", "Enter end-of-file indicator to end input.");
        while (input.hasNext()) {
            try {
                Account account = new Account(input.next(), input.nextDouble());
                output.writeObject(account);
            } catch (IOException ioException) {
                System.err.println("Invalid input. Please try again.");
                input.nextLine(); // discard input so user can try again
            }
            System.out.printf("? ");

        }
    }

    static void closeFile() {
        try{
            if (output != null) {
                output.close();
            }
        } catch (IOException ioException) {

            System.err.println("Error closing file. Terminating.");
        }

    }
}
