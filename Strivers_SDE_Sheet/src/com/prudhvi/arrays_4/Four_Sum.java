package com.prudhvi.arrays_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {

	public static void main(String[] args) {
		int[] nums= {1,0,-1,0,-2,2};
		int target=0;
		List<List<Integer>> quadruple=fourSum(nums, target);
		System.out.println(quadruple);

	}
	/*
	This code is solving the "4Sum" problem, where the goal is to find all unique quadruplets in the array that sum up to a specific target. 
	The code uses a sorted array and employs a two-pointer approach to efficiently find the quadruplets.
	
	Time Complexity:
		The time complexity is O(n^3), where n is the length of the array.
		The code uses nested loops, and within each iteration, it employs a two-pointer approach.
	Space Complexity:
		The space complexity is O(1) since the algorithm uses only a constant amount of extra space for pointers and variables, and the result is not counted in the space complexity.
	 */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
    	//Sort the input array nums. Sorting simplifies the process of finding quadruplets and helps avoid duplicates.
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> quadruple = new ArrayList<>();
        //Use nested loops to iterate through each element in the array (nums).
        for(int i=0 ; i<n-3 ; i++){
            if( i>0 && nums[i] == nums[i-1] ) continue;//check for duplicate elements and continue to the next iteration if duplicates are found.
            //Use pointers j, k, and l to find the remaining two elements for a quadruplet.
            for( int j=i+1 ; j<n-2 ; j++){
                if( j>i+1 && nums[j] == nums[j-1])continue;//check for duplicate elements and continue to the next iteration if duplicates are found.
                //Using a two-pointer approach with pointers k and l to find the remaining two elements.
                int k = j+1;
                int l = n-1;
                while( k<l ){
                    long currentSum = (long) nums[i] + nums[j] + nums[k] + nums[l] ;
                    if( currentSum == target  ){
                    	//Collect valid quadruplets in a list.
                        List<Integer> elements=new ArrayList<>( Arrays.asList( nums[i], nums[j], nums[k], nums[l] ));
                        quadruple.add(elements);
                        k++;
                        l--;
                        while( k<l && nums[k] == nums[k-1] ) k++;
                        while( k<l && nums[l] == nums[l+1] ) l--;
                    }
                    else if( currentSum < target ) k++;
                    else l--;
                }
            }
        }
        return quadruple;
    }
}
