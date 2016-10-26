/*
Problem 113: Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[[5,4,11,2], [5,8,4,5]]

*/

import java.util.List;
import java.util.ArrayList;

public class PathSumII {

  public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static List<List<Integer>> pathSum(TreeNode root, int sum) {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> tempList = new ArrayList<>();

    pathSumHelper(root, sum, result, tempList);

    return result;
  }

    public static void pathSumHelper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> tempList) {

      if (root == null) return;

      tempList.add(root.val);
      int newSum = sum - root.val;

      if (newSum == 0 && root.left == null && root.right == null) {
          result.add(new ArrayList<>(tempList));
          return;
      }

      pathSumHelper(root.left, newSum, result, new ArrayList<>(tempList));
      pathSumHelper(root.right, newSum, result, new ArrayList<>(tempList));
    }

}