package com.prudhvi.recursion_and_backtracking;

public class Sudoku_Solver {

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
					      {'6','.','.','1','9','5','.','.','.'},
					      {'.','9','8','.','.','.','.','6','.'},
					      {'8','.','.','.','6','.','.','.','3'},
					      {'4','.','.','8','.','3','.','.','1'},
					      {'7','.','.','.','2','.','.','.','6'},
					      {'.','6','.','.','.','.','2','8','.'},
					      {'.','.','.','4','1','9','.','.','5'},
					      {'.','.','.','.','8','.','.','7','9'}};
		solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	/*
	Time Complexity: O(9(n ^ 2)), in the worst case, for each cell in the n2 board, we have 9 possible numbers.

	Space Complexity: O(1), since we are refilling the given board itself, there is no extra space required, so constant space complexity.
	 */
	public static void solveSudoku(char[][] board) {
		fillSudoku(board);
	}

	public static boolean fillSudoku(char[][] board) {
	    // Iterate through each cell in the Sudoku board
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            // Check if the cell is empty
	            if (board[i][j] == '.') {
	            	
	                // Try filling the cell with digits '1' to '9'
	                for (char ch = '1'; ch <= '9'; ch++) {
	                    // Check if the digit can be filled without violating Sudoku rules
	                    if (canFill(board, i, j, ch)) {
	                        // Fill the cell with the digit
	                        board[i][j] = ch;
	                        // Recursively call fillSudoku for the next empty cell
	                        if (fillSudoku(board)) {
	                            return true; // Successful solution found
	                        } else {
	                            // If recursive call returns false, backtrack by resetting the current cell
	                            board[i][j] = '.';
	                        }
	                    }
	                }
	                // If no valid digit can be filled, return false
	                return false;
	                
	            }
	        }
	    }
	    // If all cells are filled successfully, return true
	    return true;
	}

	public static boolean canFill(char[][] board, int row, int col, char ch) {
	    // Check the entire row, column, and 3x3 subgrid for the given digit
	    for (int i = 0; i < 9; i++) {
	        if (board[i][col] == ch || board[row][i] == ch || 
	            board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) {
	            return false; // Violation of Sudoku rules
	        }
	    }
	    return true; // Digit can be filled without violation
	}


}
