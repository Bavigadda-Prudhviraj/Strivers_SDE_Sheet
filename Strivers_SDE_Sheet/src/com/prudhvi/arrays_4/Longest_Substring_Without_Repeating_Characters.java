package com.prudhvi.arrays_4;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		String s = "abcabcbb";
		int lengthOfLongeshSubString=lengthOfLongestSubstring(s);
		System.out.println(lengthOfLongeshSubString);

	}
	/*
	This code is designed to find the length of the longest substring without repeating characters in a given string s. 
	It uses a sliding window approach and a HashMap to efficiently keep track of the last seen index of each character
	
	Time Complexity:
		- The algorithm has a time complexity of O(n), where n is the length of the input string `s`.
		- The code iterates through the string once.

	Space Complexity:
		- The space complexity is O(min(n, m)), where n is the length of the input string `s` and m is the size of the character set (26 for lowercase letters, 52 for both lowercase and uppercase letters). 
		In the worst case, the HashMap stores unique characters with their last seen indices.
	 */
    public static int lengthOfLongestSubstring(String s) {
    	//HashMap to store the last seen index of each character in the string.
        HashMap<Character, Integer> lastSeenIndex = new HashMap<>();
        int maxLength = 0; //to store the length of the longest substring without repeating characters.
        int start = 0; //to mark the starting index of the current substring.

        for (int i = 0; i < s.length(); i++) {
        	//If the current character is already in the lastSeenIndex HashMap
            if (lastSeenIndex.containsKey(s.charAt(i))) {
            	// update the start index to be the maximum of its current value and the last seen index + 1.
                start = Math.max(start, lastSeenIndex.get(s.charAt(i)) + 1);
            }
            //Update the maxLength with the maximum value between its current value and the length of the current substring without repeating characters.
            maxLength = Math.max(maxLength, i - start + 1);
            //Update the lastSeenIndex HashMap with the current character and its index.
            lastSeenIndex.put(s.charAt(i), i);
        }

        return maxLength;
    }
}
