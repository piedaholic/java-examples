package com.piedaholic.examples;

public class Example2 {

    // Fields and blocks are run first in order

    public Example2() {
        this.name = "Harsh";
    }

    {
        System.out.println("Value of field name before calling constructor-->" + this.name); // This block will be
                                                                                             // executed first
    }

    public static void main(String... args) {
        Example2 obj = new Example2();
        System.out.println("Value of field name after calling constructor-->" + obj.name);
    }

    private String name = "piedaholic";
    {
        System.out.println("Value of field name before calling constructor-->" + this.name);
    }
}
