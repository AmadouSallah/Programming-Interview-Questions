/*
From: https://leetcode.com/problems/binary-tree-paths/

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

package treesPackage;

import java.util.List;
import java.util.ArrayList;

public class Prob8bPrintPaths {

  public static List<String> printPaths(Node root) {
    List<String> result = new ArrayList<String>();
    findPaths(root, result, "");
    return result;
  }

  public static void findPaths(Node root, List<String> result, String path) {

    if (root == null) return;

    path += root.getData();

    if (root.getLeftChild() == null && root.getRightChild() == null) {
      result.add(path);
      return;
    } else {
      path += "->";
      findPaths(root.getLeftChild(), result, path);
      findPaths(root.getRightChild(), result, path);
    }
  }

  public static void main(String[] args) {
    /*
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

    */
    Node node1 = new Node(5);
    Node node2 = new Node(4);
    Node node3 = new Node(8);
    Node node4 = new Node(11);
    Node node5 = new Node(13);
    Node node6 = new Node(4);
    Node node7 = new Node(7);
    Node node8 = new Node(2);
    Node node9 = new Node(1);

    node1.setLeftChild(node2);
    node1.setRightChild(node3);

    node2.setLeftChild(node4);

    node3.setLeftChild(node5);
    node3.setRightChild(node6);

    node4.setLeftChild(node7);
    node4.setRightChild(node8);

    node6.setRightChild(node9);

    System.out.println(printPaths(node1)); // ["5->4->11->7", "5->4->11->2", "5->8->13", "5->8->4->1"]
  }
}