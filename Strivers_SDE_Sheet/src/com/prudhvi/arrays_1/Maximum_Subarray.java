package com.prudhvi.arrays_1;

public class Maximum_Subarray {

	public static void main(String[] args) {
		

	}
/*

	This method code implements the Kadane's algorithm to find the maximum sub array sum. 
	This algorithm efficiently solves the maximum sub array sum problem
	
	Time Complexity:
	-The time complexity of this algorithm is O(n), where n is the length of the input array. It performs a single pass through the array.
	
	Space Complexity:
	-The space complexity is O(1) because the algorithm uses only a constant amount of extra space, regardless of the input size.
 */
	public static int maxSubArray(int[] arr) {
        int maxSum=Integer.MIN_VALUE;
        //This variable keeps track of the sum of the current sub array. It is updated with the addition of each element in the array.
        int currentSum=0;//This variable keeps track of the maximum sub array sum encountered so far.
        //The loop iterates through each element of the array.
        for(int i=0;i<arr.length;i++){
        	//At each step, currentSum is updated by adding the current element. 
            currentSum+=arr[i];
            //maxSum is updated with the maximum of its current value and currentSum. This ensures that it always contains the maximum sub array sum.
            maxSum=Math.max(maxSum,currentSum);
            //If currentSum becomes negative, it is reset to zero because any negative contribution to the sum would only reduce the overall sum.
            if(currentSum<0)
                currentSum=0;
        }
        //Finally, the function returns maxSum, which represents the maximum sum of a subarray.
        return maxSum; 
    }

}
