package com.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CircularBufferTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CircularBuffer shareLocation = new CircularBuffer();

        shareLocation.displayState("Initial State");

        executorService.execute(new Producer(shareLocation));
        executorService.execute(new Consumer(shareLocation));

        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.MINUTES);

    }
}
