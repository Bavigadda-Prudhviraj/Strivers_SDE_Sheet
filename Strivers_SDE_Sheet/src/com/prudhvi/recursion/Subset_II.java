package com.prudhvi.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_II {

	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		List<List<Integer>> uniqueSubsetsList = subsetsWithDup(nums);
		System.out.println(uniqueSubsetsList);
		

	}
	/*
	This method generates all unique subsets of an array of integers nums, taking into account duplicate elements. 
	It utilizes a recursive approach to explore different combinations of including or excluding elements while avoiding duplicates
	
	Time Complexity:
		The time complexity is influenced by the sorting step and is generally O(2^n), where n is the length of the input array. 
	Space Complexity
		The space complexity is also O(2^n), as there can be a total of 2^n subsets.
	 */
	public static List<List<Integer>> subsetsWithDup(int[] nums) {

		List<List<Integer>> allUniqueSubsets = new ArrayList<>();
		List<Integer> currentSubset = new ArrayList<>();
		//It sorts the input array nums to handle duplicates efficiently.
		Arrays.sort(nums);
		//It calls the generateUniqueSubsets function to generate unique subsets.
		generateUniqueSubsets(0, nums, allUniqueSubsets, currentSubset);

		return allUniqueSubsets;
	}

	public static void generateUniqueSubsets(int currentIndex, int[] nums, List<List<Integer>> allUniqueSubsets, List<Integer> currentSubset) {
		//The base case checks if the currentIndex is equal to the length of the array. If true, it adds a copy of the current subset to the result and returns.
		if (currentIndex == nums.length) {
			allUniqueSubsets.add(new ArrayList<>(currentSubset));
			return;
		}

		// Include the current element in the subset
		currentSubset.add(nums[currentIndex]);
		generateUniqueSubsets(currentIndex + 1, nums, allUniqueSubsets, currentSubset);

		// Exclude the current element from the subset
		currentSubset.remove(currentSubset.size() - 1);

		// Skip duplicates
		while (currentIndex + 1 < nums.length && nums[currentIndex] == nums[currentIndex + 1]) {
			currentIndex++;
		}

		generateUniqueSubsets(currentIndex + 1, nums, allUniqueSubsets, currentSubset);
	}

}
