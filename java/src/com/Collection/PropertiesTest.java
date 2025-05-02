package com.Collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties table = new Properties();
        // set properties
        table.setProperty("color", "blue");
        table.setProperty("width", "200");
        System.out.println("After setting properties");
        listProperties(table);

        table.setProperty("color", "red");

        System.out.println("After replacing properties");

        listProperties(table);

        saveProperties(table);

        table.clear();

        System.out.println("After clearing properties");
        listProperties(table);

        loadProperties(table);

        // get value of property color
        Object value = table.getProperty("color");
        if (value != null)
            System.out.printf("Property color's value is %s%n", value);
        else
            System.out.println("Property color is not in table");
    }

    private static void loadProperties(Properties table) {
        try {
            FileInputStream input = new FileInputStream("/Users/datnh0710/Desktop/props.dat");
            table.load(input);
            input.close();
            System.out.println("After loading properties");
            listProperties(table);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void saveProperties(Properties table) {
        // save contents of table
        try {
            FileOutputStream output = new FileOutputStream("/Users/datnh0710/Desktop/props.dat");
            table.store(output, "Sample Properties"); // save properties
            output.close();
            System.out.println("After saving properties");
            listProperties(table);
        } catch (FileNotFoundException ioException) {
            ioException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void listProperties(Properties props) {
        Set<Object> keys = props.keySet();
        // output name/value pairs
        for (Object key : keys)
            System.out.printf("%s\t%s%n", key, props.getProperty((String) key));
        System.out.println();
    }
}
