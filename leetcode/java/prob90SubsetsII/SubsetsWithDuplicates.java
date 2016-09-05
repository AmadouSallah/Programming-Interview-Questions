/*
Problem 90: Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is: [[2], [1], [1,2,2], [2,2], [1,2], [] ]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsWithDuplicates {

  public static List<List<Integer>> subsetsII(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    if (nums == null) return result;

    Arrays.sort(nums);
    List<Integer> tempList = new ArrayList<Integer>();

    subsetsHelperII(nums, result, tempList, 0);

    return result;
  }

  private static void subsetsHelperII(int[] nums, List<List<Integer>> result, List<Integer> tempList, int start) {

    // Add tempList to result only if it is not already present
    if (!result.contains(tempList)) result.add(new ArrayList<>(tempList));

    for (int i = start; i<nums.length; i++) {
      tempList.add(nums[i]);
      subsetsHelperII(nums, result, tempList, i+1);
      tempList.remove(tempList.size()-1);
    }
  }

  public static void main(String[] args) {
    System.out.println("subsetsII(null) = " + subsetsII(null));
    System.out.println("subsetsII(new int[] {}) = " + subsetsII(new int[] {}));
    System.out.println("subsetsII(new int[] {1}) = " + subsetsII(new int[] {1}));
    System.out.println("subsetsII(new int[] {1, 1}) = " + subsetsII(new int[] {1, 1}));
    System.out.println("subsetsII(new int[] {1, 2, 3}) = " + subsetsII(new int[] {1, 2, 3}));
    System.out.println("subsetsII(new int[] {1, 2, 2}) = " + subsetsII(new int[] {1, 2, 2}));
  }
}