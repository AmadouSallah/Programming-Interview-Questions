/*
Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path
such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

*/

public class HasPathSum {

  private static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    } else if (root.left == null && root.right == null) {
      return (root.val == sum);
    } else {
      int newSum = sum - root.val;
      return ( hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum) );
    }
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
    TreeNode node1 = new TreeNode(5);
    TreeNode node2 = new TreeNode(4);
    TreeNode node3 = new TreeNode(8);
    TreeNode node4 = new TreeNode(11);
    TreeNode node5 = new TreeNode(13);
    TreeNode node6 = new TreeNode(4);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(2);
    TreeNode node9 = new TreeNode(1);

    node1.left = node2;
    node1.right = node3;

    node2.left = node4;

    node3.left = node5;
    node3.right = node6;

    node4.left = node7;
    node4.right = node8;

    node6.right = node9;

    System.out.println("hasPathSum(null, 0) = " + hasPathSum(null, 0));
    System.out.println("hasPathSum(null, 1) = " + hasPathSum(null, 1));
    System.out.println("hasPathSum(node1, 27) = " + hasPathSum(node1, 27));
    System.out.println("hasPathSum(node1, 22) = " + hasPathSum(node1, 22));
    System.out.println("hasPathSum(node1, 26) = " + hasPathSum(node1, 26));
    System.out.println("hasPathSum(node1, 18) = " + hasPathSum(node1, 18));
    System.out.println("hasPathSum(node1, 0) = " + hasPathSum(node1, 0));
    System.out.println("hasPathSum(node9, 1) = " + hasPathSum(node9, 1));
    System.out.println("hasPathSum(node9, 2) = " + hasPathSum(node9, 2));
  }
}