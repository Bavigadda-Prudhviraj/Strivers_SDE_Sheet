package com.prudhvi.recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/n-queens/description/
public class N_Queens {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solveNQueens(n));

	}
	/*
	Time Complexity:
			The backtracking approach tries out all possible positions for the queens, while considering constraints to ensure no two queens threaten each other.
			The time complexity depends on the number of valid solutions that can be found for the N-Queens problem.
		    The exact time complexity can vary depending on the size of the chess board and the number of valid solutions.
		 Therefore, the overAll time complexity is N^N.
	Space Complexity:
			The space complexity is determined by the recursion stack and additional data structures.
			The recursion stack can go as deep as the number of rows (N).
			The chessBoard 2D array requires O(N^2) space.
			The arrays colCheck, leftDig, and rightDig each require O(2N-1) space (constant space).
		Therefore, the overall space complexity is O(N^2) for the chess board and additional data structures.
	 */
	public static List<List<String>> solveNQueens(int n) {
	    // Initialize data structures for the chessboard and tracking queen placements
	    List<List<String>> queenPlacements = new ArrayList<>();
	    int[][] chessBoard = new int[n][n];
	    boolean[] column = new boolean[n];
	    boolean[] leftDiagonal = new boolean[2 * n - 1];
	    boolean[] rightDiagonal = new boolean[2 * n - 1];

	    // Call the recursive method to find all solutions
	    placeQueen(n, 0, column, leftDiagonal, rightDiagonal, chessBoard, queenPlacements);

	    // Return the list of solutions
	    return queenPlacements;
	}

	public static void placeQueen(int n, int row, boolean[] column, boolean[] leftDiagonal, boolean[] rightDiagonal, int[][] queens, List<List<String>> queenPlacements) {
	    // Base case: All queens are placed, add the current placement to the result
	    if (row == n) {
	        List<String> placedQueens = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            StringBuilder eachRow = new StringBuilder();
	            for (int j = 0; j < n; j++)
	                eachRow.append(queens[i][j] == 1 ? "Q" : ".");
	            placedQueens.add(eachRow.toString());
	        }
	        queenPlacements.add(placedQueens);
	        return;
	    }

	    // Try placing a queen in each column of the current row
	    for (int col = 0; col < n; col++) {
	        // Check if placing a queen in the current position is valid
	        if (!column[col] && !leftDiagonal[row + col] && !rightDiagonal[n - 1 + col - row]) {
	            // Place the queen and update tracking arrays
	            column[col] = leftDiagonal[row + col] = rightDiagonal[n - 1 + col - row] = true;
	            queens[row][col] = 1;

	            // Recursively move to the next row
	            placeQueen(n, row + 1, column, leftDiagonal, rightDiagonal, queens, queenPlacements);

	            // Backtrack: Undo the placement and reset tracking arrays
	            column[col] = leftDiagonal[row + col] = rightDiagonal[n - 1 + col - row] = false;
	            queens[row][col] = 0;
	        }
	    }
	}


}
