package com.piedaholic.ds.linear.array;

/*-
Array binary search rules
Scenario 	                                Result
Target element found in sorted array 	    Index of match
Target element not found in sorted array 	Negative value showing one smaller than the negative of the index, where a match needs to be inserted to preserve sorted order
Unsorted array 	                            A surprise—this result isn’t predictable
*/

/*-
Array comparison return values

    A negative number means the first array is smaller than the second.
    A zero means the arrays are equal.
    A positive number means the first array is larger than the second.


Array comparison rules
If both arrays are the same length and have the same values in each spot in the same order, return zero.
If all the elements are the same but the second array has extra elements at the end, return a negative number.
If all the elements are the same but the first array has extra elements at the end, return a positive number.
If the first element that differs is smaller in the first array, return a negative number.
If the first element that differs is larger in the first array, return a positive number.

null is smaller than any other value.
For numbers, normal numeric order applies.
For strings, one is smaller if it is a prefix of another.
For strings/characters, numbers are smaller than letters.
For strings/characters, uppercase is smaller than lowercase.

First array 	    Second array 	        Result 	            Reason
new int[] {1, 2} 	new int[] {1} 	        Positive number 	The first element is the same, but the first array is longer.
new int[] {1, 2} 	new int[] {1, 2} 	    Zero 	            Exact match
new String[] {"a"} 	new String[] {"aa"} 	Negative number 	The first element is a substring of the second.
new String[] {"a"} 	new String[] {"A"} 	    Positive number 	Uppercase is smaller than lowercase.
new String[] {"a"} 	new String[] {null} 	Positive number 	null is smaller than a letter.

Method 	    When arrays are the same 	When arrays are different
equals() 	true 	                    false
compare() 	0 	                        Positive or negative number
mismatch() 	-1 	                        Zero or positive index
*/

/*
 * 
 * An array does not override equals(), so it uses object equality. Calling
 * equals() on two equivalent arrays returns false
 */