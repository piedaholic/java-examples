package com.piedaholic.class_design;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Test;

public class TestClassB {

    @Test
    public void givenMultiThread_whenStaticSyncMethod() {
        ExecutorService es = Executors.newCachedThreadPool();
        final String className  =  "com.piedaholic.class_design.ClassA";
        ClassB classB = new ClassB();
        // System.out.println(LocalDateTime.now().toString());
        IntStream.range(0, 100).forEach(count -> es.submit(() -> {
            System.out.println( Thread.currentThread()+ " " + /*hash +*/ " " + classB.entityCountMap.get(className));
            final Object obj = classB.init(className);
            int hash = System.identityHashCode(obj);
            System.out.println( Thread.currentThread()+ " " + /*hash +*/ " " + classB.entityCountMap.get(className));
        }
        ));
        try {
            es.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void givenSingleThread_whenStaticSyncMethod() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        final String className  =  "com.piedaholic.class_design.ClassA";
        ClassB classB = new ClassB();
        IntStream.range(0, 100).forEach(count -> es.submit(() -> {
            classB.init(className);
            System.out.println(classB.entityCountMap.get(className));
        }
        ));
        try {
            es.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
