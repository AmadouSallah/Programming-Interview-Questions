/*
Leetcode Problem 103: Binary Tree Zigzag Level Order Traversal

https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[[3], [20,9], [15,7]]

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ZigzagLevelOrder {

  public class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();

    if (root == null) return result;

    // leftToRight will indicate the direction. if true, then we go from left to right, otherwise we go right to left.
    boolean leftToRight = true; // we initially go left to right

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {

        List<Integer> list = new ArrayList<Integer>();
        int n = queue.size();

      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();
        int nodeValue = node.val;

        // if the direction is left to right, we insert the nodeValue to the end of list;
        // otherwise, we insert it at index 0 of list
        if (leftToRight) {
          list.add(nodeValue); // insert nodeValue at the end of list
        } else {
          list.add(0, nodeValue); // insert nodeValue at the beginning of list
        }

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }

      // we add list to result and change the direction
      result.add(list);
      leftToRight = leftToRight ? false : true;
    }
    return result;
  }
}