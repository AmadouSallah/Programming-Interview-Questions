/*
https://leetcode.com/problems/combinations/description/

Problem 77: 77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

import java.util.List;
import java.util.ArrayList;

public class Combinations {

  // Backtracking solution 
  public static List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    combineHelper(n, k, result, tempList, 1);
    return result;
  }

  public static void combineHelper(int n, int k, List<List<Integer>> result, List<Integer> tempList, int start) {
    if (k == 0) {
      result.add(new ArrayList<>(tempList));
      return;
    }

    for (int i = start; i <= n; i++) {
      tempList.add(i);
      combineHelper(n, k-1, result, tempList, i+1);
      tempList.remove(tempList.size() - 1);
    }
  }

  // Very slow, exponential solution
  public static List<List<Integer>> combine2(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    combineHelper2(n, k, result, tempList, 1);
    return result;
  }

  public static void combineHelper2(int n, int k, List<List<Integer>> result, List<Integer> tempList, int start) {

    if (tempList.size() == k) {
      result.add(new ArrayList<>(tempList));
      return;
    }
    if (start > n) {
      return;
    }

    combineHelper2(n, k, result, new ArrayList<>(tempList), start + 1);
    tempList.add(start);
    combineHelper2(n, k, result, new ArrayList<>(tempList), start + 1);
  }

  public static void main(String[] args) {
    System.out.println("combine(4, 2) = " + combine(4, 2));
    System.out.println("combine2(4, 2) = " + combine2(4, 2));
  }
}
