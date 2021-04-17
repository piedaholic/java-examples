package com.piedaholic.algorithms.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps {
	public static int minSwaps(int[] arr) {
		int n = arr.length;
		int result = 0;
		boolean[] traversed = new boolean[n];
		Arrays.fill(traversed, false);
		int[] sortedArr = Arrays.copyOf(arr, n);
		Arrays.sort(sortedArr);
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			hashMap.put(sortedArr[i], i);
		}
		for (int i = 0; i < n; i++) {
			if (!traversed[i]) {
				int nextIndex = i;
				int cycleSize = 0;
				while (!traversed[nextIndex]) {
					traversed[nextIndex] = true;
					nextIndex = hashMap.get(arr[nextIndex]);
					cycleSize += 1;
				}
				result = result + cycleSize - 1;
			}

		}
		return result;
	}

	public static int minSwaps(int[] arr, boolean eitherOrder) {
		int n = arr.length;
		int descResult = 0;
		int ascResult = 0;
		if (eitherOrder) {
			boolean[] traversed = new boolean[n];
			int[] ascSortedArr = Arrays.copyOf(arr, n);
			Arrays.parallelSort(ascSortedArr);
			Map<Integer, Integer> ascHashMap = new HashMap<>();
			Map<Integer, Integer> descHashMap = new HashMap<>();
			for (int i = 0; i < n; i++) {
				ascHashMap.put(ascSortedArr[i], i);
				descHashMap.put(ascSortedArr[i], n - i - 1);
			}
			Arrays.fill(traversed, false);
			for (int i = 0; i < n; i++) {
				if (!traversed[i]) {
					int nextIndex = i;
					int cycleSize = 0;
					while (!traversed[nextIndex]) {
						traversed[nextIndex] = true;
						nextIndex = ascHashMap.get(arr[nextIndex]);
						cycleSize += 1;
					}
					ascResult = ascResult + cycleSize - 1;
				}

			}

			Arrays.fill(traversed, false);
			for (int i = 0; i < n; i++) {
				if (!traversed[i]) {
					int nextIndex = i;
					int cycleSize = 0;
					while (!traversed[nextIndex]) {
						traversed[nextIndex] = true;
						nextIndex = descHashMap.get(arr[nextIndex]);
						cycleSize += 1;
					}
					descResult = descResult + cycleSize - 1;
				}

			}
		}
		return Math.min(ascResult, descResult);

	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 4, 3, 2 };
		System.out.println(minSwaps(a));
		System.out.println(minSwaps(a, true));
	}
}
