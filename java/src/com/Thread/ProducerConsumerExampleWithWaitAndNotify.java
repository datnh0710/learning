package com.Thread;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExampleWithWaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> taskQueue = new ArrayList<>();
        int MAX_CAPACITY = 5;

//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        executorService.execute(new ProducerQueue(taskQueue, MAX_CAPACITY));
//
//        executorService.execute(new ConsumerQueue(taskQueue));
//
//        executorService.shutdown();
//
//        executorService.awaitTermination(1, TimeUnit.MINUTES);

        Thread producer = new Thread(new ProducerQueue(taskQueue, MAX_CAPACITY), "Producer");
        Thread consumer = new Thread(new ConsumerQueue(taskQueue), "Consumer");
        producer.start();
        consumer.start();
    }
}
