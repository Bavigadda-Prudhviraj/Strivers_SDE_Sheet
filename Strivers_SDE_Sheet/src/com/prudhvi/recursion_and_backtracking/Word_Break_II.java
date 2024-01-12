package com.prudhvi.recursion_and_backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Word_Break_II {

	public static void main(String[] args) {
		ArrayList<String> dictionary = new ArrayList<>(Arrays.asList("god","is","now","no","where","here")); 
		String string =  "godisnowherenowhere";
		ArrayList<String> words= wordBreak(string, dictionary);
		for(String ele: words) {
			System.out.println(ele);
		}
	}
	/**
	 * Finds all possible sentences by breaking the input string using words from the dictionary.
	 * @param s The input string
	 * @param dictionary List of words in the dictionary
	 * @return List of sentences formed by breaking the input string
	 */
	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
	    // List to store the generated sentences
	    ArrayList<String> sentences = new ArrayList<>();
	    // Call the recursive helper function to find sentences
	    findSentences(s, new ArrayList<>(), sentences, dictionary);
	    // Return the list of sentences
	    return sentences;
	}
	/**
	 * Recursive helper function to find sentences by breaking the input string.
	 * @param s Remaining portion of the string to be processed
	 * @param current Current list of words in the sentence being formed
	 * @param sentences List to store the generated sentences
	 * @param dictionary List of words in the dictionary
	 */
	public static void findSentences(String s, ArrayList<String> current, ArrayList<String> sentences, ArrayList<String> dictionary) {
	    // Base case: If the entire string is processed, add the sentence to the list
	    if (s.length() == 0) {
	        sentences.add(String.join(" ", current));
	        return;
	    }
	    // Try breaking the string at different positions and check if the substring is in the dictionary
	    for (int i = 0; i < s.length(); i++) {
	        String left = s.substring(0, i + 1);

	        if (dictionary.contains(left)) {
	            // Include the current word in the sentence
	            current.add(left);
	            // Recursively find sentences for the remaining portion of the string
	            findSentences(s.substring(i + 1), current, sentences, dictionary);
	            // Backtrack: Remove the last added word to explore other possibilities
	            current.remove(current.size() - 1);
	        }
	    }
	}


}
