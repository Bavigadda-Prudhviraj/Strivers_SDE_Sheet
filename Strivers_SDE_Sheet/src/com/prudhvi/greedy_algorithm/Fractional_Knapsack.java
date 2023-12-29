package com.prudhvi.greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack {
	public static void main(String[] args) {
		Item[] arr = createItemArray();
		int w = 50;
		int n = 3;
		
		double maxProfit = fractionalKnapsack(w, arr, n);
		System.out.println(maxProfit);
		
	}

	public static double fractionalKnapsack(int W, Item arr[], int n) {
	    // Sort items based on value-to-weight ratio in descending order
	    Arrays.sort(arr, new itemComparator()); 
	    
	    int curWeight = 0;  // Current weight of the knapsack
	    double finalvalue = 0.0;  // Final value of the items in the knapsack
	    
	    // Iterate through the sorted items
	    for (int i = 0; i < n; i++) {
	        // If adding the entire item won't exceed the knapsack capacity
	        if (curWeight + arr[i].weight <= W) {
	            curWeight += arr[i].weight;  // Add the entire item to the knapsack
	            finalvalue += arr[i].value;  // Add the entire value of the item
	        } else {
	            // If adding the entire item would exceed the knapsack capacity, add a fraction of the item
	            int remain = W - curWeight;  // Remaining weight capacity in the knapsack
	            finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
	            break;  // Break the loop since the knapsack is full
	        }
	    }
	 
	    return finalvalue;// Return the maximum value that can be obtained
	}
	
	private static Item[] createItemArray() {
		int values[] = {60,100,120};
		int weight[] = {10,20,30};
		Item[] arr = new Item[3];
		for(int i = 0; i < 3; i++) {
			arr[i] = new Item(values[i], weight[i]);
		}
		return arr;
	}


}
//Comparator to sort items based on value-to-weight ratio in descending order
class itemComparator implements Comparator<Item>{
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}

//Class representing an item with value and weight
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}


