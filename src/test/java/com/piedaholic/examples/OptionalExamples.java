package com.piedaholic.examples;

import java.util.Optional;

public class OptionalExamples {
    public static void main(String...args) {
        System.out.println(average());
        System.out.println(average(9,19));
    }
    
    public static Optional<Double> average_Optional(int...args){
        if (args.length == 0)
        return Optional.empty();
        int sum = 0;
        for (int num : args){
            sum += num;
        }
        return Optional.of((double)sum/args.length);
    }

    public static Double average(int...args) {
        Optional<Double> avg = average_Optional(args);
        // return avg.get(); // throws NoSuchElementException
        return avg.orElse(Double.NaN);
        // return avg.orElseThrow(); // throws NoSuchElementException
        // return avg.orElseThrow(()-> new IllegalArgumentException());
        // return avg.orElse(null);
        // return avg.orElseGet(()->Double.NaN);
    }

}
