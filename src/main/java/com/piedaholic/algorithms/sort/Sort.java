package com.piedaholic.algorithms.sort;

public class Sort {

	public static void main(String[] args) {
		int[] arr = { 9, 15, 16, 29, 4, -4, 0, 156, 101, 201 };
		bubbleSort(arr);
		print(arr);
		bubbleSortDesc(arr);
		print(arr);
		insertionSort(arr);
		print(arr);
		heapSortDesc(arr);
		print(arr);
		heapSort(arr);
		print(arr);
	}

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

	public static void maxHeapify(int[] arr, int idx, int heapSize) {
		if (idx > arr.length)
			return;
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;

		int greatest = idx;

		if (left < heapSize && arr[left] > arr[greatest])
			greatest = left;

		if (right < heapSize && arr[right] > arr[greatest])
			greatest = right;

		if (greatest != idx) {
			swap(arr, greatest, idx);
			maxHeapify(arr, greatest, heapSize);
		}

	}

	public static void minHeapify(int[] arr, int idx, int heapSize) {
		if (idx > arr.length)
			return;
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;

		int least = idx;

		if (left < heapSize && arr[left] < arr[least])
			least = left;

		if (right < heapSize && arr[right] < arr[least])
			least = right;

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
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}

	public static void optimisedBubbleSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			boolean swapped = false;
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
					swapped = true;
			}

			if (!swapped)
				break;
		}
	}

	public static void bubbleSortDesc(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] < arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}

	/*-
	public static int getExponent(int base, int exp){
	    getExponent(base, exp);
	}
	
	public static int getLSB(int num, int i){
	    if (num%)
	    {
	
	    }
	}
	*/

	public static void radixSort(int[] arr) {

	}

}
