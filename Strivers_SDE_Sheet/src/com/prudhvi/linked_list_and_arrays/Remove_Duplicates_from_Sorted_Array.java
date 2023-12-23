package com.prudhvi.linked_list_and_arrays;

import java.util.Arrays;



public class Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		int[] nums = { 0,0,1,1,1,2,2,3,3,4 };
		int uniqueNums = removeDuplicates(nums);
		System.out.println(uniqueNums);
		System.out.println(Arrays.toString(nums));

	}
	/*
	This method removes duplicates from a sorted array in-place using a two-pointer approach. 
	It maintains a pointer i to keep track of the position where unique elements should be placed. 
	The loop iterates through the array, and whenever a new unique element is encountered, it is placed in the correct position, and the pointer i is updated. 
	The final result is an array with unique elements, and the function returns the count of unique elements.
	
	Time Complexity:
		The time complexity is O(N), where N is the length of the nums array. The algorithm iterates through the array once with two pointers.
	
	Space Complexity:
		The space complexity is O(1) since the algorithm uses only a constant amount of extra space. The modifications are done in-place.
	 */
    public static int removeDuplicates(int[] nums) {
    	// If the array is empty, there are no duplicates to remove, return 0
        if(nums.length == 0){
            return 0;
        }
        // Initialize a pointer 'i' to keep track of the position where unique elements should be placed
        int i = 0;
        // Iterate through the array starting from the second element (j = 1)
        for(int j = 1; j < nums.length; j++){
        	// If the current element at index 'i' is different from the element at index 'j'
            if(nums[i] != nums[j]){
                i++; // Move the pointer 'i' to the next position
                nums[i] = nums[j]; // Place the unique element at index 'j' at the new position indicated by 'i'
            }
        }
        // The value of 'i' represents the last index with a unique element,
        // so the total number of unique elements is 'i + 1'
        return i+1;
    }

}
