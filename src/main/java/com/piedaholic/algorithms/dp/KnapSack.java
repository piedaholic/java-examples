package com.piedaholic.algorithms.dp;

class KnapSack {
	// Values (stored in array v)
	// Weights (stored in array w)
	// Number of distinct items (n)
	// Knapsack capacity W
	public static int knapSack(int[] v, int[] w, int n, int W) {
		// base case: Negative capacity
		if (W < 0) {
			return Integer.MIN_VALUE;
		}

		// base case: no items left or capacity becomes 0
		if (n < 0 || W == 0) {
			return 0;
		}

		// Case 1. include current item n in knapSack (v[n]) and recur for
		// remaining items (n - 1) with decreased capacity (W - w[n])

		int include = v[n] + knapSack(v, w, n - 1, W - w[n]);

		// Case 2. exclude current item n from knapSack and recur for
		// remaining items (n - 1)

		int exclude = knapSack(v, w, n - 1, W);

		// return maximum value we get by including or excluding current item
		return Integer.max(include, exclude);
	}

	// 0-1 Knapsack problem
	public static void main(String[] args) {
		// Input: set of items each with a weight and a value
		int[] v = { 20, 5, 10, 40, 15, 25 };
		int[] w = { 1, 2, 3, 8, 7, 4 };

		// Knapsack capacity
		int W = 10;

		System.out.println("Knapsack value is " + knapSack(v, w, v.length - 1, W));
	}
}