package com.prudhvi.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5}; 
		int target = 8;
		System.out.println(combinationSum2(candidates, target));

	}
	/*
	Time Complexity:
			1. The `Arrays.sort` method has a time complexity of O(N log N), where (N) is the length of the `candidates` array.
			2. The `generateCombinations` function is a recursive backtracking algorithm. In the worst case, it explores all possibilities in the combination space.
			3. The loop inside `generateCombinations` iterates through each candidate, and for each candidate, it recursively calls itself. The loop runs in (O(2^N) time in the worst case, where (N) is the length of the `candidates` array.
		Therefore, the overall time complexity is dominated by the backtracking part, making it O(N log N + 2^N).
	
	Space Complexity:
			1. The space complexity is determined by the recursive calls and the storage of combinations in the `combinations` list.
			2. The recursion stack can go up to the depth of the recursion, which is at most (N) (length of `candidates` array).
			3. The `currentCombination` list is used to store the current combination during the recursion. In the worst case, it can have (N) elements.
			4. The `combinations` list stores all valid combinations. In the worst case, it can have (2^N) combinations.
		Therefore, the space complexity is O(N) + O(2^N). In big-O notation, we often simplify this to O(2^N), as it dominates the linear term for large enough (N).

	In summary, the time complexity is O(N log N + 2^N), and the space complexity is O(N) + O(2^N). The code explores all possible combinations, and the number of combinations grows exponentially with the size of the input array.
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    // Sort the candidates array to handle duplicates and make the search space organized
	    Arrays.sort(candidates);
	    // List to store all combinations
	    List<List<Integer>> combinations = new ArrayList<>();
	    // List to store the current combination being generated
	    List<Integer> currentCombination = new ArrayList<>();
	    
	    // Call the recursive function to generate combinations
	    generateCombinations(candidates, 0, candidates.length, target, combinations, currentCombination);
	    
	    // Return the list of combinations
	    return combinations;
	}

	public static void generateCombinations(int[] candidates, int index, int len, int target, List<List<Integer>> combinations, List<Integer> currentCombination) {
	    // Base case: if the target is reached, add the current combination to the list
	    if (target == 0) {
	        combinations.add(new ArrayList<>(currentCombination));
	        return;
	    }
	    
	    // Base case: if target becomes negative or index goes beyond the array length, return
	    if (target < 0 || index >= len)
	        return;
	    
	    // Iterate through the candidates array
	    for (int i = index; i < len; i++) {
	        // Skip duplicates to avoid duplicate combinations
	        if (i > index && candidates[i] == candidates[i - 1]) 
	            continue;
	        
	        // If the current candidate can be included in the combination without exceeding the target
	        if (target - candidates[i] >= 0) {
	            // Include the candidate in the current combination
	            currentCombination.add(candidates[i]);
	            
	            // Recursively generate combinations for the remaining candidates
	            generateCombinations(candidates, i + 1, len, target - candidates[i], combinations, currentCombination);
	            
	            // Backtrack by removing the last added candidate
	            currentCombination.remove(currentCombination.size() - 1);
	        }
	    }
	}

}


