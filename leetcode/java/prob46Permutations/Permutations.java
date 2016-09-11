/*
Problem 46: Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

import java.util.List;
import java.util.ArrayList;

public class Permutations {

  public static List<List<Integer>> permutations(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    if (nums == null || nums.length == 0) return result;

    List<Integer> tempList = new ArrayList<Integer>();

    permute(nums, result, tempList);

    return result;
  }

  public static void permute(int[] nums, List<List<Integer>> result, List<Integer> tempList) {

    if (tempList.size() == nums.length) {
      result.add(new ArrayList<>(tempList));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      int currentElement = nums[i];
      if (!tempList.contains(currentElement)) {
        tempList.add(currentElement);
        permute(nums, result, tempList);
        tempList.remove(tempList.size()-1);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("permutations(null) = " + permutations(null));
    System.out.println("permutations(new int[] {}) = " + permutations(new int[] {}));
    System.out.println("permutations(new int[] {1}) = " + permutations(new int[] {1}));
    System.out.println("permutations(new int[] {1, 2}) = " + permutations(new int[] {1, 2}));
    System.out.println("permutations(new int[] {1, 2, 3}) = " + permutations(new int[] {1, 2, 3}));
  }
}