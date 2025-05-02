package com.FileandStream;

import com.homework.Account;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadSequentialFile {
    private static ObjectInputStream input;

    public static void main(String[] args) {
        openFile();
        readRecord();
        closeFile();
    }
    static void openFile(){
        try {
            input = new ObjectInputStream(Files.newInputStream(Paths.get("/Users/datnh0710/Desktop/test.ser")));
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminate the program
        }
    }
    static void readRecord(){
        System.out.printf("%12s%10s%n",  "Name", "Balance");
        try{
            while (true){
                Account record= (Account) input.readObject();
                // display record contents
                System.out.printf("%12s%20.2f%n", record.getName(), record.getAmount());
            }
        } catch (EOFException eofException){
            System.out.printf("No more records%n");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void closeFile() {
        try{
            if (input != null) {
                input.close();
            }
        } catch (IOException ioException) {

            System.err.println("Error closing file. Terminating.");
        }

    }
}
