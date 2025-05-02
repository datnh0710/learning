package com.Class4401;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author datnh0710
 * @created 28/03/2022 - 4:57 PM
 * @packege com.Class4401
 * @project java
 */
public class Question2_hw2_multi_thread {
    //private static final String filePath = "/Users/datnh0710/Downloads/small_data.txt";
    //private static final String filePath = "/Users/datnh0710/Downloads/small_data_1.txt";
    //private static final String filePath = "/Users/datnh0710/Downloads/enwik9_1";
    private static final String filePath = "/Users/datnh0710/Downloads/1000_line";
    private static ExecutorService t_pool = null;
    private static final int numberOfThreads = 1;
    //private static ConcurrentHashMap<String, AtomicInteger> world_freq = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, AtomicInteger> world_freq = new ConcurrentHashMap<>();
    //    private static final Queue<String> queue = new ConcurrentLinkedQueue<>();
    private static Queue<String> queue = new ConcurrentLinkedQueue<>();
    private static BufferedReader br = null;
    private static AtomicInteger count = new AtomicInteger(0);


    public static String filterCharacter(String line) {
        if (line.length() == 0)
            return "";
        return line.replaceAll("[^a-zA-Z_0-9-]", " ");
    }

    public static void printResult() {
        world_freq.forEach((key, value) -> System.out.println(key + " letters - " + value + ", " + (((float) value.intValue() / count.intValue()) * 100)));
    }

    private void runThreads() {
        // execute  ThreadTask
        try {
            for (int i = 0; i < numberOfThreads; i++)
                t_pool.execute(new Question2_hw2_multi_thread.ThreadWorker(queue, world_freq));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Could not execute the threads in the pool...");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        // start time
        long startTime = System.currentTimeMillis();
        // new thread to handle I/O
        new Thread() {
            @Override
            public void run() {
                FileReader fileReader = null;
                try {
                    fileReader = new FileReader(filePath);
                    br = new BufferedReader(fileReader);

                    String eachLine;
                    while ((eachLine = br.readLine()) != null) {
                        queue.add(eachLine);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        while (queue.isEmpty()) {
            Thread.sleep(1);
        }

        t_pool = Executors.newFixedThreadPool(numberOfThreads);
        // execute  ThreadWorker
        try {
            for (int i = 0; i < numberOfThreads; i++)
                t_pool.execute(new ThreadWorker(queue, world_freq));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Could not execute the threads in the pool...");
        }


        t_pool.shutdown();
        t_pool.awaitTermination(2, TimeUnit.MINUTES);
        long endTime = System.currentTimeMillis() - startTime;
        // end time
        printResult();
        System.out.printf("This took: %s ms. \n", endTime);
        System.out.printf("Total Word: " + count);
    }

    public static synchronized void working_Worker(String eachLine) {
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

    static class ThreadWorker implements Runnable {
        private Queue<String> queue;
        //private ConcurrentHashMap<String, AtomicInteger> world_freq;
        private ConcurrentHashMap<Integer, AtomicInteger> world_freq;

        ThreadWorker(Queue<String> queue, ConcurrentHashMap<Integer, AtomicInteger> world_freq) {
            this.queue = queue;
            this.world_freq = world_freq;
        }

//        public synchronized void working_Worker(String eachLine) {
//            String[] eachLineWords = eachLine.split(" ");
//            for (String eachWord : eachLineWords) {
//                int key = eachWord.length() >= 8 ? 8 : eachWord.length();
//                if (eachWord.equals("")) {
//                    continue;
//                }
//                if (world_freq.containsKey(key)) {
//                    world_freq.replace(key, new AtomicInteger(world_freq.get(key).incrementAndGet()));
//                }
//                world_freq.putIfAbsent(key, new AtomicInteger(1));
//                count.incrementAndGet();
//            }
//        }

        @Override
        public void run() {
            while (!queue.isEmpty()) {
                String eachLine = queue.poll();
                String formatLine = filterCharacter(eachLine);
                working_Worker(formatLine);
            }
        }
    }
}
