/*
maxDepth()
Given a binary tree, compute its "maxDepth" -- the number of nodes along the
longest path from the root node down to the farthest leaf node.
The maxDepth of the empty tree is 0, the maxDepth of the tree below is 3.

  2
 / \
1   10
    /
   5

*/

package stanfordPackage;

public class Prob3MaxDepth {

  public static int maxDepth(Node root) {
    if (root == null) return 0;

    int left = maxDepth(root.getLeftChild());
    int right = maxDepth(root.getRightChild());

    return 1 + Math.max(left, right);
  }

  public static void main(String[] args) {
    Node node1 = new Node(2);
    Node node2 = new Node(1);
    Node node3 = new Node(10);
    Node node4 = new Node(5);

    node1.setLeftChild(node2);
    node1.setRightChild(node3);
    node3.setLeftChild(node4);

    System.out.println(maxDepth(null));
    System.out.println(maxDepth(node4));
    System.out.println(maxDepth(node1));
  }
}