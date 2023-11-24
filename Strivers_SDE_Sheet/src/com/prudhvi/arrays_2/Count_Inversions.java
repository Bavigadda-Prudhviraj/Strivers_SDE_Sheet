package com.prudhvi.arrays_2;

public class Count_Inversions {

	public static void main(String[] args) {
		long[] arr= {2,5,1,3,4};
		int n=arr.length;
		long inversionCount=getInversions(arr, n);
		System.out.println(inversionCount);

	}
	/*
	This method is an implementation of the merge sort algorithm to count the number of inversions in an array. 
	An inversion in an array occurs when two elements at indices i and j satisfy the condition arr[i] > arr[j] and i < j. 
	The code uses a divide-and-conquer approach to count inversions during the merge step of the merge sort algorithm.
	
	Time Complexity:
		The time complexity of the merge sort algorithm is O(n log n), where n is the number of elements in the array.
	Space Complexity:
		The space complexity is O(n) due to the additional space required for the temporary array used during the merging process.
	 */
    public static long getInversions(long arr[], int n) {
    	//Calls the mergeSort function with the entire array and returns the inversion count.
        return mergeSort(arr,0,n-1);
    }
    //This function performs the merge sort algorithm on the array within the given range (low to high). It returns the total number of inversions in the array.
    public static long mergeSort(long[] arr,int low,int high){
        long inversionCount=0;//Initializes the inversion count for the current merge operation.
        //Base case: If the range contains fewer than two elements, no inversions are possible, so the function returns 0.
        if(low>=high)
            return 0;
        //Calculates the middle index of the current range.
        int mid=low+(high-low)/2;
        //Recursively calls mergeSort on the left half of the array and adds the inversion count to the total.
        inversionCount+=mergeSort(arr,low,mid);
        //Recursively calls mergeSort on the right half of the array and adds the inversion count to the total.
        inversionCount+=mergeSort(arr,mid+1,high);
        //Merges the two halves of the array and adds the inversions from the merging process to the total count.
        inversionCount+=mergeTwoArr(arr,low,mid,high);
        return inversionCount;//Returns the total inversion count for the current range.
    }
    //This function merges two sorted halves of an array and counts the inversions during the merging process.
    public static long mergeTwoArr(long[] arr,int low,int mid,int high){
    	//Initializes pointers for the two halves and an index for the merged array.
        int p1=low,p2=mid+1,index=0;
        long inversionCount=0;//Initializes the inversion count for the current merge operation.
        //Creates a temporary array to store the merged and sorted elements.
        long[] sortedArr=new long[(high-low+1)];
        while(p1<=mid && p2<=high){
        	//Merges the two halves while counting inversions.Updates pointers and index.
            if(arr[(int) p1]<=arr[ p2]){
                sortedArr[index]=arr[p1];
                p1++;index++;
            }
            //If the element in the right half is smaller, it is added to the merged array, and inversions are counted.Updates pointers, index, and inversion count.
            else{
                sortedArr[index]=arr[p2];
                inversionCount+=(mid-p1+1);
                p2++;index++;
            }
        }
        //Copies remaining elements from the left half.
        while(p1<=mid){
            sortedArr[index]=arr[p1];
            p1++;index++;
        }
        //Copies remaining elements from the right half.
        while(p2<=high){
            sortedArr[index]=arr[p2];
            p2++;index++;
        }
        index=0;
        //Copies the merged and sorted elements back to the original array.
        for(int i=low;i<=high;i++){
            arr[i]=sortedArr[index];
            index++;
        }
        //Returns the inversion count for the current merge operation.
        return inversionCount;
    }

}
