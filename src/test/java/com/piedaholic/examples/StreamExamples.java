package com.piedaholic.examples;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String...args){
        create_streams();
        create_parallel_streams();
    }

    public static void create_streams(){
        // Creates empty stream
        Stream<Integer> stream = Stream.empty();
        // var stream = Stream.empty();
        BinaryOperator<Integer> mul = (a,b) -> a*b ;
        stream.reduce(mul).ifPresent(System.out::println);

        Stream<String> stringStream = Stream.of("H","a","r","s","h");
        List<Integer> integerList = List.of(5,4,3,2,1);
        Stream<Integer> integerStream = Stream.of(100, 0, 1, 95, 2, 87, 3);

        // System.out.println(stringStream.reduce("",(s,c)->s+c));
        System.out.println(stringStream.reduce("",String::concat));
        integerStream.sorted().forEach((x)->System.out.print(x + " "));
        // integerStream = Stream.of("H","a","r"); // Does not compile

        integerStream = integerList.stream();
        integerStream.sorted().forEach((x)->System.out.print(x + " ")); 
        //Infinite streams
        //Stream<Double> randoms = Stream.generate(Math::random);
        //Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        // Adding limit() transformed infinite streams to finite ones
        Stream.generate(Math::random).limit(5).forEach(System.out::print);
        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2).limit(10);
        oddNumbers.forEach((x)->System.out.print(x + " "));
        Stream.iterate(9, n->(n<101) , n->n+2).forEach((x)->System.out.print(x + " "));
    }

    public static void create_parallel_streams(){
        var int_list = List.of(1,2,3,4);
        var intStream = int_list.parallelStream();
        intStream.filter((x)->x>1).forEach((x)->System.out.print(x + " "));
    }
    
}
