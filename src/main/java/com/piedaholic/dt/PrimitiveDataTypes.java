package com.piedaholic.dt;

public class PrimitiveDataTypes {
    public static void main(String... args) {
        byte_dt_examples();
        short_dt_examples();
        int_dt_examples();
        long_dt_examples();
        double_dt_examples();
    }

    public static void boolean_dt_examples() {
        boolean bool;
    }

    public static void short_dt_examples() {
        short number = 'd';
        System.out.println(number);
        number = (short) 1921222; // Stored as 20678
        System.out.println(number);
        short value = Short.MAX_VALUE - 1;
        for (short i = 0; i < 4; i++, value++) {
            System.out.println(value);
        }
    }

    public static void int_dt_examples() {
        int num; // 32 bits allocated // Range from -2^32 to 2^32-1
        int million1 = 1000000;
        int million2 = 1_000_000; // Underscores are allowed in literals for clarity
        // You can add underscores anywhere except at the beginning of a literal, the
        // end of a literal, right before a decimal point, or right after a decimal
        // point. You can even place multiple underscore characters next to each other
        System.out.println(million1 + " vs " + million2);
        // num = 9L; // Cannot be initialized with a long value though in the range of
        // int
        num = (int) 9L; // Works after casting long to integer
        num = (int) 9.0f; // Works after casting float to integer
        num = (int) 9.0; // Works after casting double to integer
        num = 0b11; // Binary value converted to Decimal value
        System.out.println(num);
        num = 0xE;
        System.out.println(num);
        // num = 1.0; // Cannot be initialized with a float value
        int capybara = 2, mouse, beaver = -1; // Multiple assignments
        // System.out.println(mouse);
        int value = Integer.MAX_VALUE - 1;
        for (int i = 0; i < 4; i++, value++) {
            System.out.println(value);
        }
    }

    public static void long_dt_examples() {
        // long max = 3123456789; // DOES NOT COMPILE
        long max = 3123456789L;
    }

    public static void char_dt_examples() {
        char character = (short) 83;
        System.out.println(character);
        // character = (short) -1; // DOES NOT COMPILE
    }

    public static void double_dt_examples() {
        // double notAtStart = _1000.00; // DOES NOT COMPILE
        // double notAtEnd = 1000.00_; // DOES NOT COMPILE
        // double notByDecimal = 1000_.00; // DOES NOT COMPILE
        double annoyingButLegal = 1_00_0.0_0; // Ugly, but compiles
        double reallyUgly = 1__________2; // Also compiles

    }

    public static void byte_dt_examples() {
        byte dt = (byte) -200; // 56 is assigned // Underflow
        System.out.println(dt);
        byte value = Byte.MAX_VALUE - 1;
        for (byte i = 0; i < 4; i++, value++) {
            System.out.println(value);
        }
    }

    public static Object getNumber(Object obj) {
        Object result = null;
        if (((Long) obj > Integer.MAX_VALUE || (Long) obj < Integer.MIN_VALUE)) {
            result = ((Long) obj + Integer.MAX_VALUE) % (Integer.MAX_VALUE + 1);
            result = (Long) result + 1L;
            System.out.println(result);
        }
        return result;

    }
}
