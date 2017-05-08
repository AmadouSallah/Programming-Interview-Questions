/*
Problem 107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[[15,7], [9,20], [3]]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderBottomUp {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int n = queue.size();

      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();
        list.add(node.val);

        if (node.left != null) queue.add(node.left);
        if (node.right !=  null) queue.add(node.right);
      }
      result.add(0, list);
    }
    return result;
  }
}
