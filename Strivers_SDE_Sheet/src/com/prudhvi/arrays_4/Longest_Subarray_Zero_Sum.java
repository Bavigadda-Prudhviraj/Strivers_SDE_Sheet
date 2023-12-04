package com.prudhvi.arrays_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Longest_Subarray_Zero_Sum {

	public static void main(String[] args) {
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,-1,2,-2));
		int maxLength=LongestSubsetWithZeroSum(arr);
		System.out.println(maxLength);
	}
	/*
	This method aims to find the length of the longest sub array with a sum of zero in an ArrayList. 
	It uses a HashMap to efficiently keep track of cumulative sums during the iteration
	
	Time Complexity:
		The algorithm has a time complexity of O(n), where n is the size of the input ArrayList arr.
		The code iterates through the ArrayList once.
	Space Complexity:
		The space complexity is O(n), where n is the size of the input ArrayList arr.
		The HashMap stores unique cumulative sums and their corresponding indices. In the worst case, the size of the HashMap could be the same as the input size.
	 */
	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		int n = arr.size();
        int sum = 0; //Target sum, initialized to zero.
        //HashMap to store cumulative sums and their corresponding indices.
        HashMap<Long,Integer> map = new HashMap<>();
        long currentSum = 0; //Variable to store the cumulative sum of the current subarray.
        int maxLength = 0; //Variable to store the length of the longest subarray with a sum of zero.

        for(int i=0; i<n ; i++){
        	//Add the current element to currentSum.
        	currentSum += arr.get(i);
        	//If currentSum equals the target sum sum, update maxLength with the maximum length.
        	if(sum == currentSum){
        		maxLength = Math.max(maxLength,i+1);    
        	}
        	//Calculate the remaining sum needed to achieve zero sum (remainingSum).
	        long remainingSum  = Math.abs(sum-currentSum);
	        //If the HashMap contains this remaining sum, update maxLength with the maximum length of the subarray.
	        if(map.containsKey(remainingSum)){
	        	maxLength = Math.max( i-map.get(remainingSum),maxLength );
	        }
	        //If the current cumulative sum is not already present in the HashMap, add it with its index.
	        if(!map.containsKey(currentSum)){
	        	map.put(currentSum,i);
	        }
        }
        return maxLength;
	}

}
