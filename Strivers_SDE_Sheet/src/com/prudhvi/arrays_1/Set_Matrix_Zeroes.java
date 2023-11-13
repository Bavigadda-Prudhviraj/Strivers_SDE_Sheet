package com.prudhvi.arrays_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
 Problem:-https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class Set_Matrix_Zeroes {

	public static void main(String[] args) {
		int[][] arr= {{0,1,2,0},
					  {3,4,5,2},
					  {1,3,1,5}};
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	/*
	This method implements an algorithm to set the entire row and column to zero in a matrix if any element in that row or column is zero. 
	The algorithm uses the first row and first column of the matrix as markers to record whether a specific row or column should be zeroed
	
	**Time Complexity**:
		- The code uses two nested loops to iterate through all elements of the matrix. 
		  The first loop goes through the rows, and the second loop goes through the columns. Both loops have a time complexity of O(n * m), where 'n' is the number of rows, and 'm' is the number of columns in the matrix.
  		- After finding zeros, there is a second loop (nested) that goes through the matrix again to set the zeros based on the information stored in the first row and first column. 
  		  This loop also has a time complexity of O(n * m).
		- Therefore, the overall time complexity is O(n * m).

	**Space Complexity**:
		- The code uses two boolean variables 'row' and 'col' to check whether the first row or first column should be set to zero. 
		  This results in constant space usage, O(1).
		- No additional data structures are used, and the modifications are done in-place, so there is no additional space complexity.
    In summary, the code has a time complexity of O(n * m) and a space complexity of O(1). 
    It efficiently sets rows and columns to zero in the matrix based on the presence of zeros in the original matrix.
	 */
	public static void setZeroes(int[][] matrix) {
		//n and m are the number of rows and columns in the matrix, respectively.
        int n=matrix.length;
        int m=matrix[0].length;
        //row and col are boolean flags to track whether the first row and first column should be zeroed, respectively.
        boolean col=false;
        boolean row=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            	//If a zero is found at matrix[i][j]:
            	if(matrix[i][j]==0) {
            		//If j is 0 (indicating the first column), set col to true.
            		//If i is 0 (indicating the first row), set row to true.
            		if(j==0 && i==0) {
            			row=true;col=true;
            		}
            		else if(i==0 && j!=0)
            			col=true;
            		else if(j==0 && i!=0)
            			row=true;
            		//If i and j are both greater than 0, mark the corresponding positions in the first row (matrix[i][0]) and first column (matrix[0][j]) as zero.
            		else{
            			matrix[i][0]=0;
                		matrix[0][j]=0;
            		}
            	}  
            }
        }
        //Update Matrix:
        for (int i = 1; i < n; i++) {
			for (int j =1 ; j < m; j++) {
				//If either the corresponding position in the first row (matrix[i][0]) or the first column (matrix[0][j]) is zero, set matrix[i][j] to zero.
				if(matrix[i][0]==0 || matrix[0][j]==0)
					matrix[i][j]=0;
			}
		}
        //Zero Out First Row and Column if Necessary:
        //If row is true, set all elements in the first column to zero.
        if(row) {
        	for (int i = 0; i < n; i++)
				matrix[i][0]=0;
        }
        //If col is true, set all elements in the first row to zero.
        if(col) {
        	for (int i = 0; i < m; i++)
				matrix[0][i]=0;
        } 
    }
	/*
	The time complexity of this algorithm is also O(m * n), where m is the number of rows and n is the number of columns in the matrix. 
	
	The space complexity is O(m + n) because it uses two sets (row and col) to store the indices of rows and columns.
	 */
	public static void setZeroe(int[][] matrix) {
		//1.Initialize Sets:
		//n and m are the number of rows and columns in the matrix, respectively.
        int n=matrix.length;
        int m=matrix.length;
        //row and col are sets to store the indices of rows and columns that contain at least one zero.
        Set<Integer> row=new HashSet<Integer>();
        Set<Integer> col=new HashSet<Integer>();
        //2.Mark Rows and Columns:
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            	//If a zero is found at matrix[i][j], add i to the row set and j to the col set.
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        //3.Update Matrix:
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            	//if the current row index (i) is in the row set or the current column index (j) is in the col set, set matrix[i][j] to zero.
                if(row.contains(i) || col.contains(j)){
                   matrix[i][j]=0;
                }
            }
        }


    }

}
