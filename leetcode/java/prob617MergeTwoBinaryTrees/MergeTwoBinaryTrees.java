/*
Leetcode Problem 617: Merge Two Binary Trees

https://leetcode.com/problems/merge-two-binary-trees/description/

Given two binary trees and imagine that when you put one of them to cover the other,
some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be
used as the node of new tree.

Example 1:
Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7

Note: The merging process must start from the root nodes of both trees.
*/

import java.util.Stack;

public class MergeTwoBinaryTrees {

  public static class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int x) {
      val = x;
    }
  }

  // Recursive Solution: O(n) Runtime where n is the minimum number of nodes from the 2 input trees
  // Space complexities - depth of the recursion: worst case is O(n) and average case is O(log n).
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) return t2;
    if (t2 == null) return t1;
    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    return t1;
  }

  // Iterative Solutioh: O(n) Runtime and O(n) space complexities
  // where n is the minimum number of nodes from the 2 input trees
  public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {

    if (t1 == null) return t2;

    Stack<TreeNode[]> stack = new Stack<>();
    stack.push(new TreeNode[] {t1, t2});

    while (!stack.isEmpty()) {
      TreeNode[] t = stack.pop();

      if (t[0] == null || t[1] == null) continue;

      t[0].val += t[1].val;

      if (t[0].left == null) {
        t[0].left = t[1].left;
      } else {
        stack.push(new TreeNode[] {t[0].left, t[1].left});
      }

      if (t[0].right == null) {
        t[0].right = t[1].right;
      } else {
        stack.push(new TreeNode[] {t[0].right, t[1].right});
      }
    }
    return t1;
  }
}
