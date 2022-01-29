package com.piedaholic.ds.linear;

import java.util.Arrays;
import static java.lang.System.out;

public class Array<T extends Comparable> {

    public static void main(String... args) {
        Integer[] arr = {5, 1, -1, -4, -7};
        Array array = new Array(arr);
        out.print(array.search(-6));
    }

    T[] arr;

    public Array(T[] arr) {
        this.arr = arr;
    }


    public int search(T element) {
        Arrays.sort(this.arr); // Array must be sorted before performing the binary search
        return binarySearch(element, 0, this.arr.length - 1);
    }

    private int binarySearch(T value, int start, int end) {
        if (start == end)
            return -1;
        if (arr[start].compareTo(value) == 0)
            return start;
        if (arr[end].compareTo(value) == 0)
            return end;
        int mid = (start + end) / 2;
        if (value.compareTo(this.arr[mid]) == 0)
            return mid;
        else if (value.compareTo(this.arr[mid]) > 0)
            return binarySearch(value, mid + 1, end);
        else
            return binarySearch(value, start, mid);

    }

    public static boolean areEqual(int[] arr1, int[] arr2){
        int len1=arr1.length;
        int len2=arr1.length;
        if (len1!=len2)
            return false;
        int xor = 0;
        for (int i=0;i<arr1.length;i++){
            xor *=  arr1[i]^arr2[i];
        }
        if (xor==0)
            return true;
        else
            return false;
    }

}
