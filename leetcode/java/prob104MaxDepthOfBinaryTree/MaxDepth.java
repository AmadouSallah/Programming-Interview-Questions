/*

Problem 104: Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node
down to the farthest leaf node.

*/

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class MaxDepth {

  public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Recursive solution:
  public int maxDepth(TreeNode root) {

    if (root == null) return 0;

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    return 1 + Math.max(left, right);
  }

  // Iterative solution: BFS
  public int maxDepthBFS(TreeNode root) {
    if (root == null) return 0;

    int count = 0;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      count++;
    }
    return count;
  }

  // Iterative solution: DFS
  public int maxDepthDFS(TreeNode root) {

    if (root == null) return 0;

    int count = 0;
    Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    Stack<Integer> heightStack = new Stack<Integer>();
    nodeStack.push(root);
    heightStack.push(1); // height of root is 1

    while (!nodeStack.isEmpty()) {

      TreeNode node = nodeStack.pop();
      int height = heightStack.pop();
      count = Math.max(count, height);
      int nextLevelHeight = height+1;

      if (node.left != null) {
        nodeStack.push(node.left);
        heightStack.push(nextLevelHeight);;
      }
      if (node.right != null) {
        nodeStack.push(node.right);
        heightStack.push(nextLevelHeight);;
      }
    }
    return count;
  }
}
