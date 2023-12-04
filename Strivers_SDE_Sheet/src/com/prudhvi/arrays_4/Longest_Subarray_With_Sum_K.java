package com.prudhvi.arrays_4;

public class Longest_Subarray_With_Sum_K {

	public static void main(String[] args) {
		int[] a = {1,2,3,1,1,1,1};
		int k = 3;
		int maxLen=longestSubarrayWithSumK(a, k);
		System.out.println(maxLen);
	}
	/*
	This methods finds the length of the longest subarray with a given sum k. 
	It uses a sliding window approach to efficiently handle this problem
	
	Time Complexity:
		The algorithm has a time complexity of O(n), where n is the length of the input array a.
		Both left and right pointers move from 0 to n at most once.
	Space Complexity:
		The space complexity is O(1), as the algorithm uses a constant amount of extra space for variables, regardless of the input size.
	 */
    public static int longestSubarrayWithSumK(int []a, long k) {

        int n = a.length;//Length of the input array a.
    	//left and right: Pointers defining the current sub array.
        int left = 0;
        int right = 0;
        int maxLength = 0;// Variable to store the length of the longest sub array with sum k.
        long currentSum = a[0];//Variable to store the sum of the current sub array.
        //The outer loop moves the right pointer through the array, expanding the sub array.
        while( right < n ){
        	//This loop contracts the sub array by moving the left pointer until currentSum becomes less than or equal to k.
           while(left <= right && currentSum > k){
               currentSum -=a [left];
               left++; 
           }
           //After contracting the sub array, check if currentSum equals the target sum k.
           if(currentSum == k){
        	   //If true, update maxLength with the maximum length.
               maxLength = Math.max(maxLength, right-left+1);
           }

           right++;//Move the right pointer to expand the sub array.
           //If right is within the array bounds, update currentSum by adding the element at the new right position.
           if(right < n){
               currentSum += a[right];
           }
        }
        return maxLength;
    }

}
