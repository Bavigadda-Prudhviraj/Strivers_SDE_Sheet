package com.prudhvi.arrays_1;

import java.util.Arrays;

public class Next_Permutation {

	public static void main(String[] args) {
		int[] arr= {1,2,3};// 1 3 2
		nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
		
	}
/*
	This Method implements the "Next Permutation" algorithm, which generates the lexicographically next greater permutation of a sequence of numbers. The algorithm follows these steps:
	1. Find the largest index `i` such that `nums[i] < nums[i+1]`. If no such index exists, the entire sequence is in descending order, and the next permutation is the reverse of the current one.
	2. Find the largest index `j` such that `nums[j] > nums[i]`.
	3. Swap `nums[i]` with `nums[j]`.
	4. Reverse the sequence from index `i+1` to the end.

	Time Complexity:
	- The algorithm involves a few linear passes through the array, and the `reverse` function has a time complexity of O(n/2), where n is the length of the array.
	- Therefore, the overall time complexity is O(n), where n is the length of the array `nums`.
	
	Space Complexity:
	- The algorithm uses a constant amount of extra space, regardless of the input size. It does not use any data structures that grow with the input.
	- The space complexity is O(1).
	
	In summary, the code efficiently computes the next permutation of the input array in O(n) time with constant space usage.
 */
	public static void nextPermutation(int[] nums) {
		int n=nums.length;
		int index=-1;// Initializes the index to -1.
		//Loop from the second-to-last element to the first element:
		for(int i=n-2;i>=0;i--) {
			//Finds the rightmost element that is smaller than the element to its right. 
			if(nums[i]<nums[i+1]) {
				index=i;
				break;
			}
			//If no such element is found, set index to -1.
		}
		//If index is still -1, it means the array is in descending order, 
		//so the next permutation is the reverse of the array, and the function returns after calling reverse(nums, 0, n-1).
		if(index==-1) {
			reverse(nums, 0, n-1);
			return;
		}
		//Loop from the last element to the index:
		for(int i=n-1;i>index;i--) {
			//Finds the smallest element to the right of index that is greater than nums[index] and swaps them.
			if(nums[index]<nums[i]) {
				int temp=nums[index];
				nums[index]=nums[i];
				nums[i]=temp;
				break;
			}
		}
		//Calls reverse(nums, index+1, n-1) to reverse the subarray to the right of index.
		reverse(nums, index+1,n-1);
	}
	//Reverses the subarray between leftIndex and rightIndex.
	public static void reverse(int[] nums,int leftIndex,int rightIndex) {
		while(leftIndex<rightIndex){
			int temp=nums[leftIndex];
			nums[leftIndex]=nums[rightIndex];
			nums[rightIndex]=temp;
			leftIndex++;
			rightIndex--;
		}
	}

}
