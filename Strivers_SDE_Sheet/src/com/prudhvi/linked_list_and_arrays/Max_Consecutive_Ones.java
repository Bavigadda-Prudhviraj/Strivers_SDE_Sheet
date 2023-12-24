package com.prudhvi.linked_list_and_arrays;

public class Max_Consecutive_Ones {

	public static void main(String[] args) {
		int[] nums = { 1,1,0,1,1,1 };
		int maxConsecutiveOnes =  findMaxConsecutiveOnes(nums);
		System.out.println( maxConsecutiveOnes);

	}
	public static int findMaxConsecutiveOnes(int[] nums) {
		// Variable to track the current consecutive ones streak
	    int currentStreak = 0;  
	    // Variable to store the maximum consecutive ones streak
	    int maxStreak = 0;  

	    // Iterate through the array
	    for (int i = 0; i < nums.length; i++) {
	        // If the current element is 1, increment the current streak; otherwise, reset the streak to 0
	        currentStreak = (nums[i] == 1) ? currentStreak + 1 : 0;

	        // Update the maximum streak by taking the maximum of the current streak and the existing maximum
	        maxStreak = Math.max(maxStreak, currentStreak);
	    }
	    // Return the maximum consecutive ones streak
	    return maxStreak;  
	}


}
