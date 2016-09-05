/*
Prob 78: Subsets

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], []]

Follow up: (Problem 90, Subsets II)
Do it for the case where there might be duplicates in the input array nums.

For example
If nums = [1,2,2], a solution is: [[2], [1], [1,2,2], [2,2], [1,2], [] ]

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// Resources: https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning

public class Subsets {
  public static List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    if (nums == null) return result;

    List<Integer> tempList = new ArrayList<Integer>();

    subsetsHelper(nums, result, tempList, 0);

    return result;
  }

  private static void subsetsHelper(int[] nums, List<List<Integer>> result, List<Integer> tempList, int start) {
    result.add(new ArrayList<>(tempList));

    for (int i = start; i<nums.length; i++) {
      tempList.add(nums[i]);
      subsetsHelper(nums, result, tempList, i+1);
      tempList.remove(tempList.size()-1);
    }
  }

  // Follow up: There might be duplicates in nums:
  public static List<List<Integer>> subsetsII(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    if (nums == null) return result;

    Arrays.sort(nums);
    List<Integer> tempList = new ArrayList<Integer>();

    subsetsHelperII(nums, result, tempList, 0);

    return result;
  }

  private static void subsetsHelperII(int[] nums, List<List<Integer>> result, List<Integer> tempList, int start) {

    // Add tempList to result if it is not already there - in order to avoid duplicates
    if (!result.contains(tempList)) result.add(new ArrayList<>(tempList));

    for (int i = start; i<nums.length; i++) {
      //if (i > start && nums[start] == nums[start-1]) continue; // skip duplicates

      tempList.add(nums[i]);
      subsetsHelperII(nums, result, tempList, i+1);
      tempList.remove(tempList.size()-1);
    }
  }

  public static void main(String[] args) {
    System.out.println("subsets(null) = " + subsets(null));
    System.out.println("subsets(new int[] {}) = " + subsets(new int[] {}));
    System.out.println("subsets(new int[] {1}) = " + subsets(new int[] {1}));
    System.out.println("subsets(new int[] {1, 2}) = " + subsets(new int[] {1, 2}));
    System.out.println("subsets(new int[] {1, 2, 3}) = " + subsets(new int[] {1, 2, 3}));

    System.out.println("\nTesting for cases where there might be duplicates:");
    System.out.println("subsetsII(null) = " + subsetsII(null));
    System.out.println("subsetsII(new int[] {}) = " + subsetsII(new int[] {}));
    System.out.println("subsetsII(new int[] {1}) = " + subsetsII(new int[] {1}));
    System.out.println("subsetsII(new int[] {1, 1}) = " + subsetsII(new int[] {1, 1}));
    System.out.println("subsetsII(new int[] {1, 2, 2}) = " + subsetsII(new int[] {1, 2, 2}));
  }
}