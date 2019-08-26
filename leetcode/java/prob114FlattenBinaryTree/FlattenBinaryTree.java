/*
Leetcode Problem 114: Flatten Binary Tree to Linked List
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/
import java.util.Stack;

public class FlattenBinaryTree {

  public static class TreeNode {
    int value;
    TreeNode left, right;
    public TreeNode(int value) {
      this.value = value;
    }
  }
  public static void flatten(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    TreeNode current;

    while (!stack.isEmpty()) {
      current = stack.pop();
      if (current.right != null) stack.push(current.right);
      if (current.left != null) stack.push(current.left);

      current.left = null;
      if (!stack.isEmpty()) current.right = stack.peek();
    }
  }
}
