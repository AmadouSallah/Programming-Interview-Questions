/*
Leetcode Problem 98: Validate Binary Search Tree
https://leetcode.com/problems/validate-binary-search-tree/description/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input:
    2
   / \
  1   3
Output: true

Example 2:
    5
   / \
  1   4
     / \
    3   6
Output: false

Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.

*/

/*
To solve this problem, we can compute the inorder traversal list and
store it in a list, result. We then check to see if result is sorted,
i.e. if each element in result is smaller than the next element. This
will take extra O(n) space

We can actually avoid using the extra space to store all the elements
of inorder traversal. We only need to keep track of the last added
inorder element to check if the tree is BST or not (O(1) space)
The last added inorder element should be larger than the previous
minimum value, which is the previous element before it.
We initially set the previous minimum value to be the smallest integer value
*/

import java.util.Stack;

public class IsValidBST {

  public static class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
      this.val = val;
    }
  }

  public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack();
    TreeNode current = root;
    double prevMin = -Double.MAX_VALUE;
    // the smallest possible actual number one can represent with a double
    // Integer.MIN_VALUE doesn't work;

    while(!stack.isEmpty() || current != null) {

      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      current = stack.pop();

      // if the next value (current.val) is smaller than the previous
      // one (prevMin), then we don't have a BST
      if (current.val <= prevMin) return false;

      prevMin = current.val; // prevMin becomes the current element
      current = current.right;
    }
    return true;
  }
  
}
