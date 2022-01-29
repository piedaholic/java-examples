package com.piedaholic.concurrency;

public class ProducerConsumerImpl {

    boolean receiving = false;
    int n;

    public synchronized void receive() {
        if (!receiving) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Received:" + this.n);
        receiving = false;
        notify();
    }

    public synchronized void send(int n){
        if (receiving) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n =n;
        receiving = true;
        notify();
    }
}
