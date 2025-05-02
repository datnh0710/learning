package com.Class4401;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author datnh0710
 * @created 25/04/2022 - 10:38 AM
 * @packege com.Class4401
 * @project java
 */
public class hw3_question_2_2 {
    enum State {
        THINKING,
        HUNGRY,
        EATING
    }

    static int N = 4;

    static Semaphore mutex;
    static Semaphore[] sem_philo;
    static State[] states;
    private static int time = 60000;
    //private static int time = 6000;


    static class Philosopher implements Runnable {

        int i;


        int thinking_time;
        int eating_time;
        int waiting_time;

        Philosopher(int number) {
            this.thinking_time = 0;
            this.waiting_time = 0;
            this.eating_time = 0;
            this.i = number;
        }

        public int getThinking_time() {
            return thinking_time;
        }

        public int getEating_time() {
            return eating_time;
        }

        public int getWaiting_time() {
            return waiting_time;
        }


        @Override
        public void run() {
            long starTime = System.currentTimeMillis();
            long endTime = starTime + time;
            states[i] = State.THINKING;

            try {
                while (System.currentTimeMillis() <= endTime) {
                    thinking(i, starTime);
                    try {
                        takeForks(i, starTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    eat(i, starTime);
                    try {
                        putForks(i, starTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                this.waiting_time = time - this.eating_time - this.thinking_time;
                System.out.println("Philosopher #" + i + ", Eating Time:  " + this.eating_time);
                System.out.println("Philosopher #" + i + ", Waiting Time:  " + this.waiting_time);
                System.out.println("Philosopher #" + i + ", Thinking Time:  " + this.thinking_time);
            }

        }

        void thinking(int i, long start_time) {
            try {
                System.out.println("Philosopher #" + (i) + ", Time:  " + (System.currentTimeMillis() - start_time) + " ms, " + " entering thinking for " + 10 + " ms");
                this.thinking_time += 10;
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        void takeForks(int i, long start_time) throws InterruptedException {
            mutex.acquire();
            states[i] = State.HUNGRY;
            System.out.println("Philosopher #" + (i) + ", Time:  " + (System.currentTimeMillis() - start_time) + " entering hungry state!");
            test(i);
            mutex.release();
            sem_philo[i].acquire();
        }

        void eat(int i, long start_time) {
            try {
                int sleepTime = ThreadLocalRandom.current().nextInt(10, 40);
                this.eating_time = eating_time + sleepTime;
                System.out.println("Philosopher #" + (i) + ", Time:  " + (System.currentTimeMillis() - start_time) + ", entering eating state. Will eat for " + sleepTime + " ms");
                Thread.sleep(sleepTime);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        void putForks(int i, long start_time) throws InterruptedException {
            mutex.acquire();
            states[i] = State.THINKING;
            thinking(i, start_time);
            test((i + N - 1) % N);              // left neighbor
            test((i + 1) % N);                  // right neighbor
            mutex.release();
        }


        void test(int i) {
            if (states[i] == State.HUNGRY
                    && states[(i + N - 1) % N] != State.EATING
                    && states[(i + 1) % N] != State.EATING) {
                states[i] = State.EATING;
                sem_philo[i].release();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        mutex = new Semaphore(1);
        sem_philo = new Semaphore[N];
        for (int i = 0; i < N; i++) {
            sem_philo[i] = new Semaphore(0);
        }
        states = new State[N];

        Thread[] philosophers = new Thread[N];
        for (int i = 0; i < N; i++) {
            philosophers[i] = new Thread(new Philosopher(i));
            philosophers[i].start();
        }





    }
}
