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
  // Brute Force: O(n^2) runtime and O(1) space complexities
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int maximumProfit = 0, n = prices.length;
    for (int i = 0; i < n-1; i++) {
      for (int j = i+1; j < n; j++) {
        int currentProfit = prices[j] - prices[i];
        if (currentProfit > maximumProfit) {
          maximumProfit = currentProfit;
        }
      }
    }
    return maximumProfit;
  }

  // One Pass solution: O(n) runtime and O(1) space complexities
  public static int maxProfit2(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int n = prices.length, maxProfit = 0, minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      if (prices[i] < minPrice)
        minPrice = prices[i];
      else if ( (prices[i] - minPrice) > maxProfit )
        maxProfit = prices[i] - minPrice;
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    System.out.println("Using Brute Force solution: O(n^2) runtime and O(1) space complexities");
    System.out.println("maxProfit(new int[] {7,1,5,3,6,4) = " + maxProfit(new int[] {7,1,5,3,6,4}));
    System.out.println("maxProfit(new int[] {7, 6, 4, 3, 1) = " + maxProfit(new int[] {7, 6, 4, 3, 1}));

    System.out.println("\nUsing linear solution: O(n) runtime and O(1) space complexities");
    System.out.println("maxProfit2(new int[] {7,1,5,3,6,4) = " + maxProfit2(new int[] {7,1,5,3,6,4}));
    System.out.println("maxProfit2(new int[] {7, 6, 4, 3, 1) = " + maxProfit2(new int[] {7, 6, 4, 3, 1}));
  }
}
