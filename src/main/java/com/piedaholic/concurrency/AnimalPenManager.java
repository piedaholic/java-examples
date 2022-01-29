package com.piedaholic.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnimalPenManager {

    public static void main(String[] args) {
        final int THREAD_POOL = 4;
        AnimalPenManager manager = new AnimalPenManager();
        CyclicBarrier c1 = new CyclicBarrier(THREAD_POOL,()-> System.out.println("Removed all animals from their pens!!"));
        CyclicBarrier c2 = new CyclicBarrier(THREAD_POOL, ()-> System.out.println("All Pens Cleaned!!"));

        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL);
        for (int i=0;i<THREAD_POOL;i++)
            service.submit(()-> {
                try {
                    manager.performTask(c1,c2);
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
    }

    private void removeAnimalsFromPen(){
        System.out.println("Removing Animals From Their Pens");
    }

    private void cleanPen(){
        System.out.println("Cleaning The Pen");
    }

    private void bringAnimalsBackToPen(){
        System.out.println("Bringing Animals Back To Their Pens");
    }

    private void performTask(CyclicBarrier c1, CyclicBarrier c2) throws BrokenBarrierException, InterruptedException {
        removeAnimalsFromPen();
        c1.await();
        cleanPen();
        c2.await();
        bringAnimalsBackToPen();
    }
}
