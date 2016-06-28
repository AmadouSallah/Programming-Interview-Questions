/*
http://cslibrary.stanford.edu/110/BinaryTrees.pdf
http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

A binary search tree (BST) is a node based binary tree data structure which has the following properties.
• The left subtree of a node contains only nodes with keys less than the node’s key.
• The right subtree of a node contains only nodes with keys greater than the node’s key.
• Both the left and right subtrees must also be binary search trees.

From the above properties it naturally follows that:
• Each node (item in the tree) has a distinct key.

Write a function, isBST(), that returns true if a tree is a binary search tree and false otherwise.

Version 1:
Suppose you have helper functions minValue() and maxValue() that return the
min or max int value from a non-empty tree. Use the helper functions, and don't
forget to check every node in the tree. It's ok if your solution is not very efficient.

Version 2:
Version 1 above runs slowly since it traverses over some parts of the tree many times.
A better solution looks at each node only once. The trick is to write a utility helper
function isBSTRecur(struct node* node, int min, int max) that traverses down the tree
keeping track of the narrowing min and max allowed values as it goes, looking at each node
only once. The initial values for min and max should be INT_MIN and INT_MAX -- they narrow from there.
*/

package treesPackage;

public class Prob12IsBST {


  // Version 1
  public static boolean isBST1(Node root) {
    if (root == null) return true;

    // In a BST, the left subtree of a node contains only nodes with keys less than the node’s key.
    // So if the max of the left subtree is greater than the current node's value, we return false
    if (root.getLeftChild() != null && root.getData() < maxValue(root.getLeftChild()))
      return false;

    // In a BST, the right subtree of a node contains only nodes with keys greater than the node’s key.
    // So if the max of the right subtree is less than the current node's value, we return false
    if (root.getRightChild() != null && root.getData() > minValue(root.getRightChild()))
      return false;

    // in a BST, both the left and right subtrees must also be binary search trees.
    // So we check that the subtrees themselves are ok by making a recursive call on them
    return (isBst1(root.getLeftChild()) && isBst1(root.getRightChild()));
  }


  /*
  Version 1 above runs slowly since it traverses over some parts of the tree many times.
  A better solution looks at each node only once. The trick is to write a utility helper
  function isBST2(Node root, int min, int max) that traverses down the tree
  keeping track of the narrowing min and max allowed values as it goes, looking at each
  node only once. The initial values for min and max should be Integer.MIN_VALUE and
  int Integer.MAX_VALUE -- they narrow from there.
  */

  // Version 2:
  public static boolean isBST2(Node root) {
    return isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean isBST2(Node node, int min, int max) {
    // an empty tree is a BST
    if (node == null) return true;

    // if node violates the min/max constraints, we return false
    if (node.getData() < min || node.getData() > max) return false;

    // left subtree should be in the range of min...node.getData()
    // and right subtree in the range of node.getData+1...max
    return isBST2(node.getLeftChild(), min, node.getData()) && isBST2(node.getRightChild(), node.getData()+1, max);
  }

}