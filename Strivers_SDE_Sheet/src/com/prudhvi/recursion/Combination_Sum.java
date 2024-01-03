package com.prudhvi.recursion;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
public class Combination_Sum {

	public static void main(String[] args) {
		int[] cadidates = {2,3,6,7};
		int target = 7;
		System.out.println(combinationSum(cadidates, target));
		

	}
	/*
	Time Complexity:
		The time complexity is mainly determined by the number of recursive calls made in the `generateCombinations` function.
			1. The `generateCombinations` function is called for each candidate element in the candidates array, and it recursively calls itself. In the worst case, it explores all possible combinations.
			2. In each recursive call, the function iterates through the candidates from the current index to the end of the array.
		Therefore, the time complexity is exponential, specifically O(2^n), where (n) is the length of the candidates array. This is because, in the worst case, each element can be either included or excluded in the combination, resulting in (2^n) possible combinations.
	
	Space Complexity:
		The space complexity is determined by the recursion stack and the storage of combinations in the `combinations` list.
			1. The recursion stack depth is at most \(n\) (the length of the candidates array), as each recursive call corresponds to a candidate.
			2. The `currentCombination` list is used to store the current combination during the recursion. In the worst case, it can have (n) elements.
			3. The `combinations` list stores all valid combinations. In the worst case, it can also have (2^n) combinations.
		Therefore, the space complexity is (O(n) + O(2^n)). In big-O notation, we often simplify this to (O(2^n)), as it dominates the linear term for large enough (n).
	
	In summary, the time complexity is (O(2^n)), and the space complexity is also (O(2^n)). The code generates all possible combinations, and the number of combinations grows exponentially with the size of the input array.
	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> combinations = new ArrayList<>();
	    List<Integer> currentCombination = new ArrayList<>();

	    // Start the recursive generation of combinations
	    generateCombinations(0, candidates.length, target, combinations, currentCombination, candidates);
	    
	    return combinations;
	}

	public static void generateCombinations(int index, int n, int remainingSum, List<List<Integer>> combinations, List<Integer> currentCombination, int[] candidates) {
	    // Base cases
	    if (remainingSum < 0)
	        return;

	    if (remainingSum == 0) {
	        // Found a valid combination, add it to the result
	        combinations.add(new ArrayList<>(currentCombination));
	        return;
	    }

	    // Recursive exploration of combinations
	    for (int i = index; i < n; i++) {
	        if (remainingSum - candidates[i] >= 0) {
	            // Include the candidate in the current combination
	            currentCombination.add(candidates[i]);
	            
	            // Recursive call with the updated remaining sum
	            // not i + 1 because we can reuse same elements
	            generateCombinations(i, n, remainingSum - candidates[i], combinations, currentCombination, candidates);
	            
	            // Backtrack: remove the last added element for the next iteration
	            currentCombination.remove(currentCombination.size() - 1);
	        }
	    }
	}


}
