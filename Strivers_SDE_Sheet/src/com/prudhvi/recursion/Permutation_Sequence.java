package com.prudhvi.recursion;

import java.util.ArrayList;

public class Permutation_Sequence {

	public static void main(String[] args) {
		System.out.println(getPermutation(5, 25));

	}
	/*
	Time Complexity: O(N) * O(N) = O(N^2)
		Reason: We are placing N numbers in N positions. 
		        This will take O(N) time. For every number, we are reducing the search space by removing the element already placed in the previous step. 
		        This takes another O(N) time.

	Space Complexity: O(N) 
		Reason: We are adding  the numbers in a data structure(here ArrayList)
	 */
	public static String getPermutation(int n, int k) {
		// Initialize factorial to 1
		int factorial = 1;
		// ArrayList to store numbers from 1 to n
		ArrayList<Integer> numbers = new ArrayList<>();
		// Populate the ArrayList with numbers from 1 to n and calculate the factorial
		for (int i = 1; i < n; i++) {
			numbers.add(i);
			factorial *= i;
		}
		// Add the last number to the ArrayList
		numbers.add(n);
		// StringBuilder to store the k-th permutation
		StringBuilder kThPermutation = new StringBuilder();
		// Adjust k to be zero-based
		k = k - 1;
		// Generate the k-th permutation
		while (true) {
			// Append the digit at position k / factorial to the result
			kThPermutation.append(numbers.get(k / factorial));
			// Remove the digit from the ArrayList
			numbers.remove(k / factorial);
			// Break if all digits are used
			if (numbers.size() == 0)
				break;
			// Update k and factorial for the next iteration
			k = k % factorial;
			factorial = factorial / numbers.size();
		}
		// Convert StringBuilder to String and return the result
		return kThPermutation.toString();
	}


}
