package com.piedaholic.concurrency;

import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Runner {
    public static void main(String... args) {
        // print_num_1_10();
        // test_Runnable();
        // test_Runnable_using_Thread();
        runMultithread();
        startMultithread();
        try {
            checkResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
    }

    private static void test_Runnable() {
        CustomRunnable runner = new CustomRunnable();
        runner.run();
    }

    private static void test_Runnable_using_Thread() {
        new Thread(new CustomRunnable()).start();
    }

    /*-
    Be careful with code that attempts to start a thread by calling run() instead of start(). 
    Calling run() on a Thread or a Runnable does not actually start a new thread. 
    While the following code snippet will compile, 
    none will actually execute a task on a separate thread:
    */

    static void runMultithread() {
        System.out.println("run_multithread() starts");
        new Thread(new CustomRunnable()).run();
        new Thread(new CustomRunnable()).run();
        new Thread(new CustomRunnable()).run();
        System.out.println("run_multithread() stops");
    }

    static void startMultithread() {
        System.out.println("start_multithread() starts");
        new Thread(new CustomRunnable()).start();
        new Thread(new CustomRunnable()).start();
        new Thread(new CustomRunnable()).start();
        System.out.println("start_multithread() stops");
    }

    private static void print_num_1_10() {
        Runnable print = () -> {
            int i = 1;
            while (i <= 10) {
                System.out.println(i);
                ++i;
            }
            ;
        };
        print.run();
    }

    static int counter = 0;

    static void checkResults() throws InterruptedException {
        new Thread(() -> {
            for (int i = 1; i < 501; i++)
                counter++;
        }).start();
        while (counter < 100) {
            System.out.println("Not reached 100 now : " + ZonedDateTime.now());
            Thread.sleep(1); // delay of 1 ms
        }
        System.out.println("Reached 100 now : " + ZonedDateTime.now());
    }
}
