package com.Class4401;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author datnh0710
 * @created 26/03/2022 - 10:51 AM
 * @packege com.Class4401
 * @project java
 */
public class Question1_hw2_multi_thread {
    // Thread Pool --> to execute task
    private ExecutorService t_pool;
    // control number prime
    private long number;
    // how many thread in the thread pool
    private int numberOfThreads;
    private long[] startValues;
    private long[] endValues;

    Question1_hw2_multi_thread(long number, int numberOfThreads){
        this.number = number;
        this.numberOfThreads = numberOfThreads;
        parsing_number();

        // start time
        long startTime;


        //entering to multithreading
        startTime = System.currentTimeMillis();
        runThreads();
        while (!t_pool.isTerminated()) // Wait for threads to finish
            ;
        System.out.printf("This took: %s ms. \n",  System.currentTimeMillis() - startTime);
        //end  multithreading

    }
    public static void main(String[] args) {
        Question1_hw2_multi_thread mt_version2= new Question1_hw2_multi_thread(69881631850817231L, 2);
    }

    private void parsing_number(){
        startValues = new long[numberOfThreads];
        endValues = new long[numberOfThreads];

        t_pool = Executors.newFixedThreadPool(numberOfThreads);
        long iterator = (long)(Math.sqrt(number) / numberOfThreads);

        // put startValues and endValues into array
        for (int i = 0; i < numberOfThreads; i++) {
            if (i == 0) {
                startValues[i] = 3;
            } else {
                startValues[i] = endValues[i - 1] + 1;
            }
            endValues[i] = startValues[i] + iterator;

        }

    }
    private void runThreads(){
        // execute ThreadTask
        try {
            for (int i = 0; i < numberOfThreads; i++)
                t_pool.execute(new ThreadWorker(number, startValues[i], endValues [i]));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("runThreads: threads pool error!...");
        }
    }

    class ThreadWorker implements Runnable{
        private long number;
        // start checking
        private long startValue;
        // stop checking
        private long endValue;


        ThreadWorker(long number, long startValue, long endValue){
            this.number = number;
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            if (this.number % 2 == 0){
                t_pool.shutdown();
                System.out.printf("%s is not a prime number. \n", number);
            }
            for (long i = startValue; i <= endValue; i = i+2){
                if (number % i == 0)
                {
                    t_pool.shutdown();
                    System.out.printf("%s is not a prime number. \n", number);

                }
            }
            if (endValue == endValues[numberOfThreads - 1]) { // check it is the last thread --> shut down pool
                t_pool.shutdown();
                System.out.printf("%s is a prime number. \n", number);

            }
        }
    }
}
