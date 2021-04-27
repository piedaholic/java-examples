package com.piedaholic.examples;

public class MathExamples {

    public static void main(String... args) {
        random_num_generator();
        math_abs_examples();
        math_ceil_examples();
        math_floor_examples();
        math_pow_examples();
    }

    public static void math_round_examples() {
        // The round() method returns an int when called with a float.
        // The round() method returns a long when called with a double.
        int int_num = Math.round(1);
        int_num = Math.round(1.2f);
        // int_num = Math.round(1.2); // DOES NOT COMPILE // long returned
    }

    public static void random_num_generator() {
        // Math.random() returns a double datatype
        // int num = Math.random(); // DOES NOT COMPILE
        // float num = Math.random(); // DOES NOT COMPILE
        // long num = Math.random(); // DOES NOT COMPILE
        double random_num = Math.random();
        System.out.println(random_num);
        System.out.println((int) random_num); // floored to nearest integer
        System.out.println((float) random_num);
        System.out.println((long) random_num); // floored to nearest long
    }

    public static void math_ceil_examples() {
        double num = Math.ceil(-1.2);
        System.out.println(num);
    }

    public static void math_floor_examples() {
        double num = Math.floor(-1.2);
        System.out.println(num);
    }

    public static void math_abs_examples() {
        int int_num = Math.abs(-1234);
        System.out.println(int_num);

        long long_num = Math.abs(-1234567L);
        System.out.println(long_num);

        double double_num = Math.abs(-0.126567);
        System.out.println(double_num);

        float float_num = Math.abs(-6.789101112f);
        System.out.println(float_num);

    }

    public static void math_pow_examples() {
        // Math.pow(a, b) return a double datatype
        // int num = Math.pow(1, 2); // DOES NOT COMPILE
        // float num = Math.pow(2, 8); // DOES NOT COMPILE
        double num = Math.pow(2, 8);
        System.out.println(num);
    }

}
