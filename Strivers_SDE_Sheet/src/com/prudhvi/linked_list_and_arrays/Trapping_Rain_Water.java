package com.prudhvi.linked_list_and_arrays;

public class Trapping_Rain_Water {

	public static void main(String[] args) {
		int[] heigh = {4,2,0,3,2,5};
		int volumeOfWater = trap(heigh);
		System.out.println(volumeOfWater);
		

	}
	/*
	The provided code is an implementation of the two-pointer approach to solve the trapping rainwater problem. 
	The goal is to calculate the total volume of water that can be trapped between the bars of different heights represented by the height array.
	
	Time Complexity:
		The time complexity is O(N), where N is the length of the height array. The algorithm iterates through the array once with two pointers.
	Space Complexity:
		The space complexity is O(1) since the algorithm uses only a constant amount of extra space.
	 */
    public static int trap(int[] height) {
        int n = height.length; // Get the length of the input array
        int lbh = height[0]; // Initialize the left-boundary height with the height of the first element
        int rbh = height[n-1];  // Initialize the right-boundary height with the height of the last element

        int leftPointer = 0; // Initialize the left pointer
        int rightPointer = n-1; // Initialize the right pointer

        int volumeOfWater = 0; // Initialize the variable to store the total volume of trapped water
        // Used two pointers approach to traverse the array and calculate trapped water
        while(leftPointer <= rightPointer){
        	 // If left-boundary height is less than or equal to right-boundary height
            if(lbh <= rbh){
            	// If the current height at left pointer is greater than or equal to lbh, update lbh
                if(height[leftPointer] >= lbh)
                    lbh = height[leftPointer];
                // Otherwise, add the difference between lbh and current height to the trapped water volume
                else
                    volumeOfWater += (lbh - height[leftPointer]);
                // Move the left pointer to the right
                leftPointer++;
            }
            else{
            	// If right-boundary height is less than left-boundary height
                // If the current height at right pointer is greater than or equal to rbh, update rbh
                if(height[rightPointer] >= rbh)
                    rbh = height[rightPointer];
                // Otherwise, add the difference between rbh and current height to the trapped water volume
                else
                    volumeOfWater += (rbh - height[rightPointer]);
                // Move the right pointer to the left
                rightPointer--;
            }
        }
        // Return the total volume of trapped water
        return volumeOfWater;
    }

}
