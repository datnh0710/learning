package com.Thread;


import java.util.List;

public class ProducerQueue implements Runnable {
    private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;

    public ProducerQueue(List<Integer> taskQueue, int max) {
        this.taskQueue = taskQueue;
        MAX_CAPACITY = max;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true){
            try{
                produce(counter++);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

    }

    private void produce(int i) throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.size() == MAX_CAPACITY) {
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }

            Thread.sleep(1000);
            taskQueue.add(i);
            System.out.println("Produced: " + i);
            taskQueue.notifyAll();
        }
    }
}
