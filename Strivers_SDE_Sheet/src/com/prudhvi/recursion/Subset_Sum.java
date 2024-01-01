package com.prudhvi.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Subset_Sum {

	public static void main(String[] args) {
		int[] num = {1, 2};
		ArrayList<Integer> allSubSetsSums = subsetSum(num);
		System.out.println(allSubSetsSums);

	}
	/*
	This below method generates all possible subset sums of an array and returns them in ascending order. It uses a recursive approach to explore all subsets.
	
	Time Complexity
		Recursive Calls:
			1.The calculateAllSubsetSums function is recursive, and it makes two recursive calls for each element in the array.
			2.For each element, there are two recursive branches.
			3.The total number of recursive calls is 2^n, where n is the length of the array.
		ArrayList Operations:
			1.For each recursive call, the code adds a subset sum to the allSubSetsSum ArrayList.
			2.The size of the ArrayList grows with the number of subsets, and in the worst case, there can be 2^n subsets.
		Adding an element to an ArrayList takes constant time on average, but the cumulative time complexity becomes O(2^n) due to the exponential growth.
	
	Space Complexity:
		Recursive Call Stack:
			1.The calculateAllSubsetSums function is recursive, and with each recursive call, a new stack frame is added to the call stack.
			2.The maximum depth of the call stack is equal to the length of the array, n.
			3.Therefore, the space complexity due to the call stack is O(n).
		ArrayList:
			1.The allSubSetsSum ArrayList is used to store subset sums.
			2.The space required by the ArrayList is proportional to the number of subsets, which can be exponential (up to 2^n).
			3.In the worst case, the number of subsets is 2^n, and each subset sum is stored in the ArrayList.
		Therefore, the space complexity due to the ArrayList is O(2^n).
	 */
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> allSubSetsSum = new ArrayList<>();
        //The main function initiates the process by calling the recursive function calculateAllSubsetSums with the initial parameters.
        calculateAllSubsetSums(0, num, num.length, 0, allSubSetsSum);
        //The list of all subset sums is sorted in ascending order.
        Collections.sort(allSubSetsSum);
        return allSubSetsSum;
    }
    // Recursive function to calculate all subset sums
    public static void calculateAllSubsetSums(int index, int[] arr, int n, int sum, ArrayList<Integer> allSubSetsSum) {
    	 // If all elements are considered, add the current sum to the list   
        if (index == n) {
            allSubSetsSum.add(sum);
            return;
        }
        
        // Include the current element and move to the next index
        calculateAllSubsetSums(index + 1, arr, n, sum + arr[index], allSubSetsSum);
        
        // Exclude the current element and move to the next index
        calculateAllSubsetSums(index + 1, arr, n, sum, allSubSetsSum);
    }

}
