/*
Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell
one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/

public class MaxProfit {
  public static int maxProfit(int[] prices) {
    int n = prices.length, minPrice = Integer.MAX_VALUE, maxProfit = 0;
    for (int i = 0; i < n; i++) {
      int elt = prices[i];
      minPrice = Math.min(minPrice, elt);
      maxProfit = Math.max(maxProfit, elt-minPrice);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    System.out.println("maxProfit(new int[] {7,1,5,3,6,4) = " + maxProfit(new int[] {7,1,5,3,6,4}));
    System.out.println("maxProfit(new int[] {7, 6, 4, 3, 1) = " + maxProfit(new int[] {7, 6, 4, 3, 1}));
  }
}