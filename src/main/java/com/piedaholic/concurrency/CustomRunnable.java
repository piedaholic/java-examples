package com.piedaholic.concurrency;

public class CustomRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("*****Begins****");
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
        System.out.println("*****Ends****");
    }

}
