package com.Thread;

import java.util.List;

public class ConsumerQueue implements Runnable {
    private final List<Integer> taskQueue;

    public ConsumerQueue(List<Integer> taskQueue) {
        this.taskQueue = taskQueue;
    }


    @Override
    public void run() {
        while (true){
            try{
                consume();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.isEmpty()) {
                System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }

            Thread.sleep(1000);
            int i = taskQueue.remove(0);
            System.out.println("Consumed: " + i);
            taskQueue.notifyAll();
        }
    }
}
