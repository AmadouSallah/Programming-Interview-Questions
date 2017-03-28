/*
Leetcode Problem 450: Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST.
Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
*/

public class DeleteNode {

  public static class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int x) {
      val = x;
    }
  }

  // Recursive Solution: O(h) runtime and O(h) space complexities, where h = height of tree = log(n); n = number of tree elements
  public TreeNode deleteNode(TreeNode root, int key) {

    if (root == null) return root;

    if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else { // key = root.val
      if (root.left == null) return root.right;
      else if (root.right == null) return root.left;
      else { // Both left and rigth children are non null; so we first find the successor node,
        // which is the node with the minimum value in the right subtree
        TreeNode successorNode = findMinNode(root.right);
        // We then replace the current node value with that of the successor node.
        root.val = successorNode.val;
        // Finally, we remove the successor node
        root.right = deleteNode(root.right, successorNode.val); // remove the successor node
      }
    }
    return root;
  }

  private TreeNode findMinNode(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
  
}
