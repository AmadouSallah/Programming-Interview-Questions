/*
Leetcode Problem 55: https://leetcode.com/problems/jump-game/description/

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public class CanJump {
  public static boolean canJump(int[] nums) {
    int n = nums.length, position = n-1;
    for (int i = n-1; i >= 0; i--) {
      if (i + nums[i] >= position) {
        position = i;
      }
    }
    return position == 0;
  }

  public static void main(String[] args) {
    System.out.println("canJump[2, 3, 1, 1, 4] = " + canJump(new int[] {2, 3, 1, 1, 4}));
    System.out.println("canJump[3, 2, 1, 0, 4] = " + canJump(new int[] {3, 2, 1, 0, 4}));
  }
}
