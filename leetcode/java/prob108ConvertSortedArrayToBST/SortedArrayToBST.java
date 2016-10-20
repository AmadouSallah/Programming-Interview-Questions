/*
Problem 108: Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/


public class SortedArrayToBST {

  public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {val = x;}
  }

  public TreeNode sortedArrayToBST(int[] nums) {

    if (nums == null || nums.length == 0) return null;

    return sortedArrayToBST(nums, 0, nums.length-1);
  }

  public TreeNode sortedArrayToBST(int[] nums, int left, int right) {

    if (left > right) return null;

    int mid = left + (right - left) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = sortedArrayToBST(nums, left, mid - 1);
    node.right = sortedArrayToBST(nums, mid + 1, right);

    return node;
  }
}