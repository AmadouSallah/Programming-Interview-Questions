/*
From: http://cslibrary.stanford.edu/110/BinaryTrees.pdf

doubleTree()

Write a program that converts a given tree to its Double tree.
That is, for each node in a binary search tree, create a new duplicate node,
and insert the duplicate as the left child of the original node.
The resulting tree should still be a binary search tree.

 So the tree...
     2
    / \
   1   3
 is changed to...
          2
         / \
        2   3
       /   /
      1   3
    /
   1

*/


package treesPackage;

public class Prob10DoubleTree {
  public static void doubleTree(Node root) {
    if (root == null) return;

    doubleTree(root.getLeftChild());
    doubleTree(root.getRightChild());

    Node oldLeftNode = root.getLeftChild();
    root.setLeftChild(new Node(root.getData()));
    root.getLeftChild().setLeftChild(oldLeftNode);
  }

  public static void printInorder(Node root) {
    if (root == null) return;
    printInorder(root.getLeftChild());
    System.out.print(root.getData() + " ");
    printInorder(root.getRightChild());
  }

  public static void main(String[] args) {
        /*
         2
        / \
       1   3
        */
    Node node1 = new Node(2);
    Node node2 = new Node(1);
    Node node3 = new Node(3);

    node1.setLeftChild(node2);
    node1.setRightChild(node3);

    System.out.println("Initially, the tree printed inorder is ");
    printInorder(node1);
    System.out.println();

    doubleTree(node1);
    System.out.println("\nAfter calling doubleTree(root), the tree becomes:");
    printInorder(node1);
    System.out.println();
  }
}