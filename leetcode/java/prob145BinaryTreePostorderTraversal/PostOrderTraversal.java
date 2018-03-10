/*
Leetcode Problem 145: Binary Tree Postorder Traversal
https://leetcode.com/problems/binary-tree-postorder-traversal/description/

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) return result;

    Stack<TreeNode> stack = new Stack();
    stack.push(root);
    TreeNode current;

    while (!stack.isEmpty()) {
      current = stack.pop();
      result.add(0, current.val);

      if (current.left != null) stack.push(current.left);
      if (current.right != null) stack.push(current.right);
    }

    return result;
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
    }
  }
}
