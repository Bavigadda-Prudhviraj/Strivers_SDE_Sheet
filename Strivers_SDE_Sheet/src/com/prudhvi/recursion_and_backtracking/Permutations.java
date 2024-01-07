package com.prudhvi.recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
		

	}
	public static List<List<Integer>> permute(int[] nums) {
	    // List to store all permutations
	    List<List<Integer>> allPermutations = new ArrayList<>();
	    // Call the recursive function to generate permutations
	    generateAllPermutations(0, nums, allPermutations);
	    // Return the list of all permutations
	    return allPermutations;
	}

	public static void generateAllPermutations(int index, int[] nums, List<List<Integer>> allPermutations) {
	    // Base case: If the index reaches the length of the array, add the current permutation to the list
	    if (index == nums.length) {
	        // Create a new ArrayList to store the current permutation
	        ArrayList<Integer> currentPermutation = new ArrayList<>();
	        // Add elements to the current permutation
	        for (int i = 0; i < nums.length; i++) 
	            currentPermutation.add(nums[i]);	       
	        // Add the current permutation to the list of all permutations
	        allPermutations.add(new ArrayList<>(currentPermutation));
	        return;
	    }

	    // Recursive step: Try swapping elements to generate permutations
	    for (int i = index; i < nums.length; i++) {
	        // Swap elements at indices i and index
	        swap(i, index, nums);	       
	        // Recursively generate permutations with the updated index
	        generateAllPermutations(index + 1, nums, allPermutations);	        
	        // Backtrack: Swap elements back to the original positions
	        swap(i, index, nums);
	    }
	}

	public static void swap(int i, int j, int[] nums) {
	    // Swap elements at indices i and j in the array
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}

	/*
	Time Complexity: O(N! X N) N! for generating all permutations.  n for adding current elements into all permutations.
	Space Complexity: O(n) for used Array.
	 */
	public List<List<Integer>> permuteTakeMoreSC(int[] nums) {
		// List to store all permutations
		List<List<Integer>> allPermutations = new ArrayList<>();
		// List to store the current permutation being generated
		List<Integer> currentPermutation = new ArrayList<>();
		// Array to keep track of whether an element has been used in the current permutation
		boolean[] used = new boolean[nums.length];
		// Call the recursive function to generate permutations
		generateAllPermutations(nums, allPermutations, currentPermutation, used);
		// Return the list of all permutations
		return allPermutations;
	}

	public static void generateAllPermutations(int[] nums, List<List<Integer>> allPermutations, List<Integer> currentPermutation, boolean[] used) {
		// Base case: If the current permutation is of the same length as the input array, add it to the list
		if (currentPermutation.size() == nums.length) {
			allPermutations.add(new ArrayList<>(currentPermutation));
			return;
		}
		// Recursive step: Try adding each unused element to the current permutation
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				// Mark the element as used
				used[i] = true;
				// Add the element to the current permutation
				currentPermutation.add(nums[i]);
				// Recursively generate permutations with the updated currentPermutation
				generateAllPermutations(nums, allPermutations, currentPermutation, used);
				// Backtrack: Mark the element as unused and remove it from the currentPermutation
				used[i] = false;
				currentPermutation.remove(currentPermutation.size() - 1);
			}
		}
	}


}
