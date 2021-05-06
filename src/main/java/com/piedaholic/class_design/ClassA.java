package com.piedaholic.class_design;

import java.util.Objects;

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


    public int getInteger() {
        return this.integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public String getString() {
        return this.string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public ClassA integer(int integer) {
        setInteger(integer);
        return this;
    }

    public ClassA string(String string) {
        setString(string);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClassA)) {
            return false;
        }
        ClassA classA = (ClassA) o;
        return integer == classA.integer && Objects.equals(string, classA.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(integer, string);
    }

    @Override
    public String toString() {
        return "{" +
            " integer='" + getInteger() + "'" +
            ", string='" + getString() + "'" +
            "}";
    }


}
