package com.piedaholic.examples;

public class Example3 {
    private String str;

    // Primitive Datatypes Initialization
    private int integer;
    private boolean bool;
    private float float_num;
    private long long_num;
    private double double_num;
    private byte byte_var;
    private short short_num;
    private char char_var;

    public static void main(String... args) {
        Example3 obj = new Example3();
        System.out.println("Default Initialization of String variable is " + obj.str);
        System.out.println("Default Initialization of integer variable is " + obj.integer);
        System.out.println("Default Initialization of boolean variable is " + obj.bool);
        System.out.println("Default Initialization of float variable is " + obj.float_num);
        System.out.println("Default Initialization of long variable is " + obj.long_num);
        System.out.println("Default Initialization of double variable is " + obj.double_num);
        System.out.println("Default Initialization of byte variable is " + obj.byte_var);
        System.out.println("Default Initialization of short variable is " + obj.short_num);
        System.out.println("Default Initialization of char variable is " + obj.char_var);
        // obj.short_num = 5L; // cannot convert from long to short
        // obj.integer = 5.0; // cannot convert from double to int
        // int integer; // Local variables must be initialized
        // System.out.println(integer); // Does not compile as integer local variable
        // was not initialized
        obj.float_num = 5.0f;
        obj.float_num--;
        System.out.println(obj.float_num);
    }

}
