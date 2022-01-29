package com.piedaholic.algorithms.sort;

import java.util.Random;

public class Sort {

    public static void swap(int[] arr, int idx1, int idx2) {
        /*-
         * arr[idx1] = arr[idx1] + arr[idx2];
         * arr[idx2] = arr[idx1] - arr[idx2];
         * arr[idx1] = arr[idx1] - arr[idx2];
         */
        int swap = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = swap;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }

    public static void heapSortDesc(int[] arr) {
        buildMinHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            minHeapify(arr, 0, i);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    public static void buildMinHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            minHeapify(arr, i, arr.length);
        }
    }

    private static void maxHeapify(int[] arr, int idx, int heapSize) {
        if (idx > arr.length) return;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        int greatest = idx;

        if (left < heapSize && arr[left] > arr[greatest]) greatest = left;

        if (right < heapSize && arr[right] > arr[greatest]) greatest = right;

        if (greatest != idx) {
            swap(arr, greatest, idx);
            maxHeapify(arr, greatest, heapSize);
        }

    }

    private static void minHeapify(int[] arr, int idx, int heapSize) {
        if (idx > arr.length) return;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        int least = idx;

        if (left < heapSize && arr[left] < arr[least]) least = left;

        if (right < heapSize && arr[right] < arr[least]) least = right;

        if (least != idx) {
            swap(arr, least, idx);
            minHeapify(arr, least, heapSize);
        }

    }

    public static void insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }
    }

    public static void optimisedBubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean swapped = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
                swapped = true;
            }

            if (!swapped) break;
        }
    }

    public static void bubbleSortDesc(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] < arr[j + 1]) swap(arr, j, j + 1);
            }
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        int len = arr.length;
        if (start == end) return;
        else if (start == end - 1) {
            if (arr[start] > arr[end]) swap(arr, start, end);
        } else {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }


    }

    private static void merge(int arr[], int start, int mid, int end) {
        int[] mergedArr = new int[end - start + 1];
        int i = start, j = mid + 1, index = 0;
        for (; i <= mid && j <= end; ) {
            if (arr[i] <= arr[j]) {
                mergedArr[index] = arr[i];
                i++;
                index++;
            } else if (arr[i] > arr[j]) {
                mergedArr[index] = arr[j];
                j++;
                index++;
            }
        }
        for (; j <= end; ) {
            mergedArr[index] = arr[j];
            j++;
            index++;
        }

        for (; i <= mid; ) {
            mergedArr[index] = arr[i];
            i++;
            index++;
        }
        for (int l = 0; l < mergedArr.length; l++) {
            arr[start + l] = mergedArr[l];
        }
    }

    public static int[] countingSort(int[] arr, int capacity) {
        int[] count = new int[capacity];
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        return output;
    }

    public static void radixSort(int[] arr, int capacity) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) max = i;
        }


        int digits = 0;
        int mod = max % 10;

        while (max != 0 && mod != 0) {
            digits++;
            max = max / 10;
            mod = max % 10;
        }


        //int digits = String.valueOf(max).length();
        int ctr = 0;
        int base = 1;
        while (ctr < digits) {
            radixCountingSort(arr, base);
            base = base * 10;
            ctr++;
        }


    }

    private static void radixCountingSort(int[] arr, int base) {
        int[] count = new int[10];
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / base) % 10] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / base) % 10] - 1] = arr[i];
            count[(arr[i] / base) % 10]--;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = output[i];
        }
    }

    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int partition = partition(arr, start, end);
        quicksort(arr, start, partition - 1);
        quicksort(arr, partition + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int index = start - 1;

        for (int i = start; i < end; i++) {
            if (arr[i] <= arr[end]) {
                index++;
                swap(arr, index, i);
            }
        }
        swap(arr, index + 1, end);
        return index + 1;
    }

}
