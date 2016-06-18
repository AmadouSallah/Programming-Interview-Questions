/*
From http://cslibrary.stanford.edu/110/BinaryTrees.pdf

hasPathSum()

We'll define a "root-to-leaf path" to be a sequence of nodes in a tree
starting with the root node and proceeding downward to a leaf
(a node with no children). We'll say that an empty tree contains no
root-to-leaf paths. So for example, the following tree has exactly
four root-to-leaf paths:
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
Root-to-leaf paths:
 path 1: 5 4 11 7
 path 2: 5 4 11 2
 path 3: 5 8 13
 path 4: 5 8 4 1

For this problem, we will be concerned with the sum of the values of such a
path -- for example, the sum of the values on the 5-4-11-7 path is 5 + 4 + 11 + 7 = 27.

Given a binary tree and a sum, return true if the tree has a root-to-leaf path
such that adding up all the values along the path equals the given sum.
Return false if no such path can be found.
*/

package treesPackage;

public class Prob7HasPathSum {

  public static boolean hasPathSum(Node root, int sum) {

    if (root == null)
      return (sum == 0);

    int newSum = sum - root.getData();
    return hasPathSum(root.getLeftChild(), newSum) || hasPathSum(root.getRightChild(), newSum);
  }

  public static void main(String[] args) {
    /*
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

    */
    Node node1 = new Node(5);
    Node node2 = new Node(4);
    Node node3 = new Node(8);
    Node node4 = new Node(11);
    Node node5 = new Node(13);
    Node node6 = new Node(4);
    Node node7 = new Node(7);
    Node node8 = new Node(2);
    Node node9 = new Node(1);

    node1.setLeftChild(node2);
    node1.setRightChild(node3);

    node2.setLeftChild(node4);

    node3.setLeftChild(node5);
    node3.setRightChild(node6);

    node4.setLeftChild(node7);
    node4.setRightChild(node8);

    node6.setRightChild(node9);

    System.out.println("hasPathSum(node1, 27) = " + hasPathSum(node1, 27));
    System.out.println("hasPathSum(node1, 22) = " + hasPathSum(node1, 22));
    System.out.println("hasPathSum(node1, 26) = " + hasPathSum(node1, 26));
    System.out.println("hasPathSum(node1, 18) = " + hasPathSum(node1, 18));
    System.out.println("hasPathSum(node9, 1) = " + hasPathSum(node9, 1));
    System.out.println("hasPathSum(node1, 0) = " + hasPathSum(node1, 0));
  }
}
