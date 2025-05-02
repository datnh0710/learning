package com.Class4401;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author datnh0710
 * @created 28/03/2022 - 9:35 AM
 * @packege com.Class4401
 * @project java
 */
public class Question2_hw2_single_thread {
    //private static final String filePath = "/Users/datnh0710/Downloads/small_data.txt";
    //private static final String filePath = "/Users/datnh0710/Downloads/small_data_1.txt";
    //private static final String filePath = "/Users/datnh0710/Downloads/enwik9_1";
    private static final String filePath = "/Users/datnh0710/Downloads/1000_line";
    //private static Map<String, Integer> world_freq = new HashMap<>();
    private static Map<Integer, AtomicInteger> world_freq = new HashMap<>();
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
        // start time
        long startTime = System.currentTimeMillis();
        Question2_hw2_single_thread question2_hw2_single_thread = new Question2_hw2_single_thread();
        question2_hw2_single_thread.parseLine(filePath);
        question2_hw2_single_thread.printResult(world_freq);
        // end time
        long endTime = System.currentTimeMillis() - startTime;
        System.out.printf("This took: %s ms. \n", endTime);
        System.out.printf("Total Word: " + count);
    }


    public void parseLine(String filePath) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        Map<String, Integer> tmp_wf = new HashMap<>();
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

            String eachLine;
            while ((eachLine = bufferedReader.readLine()) != null) {
                String formatLine = filterCharacter(eachLine);
                //System.out.printf(formatLine);
                ThreadWorker(formatLine);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }

    }

    public String filterCharacter(String line) {
        if (line.length() == 0)
            return "";
        return line.replaceAll("[^a-zA-Z_0-9-]", " ");
    }

    //    public void printResult(Map<String, Integer> wf) {
//        wf.forEach((key, value) -> System.out.println(key + ": " + value ));
//    }
    public void printResult(Map<Integer, AtomicInteger> wf) {
        wf.forEach((key, value) -> System.out.println(key + " letters - " + value + ", " + (((float) value.intValue() / count.intValue()) * 100)));
    }

    public synchronized void ThreadWorker(String eachLine) {
        String[] eachLineWords = eachLine.split(" ");
        for (String eachWord : eachLineWords) {
            int key = eachWord.length() >= 8 ? 8 : eachWord.length();
            if (eachWord.equals("")) {
                continue;
            }
            if (world_freq.containsKey(key)) {
                world_freq.replace(key, new AtomicInteger(world_freq.get(key).incrementAndGet()));
            }
            world_freq.putIfAbsent(key, new AtomicInteger(1));
            count.incrementAndGet();
        }
    }

}
