/*
maxValue()
Given a non-empty binary search tree (an ordered binary tree), return the maximum
data value found in that tree.
Note that it is not necessary to search the entire tree.
*/

package treesPackage;

public class Prob4bMaxValue {

  public static int maxValue(Node root) {
    Node node = root;
    while (node.getRightChild() != null) {
      node = node.getRightChild();
    }
    return node.getData();
  }

  public static void main(String[] args) {

    /*
        2
       / \
      1   10
          /
         5
    */
    Node node1 = new Node(2);
    Node node2 = new Node(1);
    Node node3 = new Node(10);
    Node node4 = new Node(5);

    node1.setLeftChild(node2);
    node1.setRightChild(node3);
    node3.setLeftChild(node4);

    System.out.println(maxValue(node1)); // should print 10
    System.out.println(maxValue(node2)); // should print 1
    System.out.println(maxValue(node3)); // should print 10
  }
}