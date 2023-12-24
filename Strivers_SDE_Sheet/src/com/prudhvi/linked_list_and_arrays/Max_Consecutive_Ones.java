package com.prudhvi.linked_list_and_arrays;

public class Max_Consecutive_Ones {

	public static void main(String[] args) {
		int[] nums = { 1,1,0,1,1,1 };
		int maxConsecutiveOnes =  findMaxConsecutiveOnes(nums);
		System.out.println( maxConsecutiveOnes);

	}
	/*
	This method finds the maximum consecutive ones streak in an array of 0s and 1s. 
	It iterates through the array, updating the currentStreak based on the current element (1 or 0). 
	Whenever a 0 is encountered, the current streak is reset to 0. 
	The maximum streak is updated by taking the maximum of the current streak and the existing maximum. 
	The final result is the maximum consecutive ones streak.
	
	Time Complexity:
		The time complexity is O(N), where N is the length of the nums array. The algorithm iterates through the array once.

	Space Complexity:
		The space complexity is O(1) since the algorithm uses only a constant amount of extra space. The variables currentStreak and maxStreak are used to store intermediate results.
	 */
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
