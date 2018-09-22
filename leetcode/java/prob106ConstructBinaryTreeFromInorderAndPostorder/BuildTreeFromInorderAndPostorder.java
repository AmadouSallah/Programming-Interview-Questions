/*
Leetcode Problem 106. Construct Binary Tree from Inorder and Postorder Traversal
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
*/

import java.util.Map;
import java.util.HashMap;

public class BuildTreeFromInorderAndPostorder {
  public static class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return traverse(inorder, postorder, map, 0, 0, inorder.length - 1, postorder.length-1);
  }

  public static TreeNode traverse(int[] inorder, int[] postorder, Map<Integer, Integer> map, int inStart, int postStart, int inEnd, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) return null;

    int rootVal = postorder[postEnd];
    int i = map.get(rootVal);
    int leftLen = i - inStart; // the length of the left subtree
    TreeNode root = new TreeNode(rootVal);

    root.left = traverse(inorder, postorder, map, inStart, postStart, i-1, postStart+leftLen-1);
    root.right = traverse(inorder, postorder, map, i+1, postStart+leftLen, inEnd, postEnd-1);

    return root;
  }


  public static void printInorder(TreeNode root) {
    if (root == null) return;
    printInorder(root.left);
    System.out.print(root.val + " ");
    printInorder(root.right);
  }

  public static void main(String[] args) {
    int[] inorder = new int[] {9,3,15,20,7};
    int[] postorder = new int[] {9,15,7,20,3};

    TreeNode root = buildTree(inorder, postorder);
    System.out.println("Given inorder = [9,3,15,20,7] and postorder = [9,15,7,20,3], the inorder of the built tree is:");

    printInorder(root);
    System.out.println();

  }
}

// Resources: https://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal
