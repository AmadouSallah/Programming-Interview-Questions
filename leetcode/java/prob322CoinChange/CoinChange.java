/*
Problem 322. Coin Change

You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

*/

import java.util.Arrays;

public class CoinChange {
  // O(nm) runtime and O(m) space complexities, where n = coins.length and m = amount 
  public static int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0; // it takes 0 number of coins to form an amount of 0
    for (int i = 1; i <= amount; i++) { // i represpents current amount
      for (int j = 0; j < coins.length; j++) { // j represpents the coin index
        int currentCoin = coins[j];
        int remainingAmount = i - currentCoin;
        if (remainingAmount >= 0) {
          // we take the minimum between choosing the current coin (1 + dp[remainingAmount])
          // and not choosing the current coin (dp[i])
          dp[i] = Math.min(dp[i], 1 + dp[remainingAmount]);
        }
      }
    }
    return (dp[amount] > amount) ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    int[] coins1 = {1,2,5};
    int[] coins2 = {2};
    System.out.println("coinChange([1, 2, 5], 11) = " + coinChange(coins1, 11));
    System.out.println("coinChange([2], 3) = " + coinChange(coins2, 3));
  }
}
