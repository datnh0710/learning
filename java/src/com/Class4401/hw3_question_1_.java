package com.Class4401;

import java.util.concurrent.*;

/**
 * @author datnh0710
 * @created 13/04/2022 - 4:22 PM
 * @packege com.Class4401
 * @project java
 */
public class hw3_question_1_ {
    private static ExecutorService pool;
    private static int philosophersNumber = 3;
    private static hw3_question_1.Philosopher array_philos[] = new hw3_question_1.Philosopher[philosophersNumber];
    private static hw3_question_1.Fork forks[] = new hw3_question_1.Fork[philosophersNumber];
    //private static int time = 60000;
    private static int time = 6000;


    static class Fork {
        public Semaphore mutex = new Semaphore(1);

        public void takeFork() {
            try {
                mutex.acquire();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        public void release_fork() {
            mutex.release();
        }

        public boolean isAvailable() {
            return mutex.availablePermits() > 0;
        }
    }

    static class Philosopher implements Runnable {
        int number;
        public hw3_question_1.Fork left_fork;
        public hw3_question_1.Fork right_fork;
        volatile int thinking_time;
        volatile int eating_time;
        volatile int waiting_time;

        public int getThinking_time() {
            return thinking_time;
        }

        public int getEating_time() {
            return eating_time;
        }

        public int getWaiting_time() {
            return waiting_time;
        }


        Philosopher(int number, hw3_question_1.Fork left, hw3_question_1.Fork right) {
            this.number = number;
            this.left_fork = left;
            this.right_fork = right;
            this.thinking_time = 0;
            this.eating_time = 0;
            this.waiting_time = 0;
        }


        public void take_fork(hw3_question_1.Fork fork, int dir, boolean br_rule) {
            if (fork.isAvailable() && br_rule == false) {
                fork.takeFork();
                System.out.println("Philosopher #" + number + " picked " + " fork " + (dir == 1 ? number : number + 1));
            } else {
                if (br_rule == true)
                    fork.release_fork();
                int sleepTime = ThreadLocalRandom.current().nextInt(50, 100);
                try {
                    System.out.println("Philosopher #" + number + " tried to pick " + " fork " + (dir == 1 ? number : number + 1) + " its unavailable");
                    Thread.sleep(sleepTime);
                    take_fork(fork, dir, dir == 1 ? false : true);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            try {
                System.out.println("Hi! I'm philosopher #" + number);
                long starTime = System.currentTimeMillis();
                long endTime = starTime + time;

                while (System.currentTimeMillis() <= endTime) {

                    //think
                    thinking(starTime);
                    //entering
                    System.out.println("Philosopher #" + number + ", Time:  " + (System.currentTimeMillis() - starTime) + " ms," + " entering hungry state");

                    // take a left fork
                    while (true) {
                        if (left_fork.isAvailable()) {
                            left_fork.takeFork();
                            System.out.println("Philosopher #" + number + ", Time:  " + (System.currentTimeMillis() - starTime) + " ms," + " pick the left fork " + number);
                            break;
                        } else {
                            int sleepTime = ThreadLocalRandom.current().nextInt(50, 100);
                            this.waiting_time += sleepTime;
                            try {
                                System.out.println("Philosopher #" + number + ", Time:  " + (System.currentTimeMillis() - starTime) + " ms," + " tried to pick up the left fork " + number + ", its unavailable");
                                Thread.sleep(sleepTime);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    // take a right fork
                    int i = 0;
                    boolean flag = false;
                    while (true) {
                        if (right_fork.isAvailable()) {
                            right_fork.takeFork();
                            System.out.println("Philosopher #" + number + ", Time:  " + (System.currentTimeMillis() - starTime) + " ms," + " pick the right fork " + ((number + philosophersNumber - 1) % philosophersNumber));
                            flag = false;
                            break;

                        } else {
                            if (i == 1) {
                                left_fork.release_fork();
                                System.out.println("Philosopher #" + number + ", Time:  " + (System.currentTimeMillis() - starTime) + " ms," + " drop the left fork " + number);
                                flag = true;
                                break;
                            }
                            int sleepTime = ThreadLocalRandom.current().nextInt(50, 100);
                            this.waiting_time += sleepTime;
                            try {

                                System.out.println("Philosopher #" + number + ", Time:  " + (System.currentTimeMillis() - starTime) + " ms," + " tried to pick up the right fork " + ((number + philosophersNumber - 1) % philosophersNumber) + ", its unavailable");
                                Thread.sleep(sleepTime);
                                i++;

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    if (i == 1 && flag == true) {
                        int sleepTime = ThreadLocalRandom.current().nextInt(50, 100);
                        this.waiting_time += sleepTime;
                        try {
                            Thread.sleep(sleepTime);
                            continue;

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                    eat();
                    left_fork.release_fork();
                    System.out.println("Philosopher #" + number + ", Time:  " + (System.currentTimeMillis() - starTime) + " ms," + " drop the left fork " + number);
                    right_fork.release_fork();
                    System.out.println("Philosopher #" + number + ", Time:  " + (System.currentTimeMillis() - starTime) + " ms," + " drop the right fork " + ((number + philosophersNumber - 1) % philosophersNumber));
                }
            } finally {
                System.out.println("Philosopher #" + number + ", Eating Time:  " + this.eating_time);
                System.out.println("Philosopher #" + number + ", Waiting Time:  " + this.waiting_time);
                System.out.println("Philosopher #" + number + ", Thinking Time:  " + this.thinking_time);
            }


        }

        void eat() {
            try {
                int sleepTime = ThreadLocalRandom.current().nextInt(10, 40);
                this.eating_time = eating_time + sleepTime;
                System.out.println("Philosopher #" + number + ", entering eating state. Will eat for " + sleepTime + " ms");
                Thread.sleep(sleepTime);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        void thinking(long starTime) {
            try {
                System.out.println("Philosopher #" + number + ", Time:  " + (System.currentTimeMillis() - starTime) + " ms" + " thinking for " + 10 + " ms");
                this.thinking_time += 10;
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }


    }

    public static void main(String argv[]) throws InterruptedException {

        for (int i = 0; i < philosophersNumber; i++) {
            forks[i] = new hw3_question_1.Fork();
        }

//        pool = Executors.newFixedThreadPool(philosophersNumber);
//        // execute  ThreadWorker
//        try {
//            for (int i = 0; i < philosophersNumber; i++)
//                pool.execute(new Philosopher(i, forks[i], forks[(i + philosophersNumber - 1) % philosophersNumber]));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println("Could not execute the threads in the pool...");
//        }
//
//        pool.shutdown();
//        pool.awaitTermination(2, TimeUnit.MINUTES);

        for (int i = 0; i < philosophersNumber; i++) {
            int eating = array_philos[i].getEating_time();
            int thinking = array_philos[i].getThinking_time();
            int waiting = array_philos[i].getWaiting_time();
            System.out.println("Philosopher #" + i + ", Total Time:  " + (eating + thinking + waiting));
        }


        Thread.sleep(6500);
        System.out.println("Bye!");
        System.exit(0);
    }
}
