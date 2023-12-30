package com.prudhvi.greedy_algorithm;

import java.util.ArrayList;
import java.util.List;

public class Find_Minimum_Number_Of_Coins {

	public static void main(String[] args) {
		int n = 13;
		List<Integer> coins = minimumCoins(n);
		System.out.println(coins);

	}
	/*
	This method aims to find the minimum number of coins needed to represent a given amount n using the available denominations in Indian currency. 
	The denominations are stored in the array indianCurrency.
	
	Time Complexity:
		The time complexity of this algorithm is proportional to the number of available denominations. It is O(D), where D is the number of denominations.
	
	Space Complexity:
		The space complexity is O(1) since the space required is constant, independent of the input size. The coins list stores the selected coins, and its size is at most the number of denominations.
	 */
	public static List<Integer> minimumCoins(int n) {
	    // Array representing Indian currency denominations in descending order
	    int[] indianCurrency = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
	    // List to store the minimum coins needed
	    List<Integer> coins = new ArrayList<>();  

	    // Iterate through the currency denominations in descending order
	    for (int i = indianCurrency.length - 1; i >= 0; i--) {
	        // While the current denomination can be used to reduce the remaining amount
	        while (indianCurrency[i] <= n) {
	            n -= indianCurrency[i];  // Subtract the denomination from the remaining amount
	            coins.add(indianCurrency[i]);  // Add the denomination to the list
	        }
	    }
	    // Return the list of minimum coins needed
	    return coins;  
	}


}
