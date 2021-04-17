package com.piedaholic.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

class LCS {
	// Function to find length of Longest Common Subsequence of
	// sequences X[0..m-1] and Y[0..n-1]
	public static int LCSLength(String X, String Y, int m, int n) {
		// return if we have reached the end of either sequence
		if (m == 0 || n == 0) {
			return 0;
		}

		// if last character of X and Y matches
		if (X.charAt(m - 1) == Y.charAt(n - 1)) {
			return LCSLength(X, Y, m - 1, n - 1) + 1;
		}

		// else if last character of X and Y don't match
		return Integer.max(LCSLength(X, Y, m, n - 1), LCSLength(X, Y, m - 1, n));
	}

	// Function to find length of Longest Common Subsequence of substring
	// X[0..m-1] and Y[0..n-1]
	public static int LCSLength(String X, String Y, int m, int n, Map<String, Integer> lookup) {
		// return if we have reached the end of either string
		if (m == 0 || n == 0)
			return 0;

		// construct a unique map key from dynamic elements of the input
		String key = m + "|" + n;

		// if sub-problem is seen for the first time, solve it and
		// store its result in a map
		if (!lookup.containsKey(key)) {
			// if last character of X and Y matches
			if (X.charAt(m - 1) == Y.charAt(n - 1)) {
				lookup.put(key, LCSLength(X, Y, m - 1, n - 1, lookup) + 1);

			} else {
				// else if last character of X and Y don't match
				lookup.put(key, Integer.max(LCSLength(X, Y, m, n - 1, lookup), LCSLength(X, Y, m - 1, n, lookup)));
			}
		}

		// return the subproblem solution from the map
		return lookup.get(key);
	}

	// Function to find length of Longest Common Subsequence of substring
	// X[0..m-1] and Y[0..n-1]
	public static int LCSLength(String X, String Y) {
		int m = X.length(), n = Y.length();

		// lookup table stores solution to already computed sub-problems
		// i.e. T[i][j] stores the length of LCS of substring
		// X[0..i-1] and Y[0..j-1]
		int[][] T = new int[m + 1][n + 1];

		// fill the lookup table in bottom-up manner
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// if current character of X and Y matches
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					T[i][j] = T[i - 1][j - 1] + 1;
				}
				// else if current character of X and Y don't match,
				else {
					T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
				}
			}
		}

		// LCS will be last entry in the lookup table
		return T[m][n];
	}

	// main function
	public static void main(String[] args) {
		String X = "ABCBDAB", Y = "BDCABA";

		System.out.print("The length of LCS is " + LCSLength(X, Y, X.length(), Y.length()));

		// create a map to store solutions of subproblems
		Map<String, Integer> lookup = new HashMap<>();

		System.out.print("The length of LCS is " + LCSLength(X, Y, X.length(), Y.length(), lookup));

		System.out.print("The length of LCS is " + LCSLength(X, Y));
	}
}