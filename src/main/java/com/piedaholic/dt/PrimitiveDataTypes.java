package com.piedaholic.dt;

public class PrimitiveDataTypes {
    public static void main(String... args) {
        int_dt_examples();
        double_dt_examples();
    }

    public static void short_dt_examples() {
        short number = 'd';
        System.out.println(number);
    }

    public static void int_dt_examples() {
        int num; // 32 bits allocated // Range from -2^32 to 2^32-1
        int million1 = 1000000;
        int million2 = 1_000_000; // Underscores are allowed in literals for clarity
        // You can add underscores anywhere except at the beginning of a literal, the
        // end of a literal, right before a decimal point, or right after a decimal
        // point. You can even place multiple underscore characters next to each other
        System.out.println(million1 + " vs " + million2);
    }

    public static void long_dt_examples() {
        // long max = 3123456789; // DOES NOT COMPILE
        long max = 3123456789L;
    }

    public static void char_dt_examples() {
        char character = (short) 83;
        System.out.println(character);
        character = (short) -1;
    }

    public static void double_dt_examples() {
        // double notAtStart = _1000.00; // DOES NOT COMPILE
        // double notAtEnd = 1000.00_; // DOES NOT COMPILE
        // double notByDecimal = 1000_.00; // DOES NOT COMPILE
        double annoyingButLegal = 1_00_0.0_0; // Ugly, but compiles
        double reallyUgly = 1__________2; // Also compiles

    }
}
