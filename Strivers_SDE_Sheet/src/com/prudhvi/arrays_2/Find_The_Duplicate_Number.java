package com.prudhvi.arrays_2;

public class Find_The_Duplicate_Number {

	public static void main(String[] args) {
		int[] nums= {1,3,4,2,1};
		int duplicateNum=findDuplicate(nums);
		System.out.println(duplicateNum);
		

	}
	/*
	Time Complexity:
		The time complexity is O(n), where n is the length of the array. 
		In the worst case, the algorithm may need to traverse the entire array to detect the cycle.

	Space Complexity:
		The space complexity is O(1) because the algorithm only uses a constant amount of extra space for the pointers (slow and fast).
	 */
    public static int findDuplicate(int[] nums) {
    	// Initialize slow and fast pointers to the first element
    	//The slow pointer moves one step at a time, and the fast pointer moves two steps at a time.
        int slow=nums[0];
        int fast=nums[0];
        //The slow pointer moves one step at a time, and the fast pointer moves two steps at a time.
        do{
        	slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);//If there is a duplicate element in the array, the pointers will eventually meet within a cycle.
        
        //Once a cycle is detected, the fast pointer is reset to the first element of the array.
        fast=nums[0];
        
        //Both pointers move one step at a time until they meet again. The meeting point is the entry point of the cycle.
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        //The meeting point (where slow and fast meet) is the duplicate element.
        return slow;
    }
        

}
