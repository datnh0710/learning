package com.Class4401;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author datnh0710
 * @created 12/04/2022 - 9:28 AM
 * @packege com.Class4401
 * @project java
 */

public class hw3_question_2 {
    static enum State {
        THINKING,
        HUNGRY,
        EATING
    }

    static int N = 4;

    static Semaphore mutex;
    static Semaphore[] sem_philo;
    static State[] states;
    //private static int time = 60000;
    private static int time = 6000;
    int thinking_time;
    int eating_time;
    int waiting_time;

    static void philosopher(int i) throws InterruptedException {
        long starTime = System.currentTimeMillis();
        long endTime = starTime + time;
        states[i] = State.THINKING;

        while (System.currentTimeMillis() <= endTime) {
            thinking(i, starTime);
            takeForks(i, starTime);
            eat(i, starTime);
            putForks(i, starTime);
        }
    }

    static void thinking(int i, long start_time) {
        try {
            System.out.println("Philosopher #" + (i) + ", Time:  " + (System.currentTimeMillis() - start_time) + " ms, " + " entering thinking for " + 10 + " ms");
            //this.thinking_time += 10;
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    static void takeForks(int i, long start_time) throws InterruptedException {
        mutex.acquire();
        states[i] = State.HUNGRY;
        System.out.println("Philosopher #" + (i) + ", Time:  " + (System.currentTimeMillis() - start_time) + " entering hungry state!");
        test(i);
        mutex.release();
        sem_philo[i].acquire();
    }

    static void eat(int i, long start_time) {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(10, 40);
            //this.eating_time = eating_time + sleepTime;
            System.out.println("Philosopher #" + (i) + ", Time:  " + (System.currentTimeMillis() - start_time) + ", entering eating state. Will eat for " + sleepTime + " ms");
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    static void putForks(int i, long start_time) throws InterruptedException {
        mutex.acquire();
        states[i] = State.THINKING;
        thinking(i,start_time);
        test((i + N - 1) % N);              // left neighbor
        test((i + 1) % N);                  // right neighbor
        mutex.release();
    }


    static void test(int i) {
        if (states[i] == State.HUNGRY
                && states[(i + N - 1) % N] != State.EATING
                && states[(i + 1) % N] != State.EATING) {
            states[i] = State.EATING;
            sem_philo[i].release();
        }
    }

    public static void main(String[] args) {

        mutex = new Semaphore(1);
        sem_philo = new Semaphore[N];
        for (int i = 0; i < N; i++) {
            sem_philo[i] = new Semaphore(0);
        }
        states = new State[N];

        Thread[] philosophers = new Thread[N];
        for (int i = 0; i < N; i++) {
            final int i1 = i;
            philosophers[i1] = new Thread(new Runnable() {
                public void run() {
                    try {
                        philosopher(i1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            philosophers[i1].start();
        }
    }
}
