/*
printPostorder()

Given a binary tree, print out the nodes of the tree according to a bottom-up
"postorder" traversal -- both subtrees of a node are printed out completely
before the node itself is printed, and each left subtree is printed before
the right subtree. So the tree...

       4
     /   \
    2     5
  /   \
 1     3
Produces the output "1 3 2 5 4". The description is complex, but the code is simple.
This is the sort of bottom-up traversal that would be used, for example, to evaluate
an expression tree where a node is an operation like '+' and its subtrees are,
recursively, the two subexpressions for the '+'.
*/

package treesPackage;

public class Prob6PrintPostorder {
  public static void printPostorder(Node root) {

    if (root == null) return;

    printPostorder(root.getLeftChild());
    printPostorder(root.getRightChild());
    System.out.print(root.getData() + " ");

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

    printPostorder(node1);
    System.out.println();

    printPostorder(node2);
    System.out.println();

    printPostorder(node3);
    System.out.println();
  }
}