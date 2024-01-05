package com.prudhvi.recursion;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {

	public static void main(String[] args) {
		String s = "aab";
		System.out.println(partition(s));
		

	}
	/*
	Time Complexity:
		1. The `findAllPalindromeSubstrings` function is a recursive backtracking algorithm. In the worst case, it explores all possibilities in the substring space.
		2. The outer loop iterates through each character in the string, and for each character, it recursively calls itself. The loop runs in O(2^N) time in the worst case, where N is the length of the string `s`.
		3. The `checkPalindrome` function takes constant time as it simply checks whether a substring is a palindrome.
	Therefore, the overall time complexity is dominated by the backtracking part, making it O(2^N).

	Space Complexity:
		1. The space complexity is determined by the recursive calls and the storage of partitions in the `allPartitions` list.
		2. The recursion stack can go up to the depth of the recursion, which is at most (N) (length of the string `s`).
		3. The `currentPartition` list is used to store the current partition during the recursion. In the worst case, it can have (N) elements.
		4. The `allPartitions` list stores all valid partitions. In the worst case, it can have (2^N) partitions.
	Therefore, the space complexity is O(N) + O(2^N). In big-O notation, we often simplify this to O(2^N), as it dominates the linear term for large enough N.

	In summary, the time complexity is O(2^N), and the space complexity is O(N) + O(2^N). The code explores all possible palindrome partitions, and the number of partitions grows exponentially with the size of the input string.
	 */
	public static List<List<String>> partition(String s) {
	    // List to store all palindrome partitions
	    List<List<String>> allPartitions = new ArrayList<>();
	    // List to store the current partition being generated
	    List<String> currentPartition = new ArrayList<>();
	    // Call the recursive function to find palindrome partitions
	    findAllPalindromeSubstrings(0, s.length(), s, allPartitions, currentPartition);
	    // Return the list of all palindrome partitions
	    return allPartitions;
	}

	public static void findAllPalindromeSubstrings(int index, int len, String s, List<List<String>> allPartitions, List<String> currentPartition) {
	    // Base case: If the entire string is processed, add the current partition to the list
	    if (index >= len) {
	        allPartitions.add(new ArrayList<>(currentPartition));
	        return;
	    }
	    // Iterate through the string to find palindrome substrings
	    for (int i = index; i < len; i++) {
	        // Check if the substring from index to i is a palindrome
	        if (checkPalindrome(s, index, i)) {
	            // Add the palindrome substring to the current partition
	            currentPartition.add(s.substring(index, i + 1));
	            // Recursively find partitions for the remaining string
	            findAllPalindromeSubstrings(i + 1, len, s, allPartitions, currentPartition);
	            // Backtrack by removing the last added palindrome substring
	            currentPartition.remove(currentPartition.size() - 1);
	        }
	    }
	}

	public static boolean checkPalindrome(String s, int start, int end) {
	    // Check if the substring from start to end is a palindrome
	    while (start <= end) {
	        if (s.charAt(start++) != s.charAt(end--))
	            return false;
	    }
	    return true;
	}


}
