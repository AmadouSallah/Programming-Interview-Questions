/*
Leetcode Problem 518. Coin Change 2

https://leetcode.com/problems/coin-change-2/description/

You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.

Note: You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
*/

public class CoinChange2 {
  public static int change(int amount, int[] coins) {
    int[] dp = new int[amount+1];
    // dp[i] will store the number of solutions for amount i
    dp[0] = 1; // for amount = 0, only 1 possible solution, i.e. not choose any value
    for (int i = 0; i < coins.length; i++) {
      int coin = coins[i];
      for (int j = coin; j <= amount; j++) {
        dp[j] += dp[j-coin];
      }
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    System.out.println("change(5, [1,2,5]) = " + change(5, new int[] {1,2,5}));
    System.out.println("change(3, [2]) = " + change(3, new int[] {2}));
    System.out.println("change(10, [10]) = " + change(10, new int[] {10}));
  }
}
