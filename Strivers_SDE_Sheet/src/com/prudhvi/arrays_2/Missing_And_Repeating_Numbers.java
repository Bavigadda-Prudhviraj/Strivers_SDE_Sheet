package com.prudhvi.arrays_2;
import java.util.ArrayList;
import java.util.Arrays;

public class Missing_And_Repeating_Numbers {

	public static void main(String[] args) {
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(4,3,6,1,1,2));
		System.out.println(Arrays.toString(missingAndRepeating(arr, 6)));

	}
	/*
	This method to find a missing and repeating number in an array of integers. 
	It utilizes XOR operations to efficiently determine the missing and repeating elements
	
	Time Complexity: O(n) - Iterating through the array and performing XOR operations.
	Space Complexity: O(1) - No additional space is used apart from the input array.
	 */
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
    	//Initializes two variables, nXor and aXor to 0.
        int nXor=0;
        int aXor=0;
        //It then iterates through the array and performs XOR operations on nXor with the expected XOR of numbers from 1 to n, and 
        //on aXor with the XOR of the array elements.
        for(int i=0;i<n;i++){
            nXor^=(i+1);
            aXor^=arr.get(i);
        }
        //After the loop, the XOR of nXor and aXor gives the XOR of the missing and repeating numbers.
        int xor=(nXor^aXor);
        //The code then uses the priorityBit method to find the leftmost bit where the XOR result has a set bit.
        int bit=priorityBit(xor);
        //This bit is crucial for distinguishing between the missing and repeating numbers.
        int bitMask=(1<<bit);
        //Two variables, setBit and unsetBit, are used to track the numbers based on whether the priority bit is set or unset.
        int setBit=0;
        int unsetBit=0;
        //XOR operations are performed on numbers from 1 to n and array elements based on their bit status (set or unset).
        for(int i=1;i<=n;i++){
            if((i&bitMask)==0)
                unsetBit^=i;
            else
                setBit^=i;
            if((arr.get(i-1)&bitMask)==0)
                unsetBit^=arr.get(i-1);
            else
                setBit^=arr.get(i-1);
            
        }
        //The missing and repeating numbers are identified based on the presence of setBit in the array.
        int missingNumber=arr.contains(setBit)?unsetBit:setBit;
        int doubleNUmber=missingNumber==setBit?unsetBit:setBit;
        int[] ans={missingNumber,doubleNUmber};
        return ans;
    }
    public static int priorityBit(int num){
        for(int i=30;i>=0;i--){
            int bitMask=(1<<i);
            if((bitMask&num)!=0)
                return i;
        }
        return -1;
    }

}
