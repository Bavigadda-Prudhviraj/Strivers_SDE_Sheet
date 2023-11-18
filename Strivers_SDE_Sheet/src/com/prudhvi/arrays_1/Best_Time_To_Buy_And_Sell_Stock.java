package com.prudhvi.arrays_1;

public class Best_Time_To_Buy_And_Sell_Stock {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		int maxProfit=maxProfit(prices);
		System.out.println(maxProfit);

	}
	/*
	 This method is used to find the maximum profit that can be obtained from buying and selling a stock represented by its prices over time
	 
	 Time Complexity:
	 The  time complexity is O(n), where n is the length of the prices array, as it iterates through the array once. 
	 
	 SpaceComplexity:
	 The space complexity is O(1) as it uses a constant amount of extra space.
	 */
    public static int maxProfit(int[] prices) {
    	//Initialize maxProfit to the smallest possible integer value and stockPrice to the largest possible integer value.
        int maxProfit=Integer.MIN_VALUE;
        int stockPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
        	//If the current price is less than the stockPrice, update stockPrice to the current price.
            if(prices[i]<stockPrice){
                stockPrice=prices[i];
            }
            //Calculate the potential profit if the stock is sold at the current price (prices[i] - stockPrice).
            //Update maxProfit with the maximum of its current value and the calculated profit.
            maxProfit=Math.max(maxProfit,prices[i]-stockPrice);
        }
        // Return the final result
        return maxProfit;
    }

}
