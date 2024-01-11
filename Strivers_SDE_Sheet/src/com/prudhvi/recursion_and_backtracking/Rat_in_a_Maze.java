package com.prudhvi.recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;
/*
You are given a N*N maze with a rat placed at 'mat[0][0]'. 
Find all paths that rat can follow to reach its destination i.e. mat[N-1][N-1]. 
The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).

In the given maze, each cell can have a value of either 0 or 1. 
Cells with a value of 0 are considered blocked, which means the rat cannot enter or traverse through them. 
On the other hand, cells with a value of 1 are open, indicating that the rat is allowed to enter and move through those cells.

Example:
mat:{{1, 0, 0, 0},
     {1, 1, 0, 1}, 
     {1, 1, 0, 0},
     {0, 1, 1, 1}}

All possible paths are:DDRDRR DRDDRR 
 */
public class Rat_in_a_Maze {

	public static void main(String[] args) {
		int[][] mat ={{1, 0, 0, 0},
				      {1, 1, 0, 1}, 
				      {1, 1, 0, 0},
				      {0, 1, 1, 1}};
		System.out.println(ratMaze(mat));

	}
	/*
	Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.
	Space Complexity:  O(m*n), Maximum Depth of the recursion tree(auxiliary space).
	 */
	public static List<String> ratMaze(int[][] mat) {
	    // List to store all possible paths
	    List<String> paths = new ArrayList<>();
	    // Matrix to track visited cells
	    boolean[][] visited = new boolean[mat.length][mat[0].length];
	    // StringBuilder to store the current path
	    StringBuilder way = new StringBuilder();
	    // Deviations for possible moves: Down, Left, Right, Up
	    int[] iDeviation = {1, 0, 0, -1};
	    int[] jDeviation = {0, -1, 1, 0};
	    // Check if the starting cell is open
	    if (mat[0][0] == 1)
	        pathFinder(0, 0, mat, visited, way, paths, iDeviation, jDeviation);

	    return paths;
	}

	public static void pathFinder(int row, int col, int[][] maze, boolean[][] visited, StringBuilder way, List<String> paths, int[] iDeviation, int[] jDeviation) {
	    int n = maze.length;
	    int m = maze[0].length;
	    // If the current cell is the destination, add the path to the list
	    if (row == n - 1 && col == m - 1) {
	        paths.add(way.toString());
	        return;
	    }
	    // Mark the current cell as visited
	    visited[row][col] = true;
	    // String to represent the possible moves: Down, Left, Right, Up
	    String directions = "DLRU";
	    // Iterate through possible moves
	    for (int i = 0; i < 4; i++) {
	        int nextRow = row + iDeviation[i];
	        int nextCol = col + jDeviation[i];
	        // Check if the next move is within bounds, unvisited, and open
	        if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol] && maze[nextRow][nextCol] == 1) {
	            // Recursively explore the path
	            pathFinder(nextRow, nextCol, maze, visited, way.append(directions.charAt(i)), paths, iDeviation, jDeviation);
	            // Backtrack: Remove the last direction as we go back
	            way.deleteCharAt(way.length() - 1);
	        }
	    }
	    // Mark the current cell as unvisited (backtrack)
	    visited[row][col] = false;
	}


}
