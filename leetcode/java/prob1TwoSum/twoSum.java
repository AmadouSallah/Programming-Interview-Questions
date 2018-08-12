/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Follow up: What if the input array is sorted in ascending order?
*/

import java.util.HashMap;
import java.util.Map;

public class twoSum {

  // O(n^2) runtime and O(n) space complexities
  public static int[] twoSum(int[] nums, int target) {

    if (nums == null || nums.length < 2) return new int[0];

    int n = nums.length;

    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        if (nums[i] + nums[j] == target)
          return new int[] {i, j};
      }
    }
    return new int[0];
  }

  // O(n) runtime and O(n) space complexities
  public static int[] twoSumII(int[] nums, int target) {
    if (nums == null || nums.length < 2) return new int[0];

    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement))
        return new int[] {map.get(complement), i};
      else
        map.put(nums[i], i);
    }
    return new int[0];
  }


  // Follow up: What if input array is sorted in ascending order (Leetcode Problem 167)
  // O(n*long(n)) runtime and O(1) space complexities
  public static int[] twoSumIII(int[] nums, int target) {

    if (nums == null || nums.length < 2) return new int[0];

      int n = nums.length, left = 0, right = n-1, sum = 0;

      while (left < right) {
        sum = nums[left] + nums[right];
        if (sum == target) {
          return new int[] {left, right};
        } else if (sum < target) { // Decreasing right will not help since it will make sum even smaller. So we increment left
          left++;
        } else { // Increasing left will not help since it will make sum even bigger. So we decrement right
          right--;
        }
      }
      return new int[0];
  }

  public static String printArray(int[] arr) {
        String s = "[";
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            s += arr[i] + ", ";
        s += (n > 0) ? (arr[n-1] + "]") : "]";
        return s;
    }

  public static void main(String[] args) {
    
    System.out.println("\nSolution 1: O(n^2) runtime and O(1) space complexities");
    System.out.println("twoSum(new int[] {}, 9): " + printArray(twoSum(new int[] {}, 9)));
    System.out.println("twoSum(new int[] {1}, 9): " + printArray(twoSum(new int[] {1}, 9)));
    System.out.println("twoSum(new int[] {2, 7}, 9): " + printArray(twoSum(new int[] {2, 7}, 9)));
    System.out.println("twoSum(new int[] {2, 15, 11, 7}, 9): " + printArray(twoSum(new int[] {2, 15, 11, 7}, 9)));

    System.out.println("\nSolution 2: O(n) runtime and O(n) space complexities");
    System.out.println("twoSumII(new int[] {}, 9): " + printArray(twoSumII(new int[] {}, 9)));
    System.out.println("twoSumII(new int[] {1}, 9): " + printArray(twoSumII(new int[] {1}, 9)));
    System.out.println("twoSumII(new int[] {2, 7}, 9): " + printArray(twoSumII(new int[] {2, 7}, 9)));
    System.out.println("twoSumII(new int[] {2, 7, 9, 11}, 9): " + printArray(twoSumII(new int[] {2, 15, 11, 7}, 9)));

    System.out.println("\nSolution 3: Assuming that the input array is sorted in increasing order:");
    System.out.println("twoSumIII(new int[] {}, 9): " + printArray(twoSumIII(new int[] {}, 9)));
    System.out.println("twoSumIII(new int[] {1}, 9): " + printArray(twoSumIII(new int[] {1}, 9)));
    System.out.println("twoSumIII(new int[] {2, 7}, 9): " + printArray(twoSumIII(new int[] {2, 7}, 9)));
    System.out.println("twoSumIII(new int[] {2, 7, 9, 11}, 9): " + printArray(twoSumIII(new int[] {2, 15, 11, 7}, 9)));
  }

}
