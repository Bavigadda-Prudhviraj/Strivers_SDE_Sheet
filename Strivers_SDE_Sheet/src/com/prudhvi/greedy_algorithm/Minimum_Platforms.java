package com.prudhvi.greedy_algorithm;

import java.util.Arrays;

public class Minimum_Platforms {

	public static void main(String[] args) {
		int n = 3;
		int[] arr= {900, 1100, 1235};
		int[] dep= {1000, 1200, 1240};
		int platForm = findPlatform(arr, dep, n);
		System.out.println( platForm );

	}
	/*
	The method implementation of finding the minimum number of platforms required at a railway station based on the arrival and departure times of trains.
 	and efficiently finds the minimum number of platforms needed at a railway station by sorting the arrival and departure times and then iteratively updating the platform count based on the order of arrivals and departures. 
 	
 	Time Complexity:
		The time complexity is O(N log N), where N is the number of trains. This complexity arises from the sorting of the arrival and departure arrays.
	
	Space Complexity:
		The space complexity is O(1) since the algorithm uses only a constant amount of extra space for variables.
	 */
	static int findPlatform(int arr[], int dep[], int n) {
	    // Sort arrival and departure arrays
	    Arrays.sort(arr);
	    Arrays.sort(dep);

	    int plat_needed = 1;  // Initialize the number of platforms needed to 1
	    int result = 1;  // Initialize the result (minimum number of platforms) to 1
	    int i = 1, j = 0;  // Initialize pointers for arrival and departure arrays

	    // Iterate through the arrival and departure arrays
	    while (i < n && j < n) {
	        // If the next arrival is less than or equal to the current departure
	        if (arr[i] <= dep[j]) {
	            plat_needed++;  // Increment the number of platforms needed
	            i++;  // Move to the next arrival
	        } else if (arr[i] > dep[j]) {
	            plat_needed--;  // Decrement the number of platforms needed
	            j++;  // Move to the next departure
	        }

	        // Update the result (maximum platforms needed at any point)
	        if (plat_needed > result)
	            result = plat_needed;
	    }

	    return result;  // Return the minimum number of platforms needed
	}


}
