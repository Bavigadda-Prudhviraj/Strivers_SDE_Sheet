package com.prudhvi.arrays_4;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {

	public static void main(String[] args) {
		int[] nums = {100,4,200,1,3,2};
		int longestConsecutiveSequence=longestConsecutive(nums);
		System.out.println(longestConsecutiveSequence);

	}
	/*
	This code is solving the "Longest Consecutive Sequence" problem, where the goal is to find the length of the longest consecutive sequence of numbers in an array.
	
	Time Complexity:
		The time complexity is O(n), where n is the number of elements in the array.
		The code iterates through each element in the array once and performs constant time operations during each iteration.
	Space Complexity:
		The space complexity is O(n), where n is the number of elements in the array.
		The HashSet stores all unique elements from the array, and in the worst case, it could be the same size as the input array.
	 */
	public static int longestConsecutive(int[] nums) {
		//Create a HashSet (set) and add all elements of the array (nums) to it. The HashSet is used for efficient lookups.
        Set<Integer> set=new HashSet<>();
        
        for(int i=0; i<nums.length ; i++){
            set.add( nums[i] );
        }

        int longestConsecutive=0;
        //Iterate through each element in the HashSet.
        for( int ele : set ){
        	//For each element, check if it is the start of a potential consecutive sequence. This is determined by checking whether element-1 is present in the HashSet.
            if( !set.contains(ele-1) ){
                int currentConsecutive = 1;
                int currentEle = ele;
                //If it is the start, use a while loop to count consecutive elements:
                while( set.contains( currentEle+1 )){
                    currentConsecutive++;//Increment currentConsecutive.
                    currentEle = currentEle+1;//Update currentEle to the next consecutive element (currentEle + 1).
                }
                //If it is the start, perform a while loop to count the consecutive elements and update the longestConsecutive variable.
                longestConsecutive = Math.max( longestConsecutive,currentConsecutive );
            }
        }
        //Return the length of the longest consecutive sequence.
        return longestConsecutive; 
	}

}
