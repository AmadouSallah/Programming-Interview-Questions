/*
Problem 47: Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PermuteUnique {

  public static List<List<Integer>> permuteUnique(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    if (nums == null || nums.length == 0) return result;

    Arrays.sort(nums);

    int n = nums.length;
    boolean[] used = new boolean[n];
    List<Integer> tempList = new ArrayList<Integer>();

    permuteHelper(nums, result, tempList, used);

    return result;
  }

  public static void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> tempList, boolean[] used) {

    if (tempList.size() == nums.length) {
      result.add(new ArrayList<>(tempList));
      return;
    }

    for (int i = 0; i < nums.length; i++) {

      if (used[i] || (i > 0 && (nums[i] == nums[i-1]) && !used[i-1]) ) continue;

      tempList.add(nums[i]);
      used[i] = true;
      permuteHelper(nums, result, tempList, used);
      used[i] = false;
      tempList.remove(tempList.size() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println("permuteUnique(null) = " + permuteUnique(null));
    System.out.println("permuteUnique(new int[] {}) = " + permuteUnique(new int[] {}));
    System.out.println("permuteUnique(new int[] {1}) = " + permuteUnique(new int[] {1}));
    System.out.println("permuteUnique(new int[] {1, 1}) = " + permuteUnique(new int[] {1, 1}));
    System.out.println("permuteUnique(new int[] {1, 2}) = " + permuteUnique(new int[] {1, 2}));
    System.out.println("permuteUnique(new int[] {1, 2, 3}) = " + permuteUnique(new int[] {1, 2, 3}));
    System.out.println("permuteUnique(new int[] {1, 1, 2}) = " + permuteUnique(new int[] {1, 1, 2}));
  }
}