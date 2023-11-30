package com.prudhvi.arrays_3;

public class Reverse_Pairs {

	public static void main(String[] args) {
		int[] nums = {2,4,3,5,1};
		int reversepairs=reversePairs(nums);
		System.out.println(reversepairs);
	}
	/*
	This code is implementing an algorithm to count the number of reverse pairs in an array using the merge sort technique. 
	A reverse pair is a pair of indices (i, j) such that i < j and nums[i] > 2 * nums[j].
	
	Time Complexity:
		The time complexity is O(n log n), where n is the length of the array. 
		This is due to the merge sort algorithm.
	Space Complexity:
		The space complexity is O(n), where n is the length of the array. 
		This is due to the auxiliary array used for merging. 
		The recursion stack also contributes to space complexity.
	 */
    public static int reversePairs(int[] nums) {
        int pairsCount=mergeSort(nums,0,nums.length-1);
        return pairsCount;
    }
    public static int mergeSort(int[] nums,int low,int high){
        int pairsCount=0;
        if(low>=high){
            return pairsCount;
        }
        //Calculate mid as the middle index.
        int mid=low+(high-low)/2;
        //Recursively call mergeSort on the left and right halves.
        pairsCount+=mergeSort(nums,low,mid);
        pairsCount+=mergeSort(nums,mid+1,high);
        //Call the countPairs method to count pairs across the mid.
        pairsCount+=countPairs(nums,low,mid,high);
        //Call the merge method to merge the sorted halves.
        merge(nums,low,mid,high);
        return  pairsCount;
    }
    public static void merge(int[] nums,int low,int mid,int high){
        int p1=low,p2=mid+1,index=0;
        int[] arr=new int[high-low+1];
        while(p1<=mid && p2<=high){
            if(nums[p1]<=nums[p2]){
                arr[index]=nums[p1];
                index++;p1++;
            }else{
                arr[index]=nums[p2];
                index++;p2++;
            }
        }
        while(p1<=mid){
                arr[index]=nums[p1];
                index++;p1++;
        }
        while(p2<=high){
            arr[index]=nums[p2];
            index++;p2++;
        }
        index=0;
        for(int i=low;i<=high;i++){
            nums[i]=arr[index];
            index++;
        }

    }
    public static  int countPairs(int[] nums,int low,int mid,int high){
        int right = mid + 1, count = 0;
        //Iterate through the left half and, for each element, find the number of elements in the right half that satisfy the condition for a reverse pair.
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2 * (long) nums[right]) {
                right++;
            }
            count += right - (mid + 1);
        }
        return count;
    }

}
