package com.piedaholic.algorithms.sort;

import com.piedaholic.ds.linear.Array;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;
import static com.piedaholic.algorithms.sort.Sort.print;

public class SortTest {

    @Test
    public void heapSort() {
    }

    @Test
    public void heapSortDesc() {
    }

    @Test
    public void buildMaxHeap() {
    }

    @Test
    public void buildMinHeap() {
    }

    @Test
    public void insertionSort() {
    }

    @Test
    public void bubbleSort() {
    }

    @Test
    public void optimisedBubbleSort() {
    }

    @Test
    public void bubbleSortDesc() {
    }

    @Test
    public void mergeSort() {
    }

    @Test
    public void countingSort() {
        int[] arr = new Random().ints().filter(k -> k > 0 && k < 1000).limit(10000).toArray();
        int[] clone = arr.clone();
        Sort.print(arr);
        Arrays.sort(arr);
        Sort.countingSort(clone, 1000);
        assertTrue(Array.areEqual(arr,clone));
        Sort.print(clone);
    }

    @Test
    public void radixSort() {
        int[] arr = new Random().ints().filter(k -> k > 0 && k < 1000).limit(10000).toArray();
        int[] clone = arr.clone();
        Sort.print(arr);
        Arrays.sort(arr);
        Sort.radixSort(clone, 1000);
        assertTrue(Array.areEqual(arr,clone));
        Sort.print(clone);
    }

    @Test
    public void quicksort() {
        int[] arr = new Random().ints().filter(k -> k > -1000 && k < 1000).limit(10000).toArray();
        int[] clone = arr.clone();
        Arrays.sort(arr);
        Sort.quicksort(clone);
        assertTrue(Array.areEqual(arr,clone));
    }
}