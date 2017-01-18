/*
Problem 39: Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is: [ [7], [2, 2, 3] ]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
  public static List<List<Integer>> combinationsSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    combinationSumHelper(candidates, target, result, tempList, 0);
    return result;
  }

  public static void combinationSumHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> tempList, int start) {
    if (target < 0) {
      return;
    } else if (target == 0) {
      result.add(new ArrayList<>(tempList));
      return;
    } else { // target > 0
      int n = candidates.length;
      for (int i = 0; i < n; i++) {
        tempList.add(candidates[i]);
        combinationSumHelper(Arrays.copyOfRange(candidates, i, n), target - candidates[i], result, tempList, i);
        // not i+1 since the same element could be reused
        tempList.remove(tempList.size()-1);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("combinationsSum([2, 3, 6, 7], 7) = " + combinationsSum(new int[] {2, 3, 6, 7}, 7));
  }
}