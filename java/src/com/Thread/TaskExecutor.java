package com.Thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    public static void main(String[] args) {
        PrintTask tast1 = new PrintTask("task1");
        PrintTask tast2 = new PrintTask("task2");
        PrintTask tast3 = new PrintTask("task3");

        System.out.println("Starting Executor");

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(tast1);
        executorService.execute(tast2);
        executorService.execute(tast3);

        executorService.shutdown();

        System.out.printf("Tasks started, main ends.%n%n");

    }
}
