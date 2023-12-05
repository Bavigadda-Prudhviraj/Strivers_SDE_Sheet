package com.prudhvi.arrays_4;

import java.util.HashMap;

public class Subarrays_with_XOR_K {

	public static void main(String[] args) {
		int[] nums= {1,2,3,2};
		int targetXor=2;
		int subArrayCount=subarraysWithSumK(nums, targetXor);
		System.out.println(subArrayCount);//3 [1,2,3,2],[2],[2]
				

	}
	/*
	This methods finds the number of sub arrays in an array a whose XOR (exclusive OR) is equal to a given target b. 
	It uses a HashMap to efficiently keep track of XOR frequencies during the iteration
	
	Time Complexity:
		The algorithm has a time complexity of O(n), where n is the length of the input array a.
		The code iterates through the array once.
	Space Complexity:
		The space complexity is O(n), where n is the length of the input array a.
		The HashMap stores unique cumulative XOR values and their corresponding frequencies. In the worst case, the size of the HashMap could be the same as the input size.
	 */
    public static int subarraysWithSumK(int []nums, int targetXor) {
        HashMap<Integer,Integer> xorFrequencies=new HashMap<>();//HashMap to store XOR frequencies and their occurrences.
        xorFrequencies.put(0,1);//The initial value in the HashMap is (0, 1) to account for the XOR of an empty subarray.
        int currentXor=0;// to store the cumulative XOR of elements in the array.
        int subArrayCount=0; //to store the count of subarrays with the XOR equal to targetXor.
        for(int i=0;i<nums.length;i++){
            currentXor^=nums[i];//Update the cumulative XOR by XORing the current element.
            //Calculate the XOR value that, when XORed with the current cumulative XOR, equals the target targetXor.
            int remainingXor=currentXor^targetXor;
            //Add the frequency of the remaining XOR from the HashMap to the subArrayCount.
            subArrayCount+=(xorFrequencies.get(remainingXor)==null?0:xorFrequencies.get(remainingXor));
            //Update the HashMap with the current cumulative XOR and its frequency.
            xorFrequencies.put(currentXor,xorFrequencies.getOrDefault(currentXor,0)+1);
        }
        return subArrayCount;
    }

}
