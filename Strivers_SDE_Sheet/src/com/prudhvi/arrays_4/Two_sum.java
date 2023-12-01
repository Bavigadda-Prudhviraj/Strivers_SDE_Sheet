package com.prudhvi.arrays_4;

import java.util.Arrays;
import java.util.HashMap;

public class Two_sum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] indicices=twoSum(nums, target);
		System.out.println(Arrays.toString(indicices));

	}
	/*
	This code solves the Two Sum problem efficiently using a HashMap. 
	The problem asks to find two numbers in an array that add up to a specific target
	
	Time Complexity:
		The time complexity is O(n), where n is the length of the array.
		The code iterates through the array once, and each HashMap operation (insertion and lookup) takes constant time on average.
	Space Complexity:
		The space complexity is O(n), where n is the length of the array.
		The HashMap stores at most n elements, where each element has a constant-size entry in the map.
	
	 */
    public static int[] twoSum(int[] nums, int target) {
    	//Initialize a HashMap to store elements and their indices.
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
        	//For each element, calculate the remaining sum needed to reach the target.
            int remainingSum=target-nums[i];
            //Check if the HashMap contains the remaining sum.
            if(map.containsKey(remainingSum)){
            	//If it does, return the indices of the two numbers that add up to the target.
                return new int[]{i,map.get(remainingSum)};
            }
            //If the remaining sum is not found in the HashMap, add the current element and its index to the HashMap.
            map.put(nums[i],i);
        }
        //If no solution is found during the iteration, return null to indicate that there are no such indices.
        return null; 
    }

}
