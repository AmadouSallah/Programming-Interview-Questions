/*
Problem 94: Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.List;
import java.util.ArrayList;

/* RECURSIVE SOLUTION */
public class InorderTraversal {

  public class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
  }

  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    helper(root, list);
    return list;
  }

  public static void helper(TreeNode root, List<Integer> list) {
    if (root != null) {

      if (root.left != null)
        helper(root.left, list);

      list.add(root.val);

      if (root.right != null)
        helper(root.right, list);
    }
  }

}
