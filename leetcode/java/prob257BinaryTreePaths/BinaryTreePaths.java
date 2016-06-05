/*
Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

       1
     /   \
    2     3
     \
      5
All root-to-leaf paths are:

["1->2->5", "1->3"]

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.List;
import java.util.ArrayList;

 public class BinaryTreePaths {

  public static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode (int x) {
        val = x;
    }
  }

  public static List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<String>();
    findPaths(root, result, "");
    return result;
  }

  public static void findPaths(TreeNode node, List<String> result, String path) {
    if (node == null) return;

    path += node.val;

    if (node.left == null && node.right == null) {
      result.add(path);
      return;
    } else {
      path += "->";
      findPaths(node.left, result, path);
      findPaths(node.right, result, path);
    }

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);

    root.left = node2;
    root.right = node3;
    node2.right = node5;

    // node3.left = new TreeNode(6);
    // node3.right = new TreeNode(7);

    System.out.println(binaryTreePaths(root));
    System.out.println(binaryTreePaths(node2));
    System.out.println(binaryTreePaths(node5));
    // System.out.println(binaryTreePaths(node3));
  }
 }