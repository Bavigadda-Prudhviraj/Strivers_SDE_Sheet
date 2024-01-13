package com.prudhvi.binary_search;
//https://www.codingninjas.com/studio/problems/1062679
public class Find_Nth_Root_Of_M {

	public static void main(String[] args) {
		int n = 3, m = 27;
		System.out.println(NthRoot(n, m));
	}

	/**
	 * Finds the integer nth root of a given integer m.
	 *
	 * @param n The degree of the root.
	 * @param m The integer to find the nth root of.
	 * @return The integer nth root of m if it exists, otherwise -1.
	 * @TimeComplexity The time complexity is O(log(m)) as it uses binary search.
	 * @SpaceComplexity The space complexity is O(1) as it uses constant space.
	 */
	public static int NthRoot(int n, int m) {
	    // Initialize the search range
	    int low = 1;
	    int high = m;
	    // Perform binary search to find the nth root
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        // Calculate the nth power of mid
	        double midPowerN = Math.pow(mid, n);
	        if (midPowerN == m)
	            // If mid^n is equal to m, mid is the nth root
	            return mid;
	        else if (midPowerN < m)
	            // If mid^n is less than m, search in the right half
	            low = mid + 1;
	        else 
	            // If mid^n is greater than m, search in the left half
	            high = mid - 1;
	        
	    }
	    // If the loop exits, the nth root does not exist
	    return -1;
	}


}

