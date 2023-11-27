package com.prudhvi.arrays_3;

public class Majority_Element {
	public static void main(String[] args) {
		int[] nums= {6,5,5};
		int majorityElement=majorityElement(nums);
		System.out.println(majorityElement);
	}
	/*
	The Boyer-Moore Voting Algorithm is an efficient algorithm for finding the majority element in a sequence or array. 
	The majority element is defined as the element that appears more than ⌊n/2⌋ times, where n is the length of the array. 
	The Boyer-Moore Voting Algorithm has a linear time complexity and constant space complexity.
	
	Time Complexity:
		The Boyer-Moore Voting Algorithm has a time complexity of O(n), where n is the length of the array.
	
	Space Complexity:
		The space complexity is O(1) as the algorithm uses only a constant amount of extra space.
	 */
    public static int majorityElement(int[] nums) {
    	// Initialize frequency to 1 and the potential majority element to the first element.
        int frequency=1;
        int element=nums[0];
        // Iterate through the array starting from the second element.
        for(int i=1;i<nums.length;i++){
        	// If the current element is equal to the potential majority element,
            // increment the frequency; otherwise, decrement the frequency.
            frequency=(nums[i]==element)?frequency+1:frequency-1;
            // If the frequency becomes 0, update the potential majority element to
            // the current element and reset the frequency to 1.
            if(frequency==0){
                element=nums[i];
                frequency=1;
            }
        }
        // The final value of 'element' is the majority element in the array.
        return element;
    }

}
