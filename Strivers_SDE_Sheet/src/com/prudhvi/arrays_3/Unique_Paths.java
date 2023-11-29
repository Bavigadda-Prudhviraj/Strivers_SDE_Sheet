package com.prudhvi.arrays_3;

public class Unique_Paths {

	public static void main(String[] args) {
		int m=4;
		int n=4;
		int uniquePaths=uniquePaths(m, n);
		System.out.println(uniquePaths);
		System.out.println(uniquePathsWithConstantSpace(m, n));
		

	}
	/*
	The code is essentially calculating the binomial coefficient C(N, r) using a loop, where N is the total number of steps and r is the number of steps required to move either down or right. 
	This coefficient represents the number of unique paths from the top-left corner to the bottom-right corner in the given grid.
	
	Time  Complexity:
		The time complexity is O(min(m, n)), where m and n are the dimensions of the grid. The loop iterates r times, where r is the smaller of the two dimensions.
	Space Complexity:
		The space complexity is O(1) as the algorithm uses a constant amount of space regardless of the input size.
	 */
	public static int uniquePathsWithConstantSpace(int m,int n) {
		//Calculate the total number of steps N required to reach the bottom-right corner by adding the number of rows (m) and the number of columns (n) and subtracting 2 (the starting point and the destination point).
        int N=m+n-2;
        //Calculate the number of steps r required to move either down or right. This is the minimum of the number of rows and columns minus 1.
        int r=Math.min(m,n)-1;
        //Initialize a variable paths to 1. This variable will store the total number of unique paths.
        double paths=1;
        for(int i=1 ; i<=r ; i++){
        	//calculate the binomial coefficient using the formula C(N, r) = N! / (r! * (N-r)!).
            paths = paths *(N-r+i)/i;
        }
        //Convert the result to an integer and return it.
        return (int)paths;
	}
	/*
	The code is used to find the number of unique paths from the top-left corner of a grid to the bottom-right corner. 
	The grid has a size of `row` rows and `col` columns, and you can only move right or down. 
	It uses dynamic programming to calculate the number of unique paths. 
	
	Time Complexity:
		The code uses a nested loop to iterate through each cell in the grid, resulting in a time complexity of O(row * col).
	
	Space Complexity:
		The code uses a 2D array `dp` to store the number of unique paths for each cell in the grid. The space complexity is O(row * col) since it depends on the size of the grid.
	
	 */
    public static int uniquePaths(int m, int n) {
    	if(m==1) {
    		return 1;
    	}
    	//It initializes a 2D array `dp` of size `[row][col]` to store the number of unique paths for each cell.
    	int[][] dp=new int[m][n];
    	//The nested loops iterate through each cell in the grid. The outer loop iterates over the rows, and the inner loop iterates over the columns.
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			//For the cell at the top-left corner (`i = 0` and `j = 0`), there's only one way to reach it (no moves). So, it continues to the next iteration.
    			if(i==0 && j==0) 
    				continue;
    			//For the cells in the first row (`i = 0` and `j > 0`) and the first column (`j = 0` and `i > 0`), there's only one way to reach each cell. So, it sets `dp[i][j]` to 1.
    			else if((i==0 && j>0 )|| (j==0 && i>0))
    				dp[i][j]=1;
    			//For the other cells, it calculates the number of unique paths to reach the current cell. 
    			//The number of unique paths to a cell is the sum of the number of unique paths to the cell immediately above it (`dp[i-1][j]`) and the cell immediately to the left of it (`dp[i][j-1]`).
    			else 
    				dp[i][j]=dp[i][j-1]+dp[i-1][j];
    		}
    	}
    	//Finally, it returns the value stored in the bottom-right cell of the grid (`dp[row-1][col-1]`), which represents the number of unique paths from the top-left corner to the bottom-right corner.
    	return dp[m-1][n-1];
    }

}
