package com.piedaholic.ds.linear.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {

    public static void main(String... args) {
        array_search_examples();
    }

    public static <T> void dbg(T t) {
        System.out.println(t);
    }

    public static <T, K> int searchArray(T[] t, K element) {
        Arrays.sort(t); // Array must be sorted before performing the binary search
        return Arrays.binarySearch(t, element);
    }

    public static void array_search_examples() {
        Integer[] int_array = { 1, 9, 5, 7, 10 };
        dbg(searchArray(int_array, 10)); // Index of match
        dbg(searchArray(int_array, 8)); // Negative value showing one smaller than the negative of the index, where a
                                        // match needs to be inserted to preserve sorted order
    }

}
