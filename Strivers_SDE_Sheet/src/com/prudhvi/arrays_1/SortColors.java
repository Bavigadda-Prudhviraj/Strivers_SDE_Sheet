package com.prudhvi.arrays_1;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		int[] arr= {2,0,2,1,1,0}; 
		System.out.println(Arrays.toString(arr));

	}
	/*
	This method implements the "Dutch National Flag" algorithm to sort an array containing only 0, 1, and 2. 
	The goal is to rearrange the elements in ascending order.
	
	Time Complexity: O(N), where N = size of the given array.
					Reason: We are using a single loop that can run at most N times.

	Space Complexity: O(1) as we are not using any extra space.
	 */
    public static void sortColors(int[] nums) {
        int n=nums.length;
        int low=0;// low points to the position where the next 0 should be placed.
        int mid=0;//mid is the current position being processed.
        int high=n-1;//high points to the position where the next 2 should be placed.
        //Using a while loop to iterate through the array until mid crosses high.
        while(mid<=high){
        	//If nums[mid] is 0, swap nums[low] and nums[mid], and increment both low and mid.
            if(nums[mid]==0){
                int temp=nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                low++;
                mid++;
            }
            //If nums[mid] is 1, just increment mid (since 1s should stay in the middle).
            else if(nums[mid]==1)
                mid++;
            //If nums[mid] is 2, swap nums[mid] and nums[high], and decrement high.
            else if(nums[mid]==2){
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }

}
