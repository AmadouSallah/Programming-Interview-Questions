/*
 printTree()

Given a binary search tree (aka an "ordered binary tree"), iterate over the nodes
to print them out in increasing order. So the tree...
       4
     /   \
    2     5
  /   \
 1     3
Produces the output "1 2 3 4 5". This is known as an "inorder" traversal of the tree.
Hint: For each node, the strategy is: recur left, print the node data, recur right.
*/

package treesPackage;

public class Prob5PrintInorder {
  public static void printInorder(Node root) {

    if (root == null) return;

    printInorder(root.getLeftChild());
    System.out.print(root.getData() + " ");
    printInorder(root.getRightChild());

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

    printInorder(node1);
    System.out.println();

    printInorder(node2);
    System.out.println();

    printInorder(node3);
    System.out.println();
  }
}