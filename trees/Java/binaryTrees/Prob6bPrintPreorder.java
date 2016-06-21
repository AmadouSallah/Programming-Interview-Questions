/*
printPreorder()

Given a binary tree, print out the nodes of the tree in a "postorder" traversal
So the tree...

       4
     /   \
    2     5
  /   \
 1     3
Produces the output "4 2 1 3 5". The description is complex, but the code is simple.
*/

package treesPackage;

public class Prob6bPrintPreorder {
  public static void printPreorder(Node root) {

    if (root == null) return;

    System.out.print(root.getData() + " ");
    printPreorder(root.getLeftChild());
    printPreorder(root.getRightChild());

  }

  public static void main(String[] args) {

    /*

       4
     /   \
    2     5
  /   \
 1     3

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

    printPreorder(node1);
    System.out.println();

    printPreorder(node2);
    System.out.println();

    printPreorder(node3);
    System.out.println();
  }
}