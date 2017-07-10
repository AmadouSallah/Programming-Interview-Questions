/*
Resource: https://leetcode.com/problems/binary-tree-vertical-order-traversal/#/description

Leetcode Problem 314. Binary Tree Vertical Order Traversal

Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

1. Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as: [[9], [3,15], [20], [7]]

2. Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as: [[4], [9], [3,0,1], [8], [7]]

3. Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as: [[4], [9,5], [3,0,1], [8,2], [7]]

*/

import java.util.*;

public class VerticalOrderTraversal {

  public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }
    public List<List<Integer>> verticalOrder(TreeNode root) {

      List<List<Integer>> result = new ArrayList<>();
      if (root == null) return result;

      Map<Integer, List<Integer>> map = new HashMap<>(); // key will be column number and value will be the list of all elements on that column
      Queue<TreeNode> queue = new LinkedList<>(); // queue will contain the tree nodes
      Queue<Integer> columns = new LinkedList<>(); // columns will contain the columns of the tree
      int minColumn = 0, maxColumn = 0;

      queue.add(root);
      columns.add(0); // root is at column 0;

      while (!queue.isEmpty()) {

        TreeNode node = queue.poll();
        int col = columns.poll();

        // if col has not been seen yet, we add it to map with value an empty list
        if (!map.containsKey(col)) {
          map.put(col, new ArrayList<>());
        }
        // we add the value of current node to queue
        map.get(col).add(node.val);

        // if node has a left (respectively right) child, add it to queue and add col-1
        // (respectively col+1) to columns. Then update minColumn and maxColumn
        if (node.left != null) {
          int nextLeftColumn = col-1;
          queue.add(node.left);
          columns.add(nextLeftColumn);
          minColumn = Math.min(minColumn, nextLeftColumn);
        }
        if (node.right != null) {
          int nextRightColumn = col + 1;
          queue.add(node.right);
          columns.add(nextRightColumn);
          maxColumn = Math.max(maxColumn, nextRightColumn);
        }
      }

      // Iterate through keys of map and add the corresponding list values to result
      for (int i = minColumn; i <= maxColumn; i++) {
        result.add(map.get(i));
      }

      return result;
  }
}
