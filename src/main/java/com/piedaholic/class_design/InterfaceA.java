package com.piedaholic.class_design;

public interface InterfaceA {
    int MAX = 1; // final, static and public keywords are implicit

    void funcA(); // public, abstract keywords are implicit

    // If the methods have the implementations defined in the interface itself,
    // method must be static.
    // private static methods allowed but does not make sense to have it
    /*-
    private static String funcB() {
        return "Hello World!";
    }
    */

    static String funcB() {
        return "Hello World!";
    } // public is implicit

}
