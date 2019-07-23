package com.string;

import java.util.HashMap;

public class Substrings {
    // A Suffix Trie (A Trie of all suffixes) Node
    static class SuffixTrieNode {
	static final int MAX_CHAR = 26;
	SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];

	SuffixTrieNode() // Constructor
	{
	    // Initialize all child pointers as NULL
	    for (int i = 0; i < MAX_CHAR; i++)
		children[i] = null;
	}

	// A recursive function to insert a suffix of the s in
	// subtree rooted with this node
	void insertSuffix(String s) {
	    // If string has more characters
	    if (s.length() > 0) {
		// Find the first character and convert it
		// into 0-25 range.
		char cIndex = (char) (s.charAt(0) - 'a');

		// If there is no edge for this character,
		// add a new edge
		if (children[cIndex] == null)
		    children[cIndex] = new SuffixTrieNode();

		// Recur for next suffix
		children[cIndex].insertSuffix(s.substring(1));
	    }
	}
    }

    // A Trie of all suffixes
    static class Suffix_trie {
	static final int MAX_CHAR = 26;
	SuffixTrieNode root;

	// Constructor (Builds a trie of suffies of the given text)
	Suffix_trie(String s) {
	    root = new SuffixTrieNode();

	    // Consider all suffixes of given string and insert
	    // them into the Suffix Trie using recursive function
	    // insertSuffix() in SuffixTrieNode class
	    for (int i = 0; i < s.length(); i++)
		root.insertSuffix(s.substring(i));
	}

	// A recursive function to count nodes in trie
	int _countNodesInTrie(SuffixTrieNode node) {
	    // If all characters of pattern have been processed,
	    if (node == null)
		return 0;

	    int count = 0;
	    for (int i = 0; i < MAX_CHAR; i++) {

		// if children is not NULL then find count
		// of all nodes in this subtrie
		if (node.children[i] != null)
		    count += _countNodesInTrie(node.children[i]);
	    }

	    // return count of nodes of subtrie and plus
	    // 1 because of node's own count
	    return (1 + count);
	}

	// method to count total nodes in suffix trie
	int countNodesInTrie() {
	    return _countNodesInTrie(root);
	}

    }

    // Returns count of distinct substrings of str
    static int countDistinctSubstring(String str) {
	// Construct a Trie of all suffixes
	Suffix_trie sTrie = new Suffix_trie(str);

	// Return count of nodes in Trie of Suffixes
	return sTrie.countNodesInTrie();
    }

    static int[] countSubstrings(String s, int[][] queries) {
	/*
	 * Write your code here.
	 */
	int[] result = new int[queries.length];
	HashMap<String, Integer> hashMap = new HashMap<>();
	for (int i = 0; i < queries.length; i++) {
	    int startIdx = queries[i][0];
	    int endIdx = queries[i][1];
	    // System.out.println(s.substring(startIdx, endIdx+1));
	    String substr = s.substring(startIdx, endIdx + 1);
	    char[] strArr = substr.toCharArray();
	    if (!hashMap.containsKey(substr)) {
		result[i] = subString(strArr, strArr.length);
		hashMap.put(substr, result[i]);
	    } else
		result[i] = hashMap.get(substr);
	}
	return result;
    }

    // Java program to print all possible
    // substrings of a given string

    // Function to print all sub strings
    static int subString(char str[], int n) {
	// Pick starting point
	HashMap<String, Integer> hashMap = new HashMap<>();
	int result = 0;
	for (int len = 1; len <= n; len++) {
	    // Pick ending point
	    for (int i = 0; i <= n - len; i++) {
		// Print characters from current
		// starting point to current ending
		// point.
		int j = i + len - 1;
		String substring = "";
		StringBuilder strb = new StringBuilder();
		for (int k = i; k <= j; k++) {
		    strb.append(str[k]);
		}
		substring = strb.toString();
		if (!hashMap.containsKey(substring)) {
		    hashMap.put(substring, 1);
		    result += 1;
		}
	    }
	}
	return result;
    }

    static int subString(String str, int n) {
	// Pick starting point
	HashMap<String, Integer> hashMap = new HashMap<>();
	int result = 0;
	for (int i = 0; i < n; i++)
	    for (int j = i + 1; j <= n; j++)
		if (!hashMap.containsKey(str.substring(i, j))) {
		    hashMap.put(str.substring(i, j), 1);
		    result += 1;
		}
	return result;
    }

    // Driver program to test above function
    public static void main(String[] args) {
	char str[] = { 'a', 'b', 'a', 'a' };
	subString(str, str.length);
	System.out.println(subString("abaa", "abaa".length()));
	System.out.println(countDistinctSubstring("abaa"));
    }
}
// This code is contributed by PrinciRaj1992
