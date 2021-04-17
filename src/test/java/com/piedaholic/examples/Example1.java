package com.piedaholic.examples;

public class Example1 {
    private String name = "piedaholic";
    {
        System.out.println("Value of field name before calling constructor-->" + this.name);
    }

    public Example1() {
        this.name = "Harsh";
        System.out.println("Constructor Set");
    }

    public static void main(String... args) {
        // System.out.println(this.name); // Cannot be used in a static context
        Example1 obj = new Example1(); // Constructor to be executed here
        System.out.println("Value of field name after calling constructor-->" + obj.name);
    }
}
