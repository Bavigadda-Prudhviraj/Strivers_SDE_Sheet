package com.prudhvi.arrays_2;

import java.util.Arrays;

public class Merge_Two_Sorted_Arrays_Without_Extra_Space {

	public static void main(String[] args) {
		long[] a= {1,4,5,7};
		long[] b= {2,3,6};
		mergeTwoSortedArraysWithoutExtraSpace(a, b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

	}
	/*
	The mergeTwoSortedArraysWithoutExtraSpace method merges two sorted arrays a and b without using any extra space. 
	The idea is to start from the end of the first array (a) and the beginning of the second array (b). 
	If an element in the first array is greater than the element in the second array, swap them and move pointers accordingly. 
	The process continues until the end of the first array is reached or the beginning of the second array is reached.
	
	Time Complexity:
		The time complexity of this algorithm is O((n + m) log (n + m)), where n and m are the lengths of arrays a and b. The sorting step dominates the overall time complexity.

	Space Complexity:
		The space complexity is O(1) because the algorithm uses a constant amount of extra space (only a few variables).
	 */
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        int n=a.length;
        int m=b.length;
        //leftPointer is initialized to the last index of the first array (a.length - 1).
        //rightPointer is initialized to 0, pointing to the first index of the second array.
        int leftPointer=n-1;
        int rightPointer=0;
        //While leftPointer is greater than or equal to 0 and rightPointer is less than m-1 (the last index of the second array):
        while(leftPointer>=0 && rightPointer<m-1){
        	//If the element at a[leftPointer] is greater than the element at b[rightPointer], swap them.
            if(a[leftPointer]>b[rightPointer]){
                long temp=a[leftPointer];
                a[leftPointer]=b[rightPointer];
                b[rightPointer]=temp;
                //Decrement leftPointer and increment rightPointer.
                leftPointer--;
                rightPointer++;
            }
            //If the element at a[leftPointer] is not greater than the element at b[rightPointer], break the loop.
            else
                break;
        }
        //After the merging process, both arrays (a and b) are sorted individually using Arrays.sort().
        Arrays.sort(a);
        Arrays.sort(b);
    }

}
