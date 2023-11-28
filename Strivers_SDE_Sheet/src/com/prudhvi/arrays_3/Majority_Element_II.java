package com.prudhvi.arrays_3;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_II {

	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,5,5,5,5,6,6,6,6,6,6,5};
		List<Integer> majorityElemets=majorityElement(nums);
		System.out.println(majorityElemets);

	}
	/*
	This method is to find elements that appear more than ⌊n/3⌋ times in an array, where n is the length of the array. 
	It uses a variation of the Boyer-Moore Voting Algorithm for finding two potential candidates and then verifies their actual counts.
	
	Time Complexity:
		The time complexity of this algorithm is O(n), where n is the length of the array.
	Space Complexity:
		The space complexity is O(1) as the algorithm uses only a constant amount of extra space. The result list is not counted towards the space complexity.
	 */
    public static List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        //These variables are used to keep track of two potential majority elements and their counts.
        int countOne=0,countTwo=0;
        int elementOne=Integer.MIN_VALUE,elementTwo=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
        	//If countOne is 0 and the current element is not equal to elementTwo, update elementOne and set countOne to 1.
            if(countOne==0 && nums[i]!=elementTwo){
                elementOne=nums[i];
                countOne=1;
            }
            //If countTwo is 0 and the current element is not equal to elementOne, update elementTwo and set countTwo to 1.
            else if(countTwo==0 && nums[i]!=elementOne){
                elementTwo=nums[i];
                countTwo=1;
            }
            //If the current element is equal to elementOne, increment countOne.
            else if(nums[i]==elementOne)
                countOne++;
            //If the current element is equal to elementTwo, increment countTwo.
            else if(nums[i]==elementTwo)
                countTwo++;
            //If none of the above conditions match, decrement both countOne and countTwo.
            else{
                countOne--;
                countTwo--;
            }
        }
        countOne=0;countTwo=0;
        //Iterate through the array again and count the occurrences of elementOne and elementTwo.
        for(int i=0;i<n;i++){
            countOne=nums[i]==elementOne?countOne+1:countOne;
            countTwo=nums[i]==elementTwo?countTwo+1:countTwo;
        }
        List<Integer> arr=new ArrayList<>();
         int min = (int)(n / 3) +1;
         //Check if the counts of elementOne and elementTwo are greater than or equal to ⌊ n/3 ⌋ + 1, and add them to the list.
        if(countOne>=min)
            arr.add(elementOne);
        if(countTwo>=min && !arr.contains(elementTwo)){
            arr.add(elementTwo);
        }
        return arr; 
    }

}
