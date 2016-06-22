/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical
and the nodes have the same value.
*/

public class IsSameTree {

  // Definition for a binary tree node.
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if (p != null && q != null) {
      return ( (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right) );
    } else { // one of them is null and the other one is not.
      return false;
    }
  }
}