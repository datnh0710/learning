package com.Class4401;

import java.util.concurrent.ExecutorService;

/**
 * @author datnh0710
 * @created 26/03/2022 - 11:01 AM
 * @packege com.Class4401
 * @project java
 */
public class ThreadTask implements Runnable{
    private long number;
    // start checking if number is prime
    private long startValue;
    // stop checking if number is prime
    private long endValue;

    // thread pool
    private ExecutorService pool;

    // number of thread
    private int numberOfThreads;

    ThreadTask(long number, long startValue, long endValue, ExecutorService t_pool,int numberOfThreads ){
        this.number = number;
        this.startValue = startValue;
        this.endValue = endValue;
        this.pool = t_pool;
        this.numberOfThreads = numberOfThreads;
    }
    @Override
    public void run() {
        if (this.number % 2 == 0){
            pool.shutdown();
            System.out.printf("%s is not a prime number. \n", number);

        }

        for (long i = startValue; i <= endValue; i = i+2){
            if (number % i == 0)
            {
                pool.shutdown();
                System.out.printf("%s is not a prime number. \n", number);

            }
        }
        if (endValue >= this.number) { // check it is the last thread --> shut down pool
            pool.shutdown();
            System.out.printf("%s is a prime number. \n", number);

        }
    }
}
