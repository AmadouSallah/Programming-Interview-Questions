/*

Move Zeroes

Given an array nums, write a function to move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function,
nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/

public class MoveZeroes {
  public static void moveZeroes(int[] nums) {

    if (nums == null || nums.length == 0) return;

    int i = 0, len = nums.length;
    for (int j = 0; j < len; j++) {
      if (nums[j] != 0)
        nums[i++] = nums[j];
    }

    while (i < len)
      nums[i++] = 0;

  }

  public static void main(String[] args) {
    moveZeroes(null);
    moveZeroes(new int[]{});
    moveZeroes(new int[]{1});
    moveZeroes(new int[]{0, 1, 0, 3, 12});
    moveZeroes(new int[]{0});
  }

}