/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

Leetcode Problem 105. Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note: You may assume that duplicates do not exist in the tree.

For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

*/
import java.util.Map;
import java.util.HashMap;

public class BuildTreeFromPreorderAndInorder {

  public static class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    return traverse(preorder, inorder, 0, 0, inorder.length - 1);
  }

  public static TreeNode traverse(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
    if (preStart >= preorder.length || inStart > inEnd) return null;

    int rootVal = preorder[preStart], i = 0;
    TreeNode root = new TreeNode(rootVal);

    while (i < inorder.length) {
      if (inorder[i] == rootVal) break;
      i++;
    }

    root.left = traverse(preorder, inorder, preStart+1, inStart, i-1);
    root.right = traverse(preorder, inorder, preStart+1+i-inStart, i+1, inEnd);

    return root;
  }

  public static TreeNode buildTree2(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return traverse2(preorder, inorder, map, 0, 0, inorder.length - 1);
  }

  public static TreeNode traverse2(int[] preorder, int[] inorder, Map<Integer, Integer> map, int preStart, int inStart, int inEnd) {
    if (preStart >= preorder.length || inStart > inEnd) return null;

    int rootVal = preorder[preStart];
    int i = map.get(rootVal);
    TreeNode root = new TreeNode(rootVal);

    root.left = traverse2(preorder, inorder, map, preStart+1, inStart, i-1);
    root.right = traverse2(preorder, inorder, map, preStart+1+i-inStart, i+1, inEnd);

    return root;
  }

  public static void printInorder(TreeNode root) {
    if (root == null) return;
    printInorder(root.left);
    System.out.print(root.val + " ");
    printInorder(root.right);
  }

  public static void main(String[] args) {
    int[] preorder = new int[] {3,9,20,15,7};
    int[] inorder = new int[] {9,3,15,20,7};

    TreeNode root = buildTree(preorder, inorder);
    System.out.println("Given preorder = [3,9,20,15,7] and inorder = [9,3,15,20,7], the inorder of the built tree is:");

    printInorder(root);
    System.out.println("\n\nSolution 2: Using a hashmap:");

    TreeNode root2 = buildTree2(preorder, inorder);
    System.out.println("Given preorder = [3,9,20,15,7] and inorder = [9,3,15,20,7], the inorder of the built tree is:");

    printInorder(root2);
    System.out.println();
  }
}
