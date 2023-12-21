package com.prudhvi.linked_list_and_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> triplets = threeSum(nums);
		
		System.out.println(triplets);

	}
	/*
	This method implementation of the threeSum problem in the context of finding all unique triplets in an array that add up to zero. 
	It utilizes a two-pointer approach after sorting the array
	
	Time Complexity:
		The time complexity of this algorithm is O(n^2), where n is the length of the input array. 
	Space Complexity:
		The space complexity is O(1) as it uses a constant amount of extra space.
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		// Sort the input array in ascending order
	    Arrays.sort(nums); 
	    // Initialize a list to store triplets
	    List<List<Integer>> triplets = new ArrayList<>();  
	    
	    // Iterate through the array up to the third-to-last element
	    for (int i = 0; i < nums.length - 2; i++) {
	        // Skip duplicates to avoid duplicate triplets
	        if (i > 0 && nums[i] == nums[i - 1]) 
	            continue;

	        int left = i + 1;  // Set the left pointer to the next element
	        int right = nums.length - 1;  // Set the right pointer to the last element

	        // Use two pointers to find triplets that sum to zero
	        while (left < right) {
	        	// Calculate the current triplet sum
	            long currentSum = (long) (nums[i] + nums[left] + nums[right]);  

	            if (currentSum == 0) {
	                // If the sum is zero, add the triplet to the list
	                List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
	                triplets.add(triplet);

	                // Skip duplicate elements to avoid duplicate triplets
	                while (left < right && nums[left] == nums[left + 1]) 
	                    left++;
	                
	                while (left < right && nums[right] == nums[right - 1]) 
	                    right--;

	                left++;
	                right--;
	            } else if (currentSum < 0)
	                left++;  // If the sum is negative, move the left pointer to the right
	            else
	                right--;  // If the sum is positive, move the right pointer to the left
	        }
	    }

	    return triplets;  // Return the list of triplets
	}


}
