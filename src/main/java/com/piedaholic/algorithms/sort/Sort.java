package com.piedaholic.algorithms.sort;

public class Sort {

   public static void main(String[] args) {
        int[] arr = {9,15,16,29,4,-4,0,156,101,201};
        heapSort(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void heapSort(int[] arr){
        createMaxHeap(arr);
        int heapSize = arr.length-1;
        for (int i=0;i<arr.length/2-1;i++){
            swap(arr, i, heapSize);
            heapSize -= 1;
            maxHeapify(arr, 0, heapSize); 
        }
    }

    public static void createMaxHeap(int[] arr){
        for (int i=arr.length-1; i >=0; i--){
            maxHeapify(arr, i, arr.length);
        }
    }

    public static void maxHeapify(int[] arr, int idx, int heapSize){
        if (idx > arr.length)
            return;
        int left  = 2*idx + 1;
        int right = 2*idx + 2;

        int greatest = idx;

        if (left < heapSize && arr[left] > arr[idx])
            greatest = left;
        
        if (right < heapSize && arr[right] > arr[idx])
            greatest = right;
        
        if (greatest != idx){
            swap(arr, greatest, idx);
            maxHeapify(arr, greatest, heapSize);
        }

    }

    public static void minHeapify(int[] arr, int idx, int heapSize){
        if (idx > arr.length)
            return;
        int left  = 2*idx + 1;
        int right = 2*idx + 2;

        int greatest = idx;

        if (left < heapSize && arr[left] < arr[idx])
            greatest = left;
        
        if (right < heapSize && arr[right] < arr[idx])
            greatest = right;
        
        if (greatest != idx){
            swap(arr, greatest, idx);
            maxHeapify(arr, greatest, heapSize);
        }

    }

    public static void swap(int[] arr, int idx1, int idx2){
        arr[idx1] = arr[idx1] + arr[idx2];
        arr[idx2] = arr[idx1] - arr[idx2];
        arr[idx1] = arr[idx1] -arr[idx2];
    }
    
}
