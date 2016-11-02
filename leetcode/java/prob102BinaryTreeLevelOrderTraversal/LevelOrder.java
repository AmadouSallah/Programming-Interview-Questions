/*
Leetcode Problem 102: Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
      3
     / \
    9  20
      /  \
     15   7
return its level order traversal as:
[[3], [9,20], [15,7] ]

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LevelOrder {

  public class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {

      List<Integer> list = new ArrayList<Integer>();
      int level = queue.size();

      for (int i = 0; i < level; i++) {
        TreeNode node = queue.poll();  // queue.remove() would work too
        list.add(node.val);

        if (node.left != null) queue.offer(node.left); // queue.add(node.left) would also work
        if (node.right != null) queue.offer(node.right); // Or queue.add(node.right)
      }

      result.add(list);
    }
    return result;
  }
}