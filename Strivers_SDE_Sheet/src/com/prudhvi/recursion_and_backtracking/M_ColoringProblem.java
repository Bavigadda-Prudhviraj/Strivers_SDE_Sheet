package com.prudhvi.recursion_and_backtracking;
/*
Given an undirected graph and an integer M. 
The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. 
Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

Example 1:
	Input: N = 4
		   M = 3
		   E = 5
		  Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
		  Output: 1
		Explanation: It is possible to colour the given graph using 3 colours.
		
Example 2:
Input:  N = 3
		M = 2
		E = 3
		Edges[] = {(0,1),(1,2),(0,2)}
		Output: 0
		
Your Task:
Your task is to complete the function graphColoring() which takes the 2d-array graph[], the number of colours and the number of nodes as inputs and returns true if answer exists otherwise false. 
1 is printed if the returned value is true, 0 otherwise. The printing is done by the driver's code.

Note: In Example there are Edges not the graph.Graph will be like, if there is an edge between vertex X and vertex Y graph[] will contain 1 at graph[X-1][Y-1], else 0. In 2d-array graph[ ], nodes are 0-based indexed, i.e. from 0 to N-1.Function will be contain 2-D graph not the edges.

Expected Time Complexity: O(MN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 20
1 ≤ E ≤ (N*(N-1))/2
1 ≤ M ≤ N
 */
public class M_ColoringProblem {
	/*
	Time Complexity: O( N^M) (n raised to m)

	Space Complexity: O(N)
	 */
	public boolean graphColoring(boolean graph[][], int m, int n) {
	    // Initialize an array to store colors for each node
	    int[] colour = new int[n];
	    // Call the recursive method to color the graph
	    return colourGraph(0, colour, graph, m);
	}

	public static boolean colourGraph(int node, int[] colors, boolean[][] graph, int m) {
	    // If all nodes are colored, the graph is successfully colored
	    if (node == graph.length)
	        return true;
	    // Try coloring the current node with each color from 1 to m
	    for (int i = 1; i <= m; i++) {
	        // Check if coloring with color 'i' is possible for the current node
	        if (isColouringPossible(graph, node, colors, i)) {
	            // Color the current node with color 'i'
	            colors[node] = i; 
	            // Recursively color the next node
	            if (colourGraph(node + 1, colors, graph, m))
	                return true; // Successful coloring found
	            else
	                colors[node] = 0; // Backtrack by resetting the color
	        }
	    }
	    
	    return false; // If no valid coloring is found
	}

	public static boolean isColouringPossible(boolean[][] graph, int node, int[] colors, int color) {
	    // Check if the adjacent nodes do not have the same color
	    for (int i = 0; i < graph.length; i++) {
	        if (graph[node][i] && colors[i] == color)
	            return false; // Violation of coloring rules
	    }
	    return true; // Node can be colored with the given color
	}


}
