package com.prudhvi.arrays_2;

import java.util.Arrays;

public class Rotate_Image {

	public static void main(String[] args) {
		int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	/*
	This rotate method rotates an input matrix (2D array) 90 degrees clockwise. 
	It does this in-place without using any extra space.
	Time Complexity:- 
	 */
	public static void rotate(int[][] matrix) {
		int n=matrix.length;
		int m=matrix[0].length;
		//Transpose:
		//The first loop transposes the matrix by swapping elements across its main diagonal.
		for(int i=1;i<n;i++) {
			////For each element matrix[i][j], it swaps with matrix[j][i].
			for(int j=0;j<i;j++) {
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		//Reverse Rows:
		//The second loop reverses each row of the transposed matrix.
		for(int i=0;i<n;i++) {
			//For each row matrix[i], it swaps elements matrix[i][j] with matrix[i][m-1-j], where m is the number of columns.
			int j=m-1;
			int cnt=0;
			while(cnt<j) {
				int temp=matrix[i][j];
				matrix[i][j]=matrix[i][cnt];
				matrix[i][cnt]=temp;
				cnt++;
				j--;
			}
		}
		
	}

}
