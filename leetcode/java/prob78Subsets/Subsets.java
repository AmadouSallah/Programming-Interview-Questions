/*
Prob 78: Subsets

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], []]
*/

import java.util.List;
import java.util.ArrayList;

public class Subsets {
  public static List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    if (nums == null || nums.length == 0) return result;

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

  public static void main(String[] args) {
    System.out.println("subsets(null) = " + subsets(null));
    System.out.println("subsets(new int[] {}) = " + subsets(new int[] {}));
    System.out.println("subsets(new int[] {1}) = " + subsets(new int[] {1}));
    System.out.println("subsets(new int[] {1, 2}) = " + subsets(new int[] {1, 2}));
    System.out.println("subsets(new int[] {1, 2, 3}) = " + subsets(new int[] {1, 2, 3}));
  }
}