/*

3Sum:
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array
which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order.
(ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

  public static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    if ((nums == null) || (nums.length < 3)) {
      return result;
    }

    Arrays.sort(nums);

    int n = nums.length;

    for (int i = 0; i < n-2; i++) {

      // Skip identical elements to avoid duplicate
      if ((i > 0) && (nums[i] == nums[i-1]))
        continue;

      int left = i+1, right = n-1;
      while (left < right) {

        int sum = nums[i] + nums[left] + nums[right];

        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;

          // Move the left cursor to the right to skip identical elements
          while ( (left < right) && (nums[left-1] == nums[left]) )
            left++;

          // Move the right cursor to the left to skip identical elements
          while ( (left < right) && (nums[right] == nums[right+1]))
            right--;

        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }

      }

    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println("threeSum(null) = " + threeSum(null));
    System.out.println("threeSum(new int[] {-1}) = " + threeSum(new int[] {-1}));
    System.out.println("threeSum(new int[] {-1, 0}) = " + threeSum(new int[] {-1, 0}));
    System.out.println("threeSum(new int[] {-1, 0, 1, 2, -1, -4}) = " + threeSum(new int[] {-1, 0, 1, 2, -1, -4}));

  }

}