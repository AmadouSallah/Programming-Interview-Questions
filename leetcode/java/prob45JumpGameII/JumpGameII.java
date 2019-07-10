/*
Leetcode Problem 45. Jump Game II
https://leetcode.com/problems/jump-game-ii/description/

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.
*/

public class JumpGameII {
  public static int jump(int[] nums) {
    int numberOfJumps = 0, right = 0, maxJump = 0;
    for (int i = 0; i < nums.length-1; i++) {
      maxJump = Math.max(maxJump, i + nums[i]);
      if (i == right) {
        right = maxJump;
        numberOfJumps++;
      }
    }
    return numberOfJumps;
  }

  public static void main(String[] args) {
    System.out.println("jump([]) = " + jump(new int[] {}));
    System.out.println("jump([1]) = " + jump(new int[] {1}));
    System.out.println("jump([2,3,1,1,4]) = " + jump(new int[] {2,3,1,1,4}));
  }
}
