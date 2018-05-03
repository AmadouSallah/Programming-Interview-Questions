/*
Leetcode Problem 198: House Robber

https://leetcode.com/problems/house-robber/description/

You are a professional robber planning to rob houses along a street. Each house has a certain amount
of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses
have security system connected and it will automatically contact the police if two adjacent houses
were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine
the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
        Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
*/

public class HouseRobber {
  public static int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int n = nums.length;
    if (n == 1) return nums[0];

    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
    }

    return dp[n-1];
  }

  public static void main(String[] args) {
    int[] arr1 = new int[] {1,2,3,1};
    int[] arr2 = new int[] {2,7,9,3,1};
    System.out.println("rob[1,2,3,1] = " + rob(arr1)); // 4
    System.out.println("rob[2,7,9,3,1] = " + rob(arr2)); // 12
  }
}
