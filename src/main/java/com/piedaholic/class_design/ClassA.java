package com.piedaholic.class_design;

public class ClassA {
    int integer; // no access modifier before variable declaration
    String string;

    public ClassA() {

    }

    public ClassA(int integer, String string) {
        this.integer = integer;
        this.string = string;
    }

    protected ClassA(int integer) {
        this.integer = integer;
    }

}
