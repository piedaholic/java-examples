package com.piedaholic.examples;

public class ArrayExamples {

    public static void main() {
        array_declaration_examples();
    }

    public static void array_declaration_examples() {
        int two_d_array[][] = new int[2][]; // COMPILES
        // int two_d_array[][] = new int[][2]; // DOES NOT COMPILE
        two_d_array = new int[2][2];
        two_d_array = new int[3][5];
        two_d_array = new int[3][];
        // String beans[] = new String[6]; // COMPILES
        // String beans[] = new beans[6]; // Invalid declaration
        // java.util.Date[] dates[] = new java.util.Date[2][]; // COMPILES
        // java.util.Date[] dates[] = new java.util.Date[][2]; // DOES NOT COMPILE
        // int[][] types = new int[]; // DOES NOT COMPILE
        // int[][] java = new int[][]; // DOES NOT COMPILE

    }

}
