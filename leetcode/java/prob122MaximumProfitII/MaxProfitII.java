/*
Problem 122: Best Time to Buy and Sell Stock II

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions
as you like (ie, buy one and sell one share of the stock multiple times). However,
you may not engage in multiple transactions at the same time
(ie, you must sell the stock before you buy again).

*/

public class MaxProfitII {

  public static int maxProfit(int[] prices) {

    int max = 0, diff, n = prices.length;

    for (int i = 1; i < n; i++) {
      diff = prices[i] - prices[i-1];
      if (diff > 0) max += diff;
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println("maxProfit(new int[] {}) = " + maxProfit(new int[] {})); // 0
    System.out.println("maxProfit(new int[] {7, 1, 5, 3, 6, 4}) = " + maxProfit(new int[] {7, 1, 5, 3, 6, 4})); // (5-1) + (6-3) = 7
    System.out.println("maxProfit(new int[] {7, 6, 4, 3, 1}) = " + maxProfit(new int[] {7, 6, 4, 3, 1})); // 0
  }
}