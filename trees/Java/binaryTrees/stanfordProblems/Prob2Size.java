/*
This problem demonstrates simple binary tree traversal.
Given a binary tree, count the number of nodes in the tree.
*/

package stanfordPackage;

public class Prob2Size {
  public static int size(Node root) {

    if (root == null) return 0;

    return (1 + size(root.getLeftChild()) + size(root.getRightChild()) );
  }
}