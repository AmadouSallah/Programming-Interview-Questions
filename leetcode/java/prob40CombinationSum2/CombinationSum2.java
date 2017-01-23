/*
Problem 40: Combination Sum II

Given a collection of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is: [[1, 7], [1, 2, 5], [2, 6], [1, 1, 6]]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (candidates == null || candidates.length == 0) return result;
    Arrays.sort(candidates);
    List<Integer> tempList = new ArrayList<>();
    combinatonSum2Helper(candidates, target, result, tempList, 0);
    return result;
  }

  public static void combinatonSum2Helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> tempList, int start) {
    if (target < 0) {
      return;
    } else if (target == 0) {
      result.add(new ArrayList<>(tempList));
      return;
    } else {
      int n = candidates.length;
      for (int i = start; i < n; i++) {
        if (i > start && candidates[i] == candidates[i-1]) continue; // skip duplicates
        tempList.add(candidates[i]);
        combinatonSum2Helper(candidates, target - candidates[i], result, tempList, i+1);
        // i+1 instead of i since we don't want to reuse same elements
        tempList.remove(tempList.size() - 1); // remove last element before going to next iteration
      }
    }
  }

  public static void main (String[] args) {
    System.out.println("combinationSum2([10, 1, 2, 7, 6, 1, 5], 8) = " + combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
  }
}