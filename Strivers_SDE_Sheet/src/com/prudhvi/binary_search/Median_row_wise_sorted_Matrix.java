package com.prudhvi.binary_search;
//  https://www.codingninjas.com/studio/problems/median-of-a-row-wise-sorted-matrix_1115473
public class Median_row_wise_sorted_Matrix {

	public static void main(String[] args) {
		int n = 5, m = 5;
		int[][] mat = {{ 1, 5,  7,  9,  11 },
					   { 2, 3,  4,  8,  9 },
				       { 4, 11, 14, 19, 20 },
				       { 6, 10, 22, 99, 100 },
                       { 7, 15, 17, 24, 28 }};
		System.out.println(findMedian(mat, m, n));

	}
	/**
	 * Finds the median value in a 2D matrix.
	 *
	 * @param matrix The input matrix of dimensions m x n.
	 * @param m      The number of rows in the matrix.
	 * @param n      The number of columns in the matrix.
	 * @return       The median value of the elements in the matrix.
	 * @TimeComplexity The time complexity is O(m * log(max - min)), where max and min are the maximum and minimum
	 *                 values in the matrix. The binary search is performed for log(max - min) iterations on m rows.
	 * @SpaceComplexity The space complexity is O(1) as the algorithm uses a constant amount of extra space.
	 */
	public static int findMedian(int matrix[][], int m, int n) {
	    // Initialize the low and high values for binary search
	    int low = Integer.MAX_VALUE;
	    int high = Integer.MIN_VALUE;

	    // Find the minimum and maximum values in the first column of the matrix
	    for (int i = 0; i < m; i++) {
	        low = Math.min(low, matrix[i][0]);
	        high = Math.max(high, matrix[i][n - 1]);
	    }

	    // Initialize the median value
	    int median = -1;

	    // Perform binary search on the possible median values
	    while (low <= high) {
	        // Calculate the mid value
	        int mid = low + (high - low) / 2;

	        // Count the number of elements less than or equal to mid in the matrix
	        int lessthanMid = elementsLessthanMid(matrix, mid);

	        // Check if the count is greater than half of the total elements
	        if (lessthanMid > (n * m / 2)) {
	            median = mid;
	            high = mid - 1; // Search in the left half for a smaller median
	        } else {
	            low = mid + 1; // Search in the right half for a larger median
	        }
	    }

	    // Return the calculated median value
	    return median;
	}

	/**
	 * Counts the number of elements less than or equal to k in each row of the matrix.
	 *
	 * @param arr The input matrix of dimensions m x n.
	 * @param k   The value to compare against.
	 * @return    The total count of elements less than or equal to k in the matrix.
	 * @TimeComplexity The time complexity is O(m * log(n)), where m is the number of rows and n is the number of columns.
	 *                 The binary search is performed for log(n) iterations on each row.
	 * @SpaceComplexity The space complexity is O(1) as the algorithm uses a constant amount of extra space.
	 */
	public static int elementsLessthanMid(int arr[][], int k) {
	    int m = arr.length;
	    int n = arr[0].length;
	    int count = 0;

	    // Iterate through each row of the matrix
	    for (int i = 0; i < m; i++) {
	        int low = 0;
	        int high = n - 1;
	        int ans = -1;

	        // Perform binary search in each row to find the count of elements less than or equal to k
	        while (low <= high) {
	            int mid = low + (high - low) / 2;

	            if (arr[i][mid] <= k) {
	                ans = mid;
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }

	        // Increment the count by the number of elements less than or equal to k in the current row
	        count += ans + 1;
	    }

	    // Return the total count of elements less than or equal to k in the matrix
	    return count;
	}


}
