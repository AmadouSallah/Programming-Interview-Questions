/*
Leetcode Problem 144. Binary Tree Preorder Traversal

https://leetcode.com/problems/binary-tree-preorder-traversal/description/

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
1
  \
   2
  /
3
return [1, 2, 3]

Note: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class ProrderTraversal {
  private class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x;}
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode current = stack.pop();
      result.add(current.val);
      if (current.right != null) stack.push(current.right);
      if (current.left != null) stack.push(current.left);
    }
    return result;
  }
}
