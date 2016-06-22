/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical
and the nodes have the same value.
*/

package treesPackage;

public class Prob11SameTree {

  public static boolean isSameTree(Node root1, Node root2) {
    if (root1 == null && root2 == null) return true;
    else if (root1 != null && root2 != null) {
      return ( (root1.getData() == root2.getData()) && isSameTree(root1.getLeftChild(), root2.getLeftChild()) && isSameTree(root1.getRightChild(), root2.getRightChild()) );
    } else { // one of them is null and the other one is not.
      return false;
    }
  }
}