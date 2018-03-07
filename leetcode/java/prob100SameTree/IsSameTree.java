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
    if (p == null && q == null) return true;
    if (p == null || q == null) return false; // only 1 of them is null
    if (p.val != q.val) return false; // none of them is null
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
