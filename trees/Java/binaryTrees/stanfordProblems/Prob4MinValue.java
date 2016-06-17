/*
minValue()
Given a non-empty binary search tree (an ordered binary tree), return the minimum
data value found in that tree.
Note that it is not necessary to search the entire tree.
A maxValue() function is structurally very similar to this function.
This can be solved with recursion or with a simple while loop.
*/

package treesPackage;

public class Prob4MinValue {

  public static int minValue(Node root) {
    Node node = root;
    while (node.getLeftChild() != null) {
      node = node.getLeftChild();
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

    System.out.println(minValue(node1)); // should print 1
    System.out.println(minValue(node3)); // should print 5
    System.out.println(minValue(node4)); // should print 5
  }
}