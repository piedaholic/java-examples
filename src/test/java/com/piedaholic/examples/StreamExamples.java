package com.piedaholic.examples;

import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String...args){
        create_streams();
        create_parallel_streams();
    }

    public static void create_streams(){
        // Stream<String> stream = Stream.empty();
        var stream = Stream.empty();
        stream = Stream.of("H","a","r","s","h");
        stream = Stream.of(1,2,3);
        Stream<Integer> integerStream = Stream.of(1,2,3);
        // integerStream = Stream.of("H","a","r"); // Does not compile
        List<Object> integerList = List.of(1,2,3);
        stream = integerList.stream();
        //Infinite streams
        //Stream<Double> randoms = Stream.generate(Math::random);
        //Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        // Adding limit() transformed infinite streams to finite ones
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2).limit(10);
        oddNumbers.forEach(System.out::println);
        Stream.iterate(10, n->(n<101) , n->n+1).forEach(System.out::println);
    }

    public static void create_parallel_streams(){
        var int_list = List.of(1,2,3,4);
        var intStream = int_list.parallelStream();
        intStream.filter((x)->x>1).forEach(System.out::println);
    }
    
}
