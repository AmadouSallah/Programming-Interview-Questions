/*

Leetcode Problem 226. Invert Binary Tree

Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/

import java.util.Queue;
import java.util.LinkedList;

public class InvertTree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {val = x;}
  }

  // Recursive Solution: O(n) runtime and O(n) space complexities
  public static TreeNode invertTree(TreeNode root) {
    if (root == null) return root;

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.left = right;
    root.right = left;

    return root;
  }

  // Iterative solution: O(n) runtime and O(n) space
  public static TreeNode invertTree2(TreeNode root) {

    if (root == null) return root;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {

      TreeNode current = queue.poll();
      TreeNode temp = current.left;
      current.left = current.right;
      current.right = temp;

      if (current.left != null) queue.add(current.left);
      if (current.right != null) queue.add(current.right);
    }

    return root;
  }

}

