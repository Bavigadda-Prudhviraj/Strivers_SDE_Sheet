package com.prudhvi.arrays_3;

public class Search_2D_Matrix {

	public static void main(String[] args) {
		int[][] matrix = {{1, 3,  5, 7},
						  {10,11,16,20},
						  {23,30,34,60}}; 
		int target = 16;
		boolean isTargetExist=searchMatrix(matrix, target);
		System.out.println(isTargetExist);

	}
	/*
	This code implements a binary search algorithm to search for a target element in a 2D matrix. 
	The matrix is assumed to be sorted in both rows and columns.
	
	Time Complexity:
		The time complexity of this binary search algorithm is O(log(n * m)), where n is the number of rows and m is the number of columns in the matrix.

	Space Complexity:
		The space complexity is O(1) because the algorithm uses a constant amount of extra space regardless of the size of the input matrix.
	 */
    public static boolean searchMatrix(int[][] matrix, int target) {
    	//Retrieves the number of rows (n) and columns (m) in the matrix.
        int n=matrix.length,m=matrix[0].length;
        //Initializes the low and high pointers for binary search. The matrix is treated as a 1D array of length n * m.
        int low=0,high=n*m-1;
        while(low<=high){
            int mid=low+(high-low)/2;//Calculates the middle index of the 1D array.
            int row=mid/m;//Calculates the row index in the original 2D matrix corresponding to the middle index.
            int col=mid%m;//Calculates the column index in the original 2D matrix corresponding to the middle index.
            int currentElement=matrix[row][col];//Retrieves the element at the calculated row and column.
            //If the current element is equal to the target, the target is found, and the function returns true.
            if(currentElement==target)
                return true;
            //If the current element is less than the target, it means the target must be in the right half of the remaining array, so the search continues in the right half.
            else if(currentElement<target)
                low=mid+1;
            //If the current element is greater than the target, it means the target must be in the left half of the remaining array, so the search continues in the left half.
            else
                high=mid-1;
        }
        //If the while loop completes without finding the target, the function returns false.
        return false;
    }

}
