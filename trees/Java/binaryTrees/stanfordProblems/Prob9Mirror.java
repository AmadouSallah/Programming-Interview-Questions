/*
Write a Function to Convert a Binary Tree into its Mirror Tree

Definition: Mirror of a Binary Tree T is another Binary Tree M(T)
with left and right children of all non-leaf nodes interchanged.

Example: the tree below
     4
    / \
   2   5
  / \
 1   3
is changed to
     4
    / \
   5   2
  / \
 3   1
*/

package treesPackage;

public class Prob9Mirror {

  public static void mirror(Node root) {
    if (root == null) {
      return;
    } else {
      mirror(root.getLeftChild());
      mirror(root.getRightChild());

      //swap the 2 children
      Node temp = root.getLeftChild();
      root.setLeftChild(root.getRightChild());
      root.setRightChild(temp);
    }
  }

  public static void printInorder(Node root) {
    if (root == null) return;
    printInorder(root.getLeftChild());
    System.out.print(root.getData() + " ");
    printInorder(root.getRightChild());
  }

  public static void main(String[] args) {
    /*
         4
        / \
       2   5
      / \
     1   3
    */
    Node node1 = new Node(4);
    Node node2 = new Node(2);
    Node node3 = new Node(5);
    Node node4 = new Node(1);
    Node node5 = new Node(3);

    node1.setLeftChild(node2);
    node1.setRightChild(node3);
    node2.setLeftChild(node4);
    node2.setRightChild(node5);

    // System.out.print("Initially, the tree printed inorder is ");
    // printInorder(node1);
    // System.out.println();
    // System.out.print("\nAfter calling the mirror method on the root, the tree becomes: ");
    // printInorder(node1);
    // System.out.println();
  }
}