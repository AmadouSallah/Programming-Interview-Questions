/*
Problem 285: Inorder Successor in BST

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.


        6
     /     \
    3       9
   / \      / \
  2   5    8  10
 /   /    /     \
1   4    7      11

For the tree above, the inorder traversal is 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
So, inorder successor of 3 (node has a right child), is 4;
inorder successor of 5 (node has no right child) is 6
*/

/*
  PSEUDOCODE

We need to consider 2 cases:

Case 1: The node (whose inorder successor we are looking for) has a non null right subtree:
In this case, we go to the right subtree of the node, and return the node with the minimum value.

Case 2: The node (whose inorder successor we are looking for) has no right child:
In this case, we go to the nearest ancestor for which the given node would be in left subtree.
That is, from the node (whose inorder successor we are looking for), we travel up until
we see a node which is a left child of it's parent.

Detailed explanation below from:
https://www.quora.com/How-can-you-find-successors-and-predecessors-in-a-binary-search-tree-in-order

Finding the successor node of a given node:

There are two cases here:

1. The node has a right subtree.
If the given node has a right subtree then by the BST property the next larger key
must be in the right subtree. Since all keys in a right subtree are larger than the key
of the given node, the successor must be the smallest of all those keys in the right subtree.

2. The node does not have a right subtree.
In this case we will have to look up the tree since that's the only place we might find
the next larger key. There is no point looking at the left subtree as all keys in the
left subtree are guaranteed to be smaller than the key in the given tree.

When we look up from the given node, there can be two cases:
a) First, the current node is the left child of its parent. In this case the parent is the
successor node. This is because the parent always comes next in inorder traversal if you are
done with left subtree (rooted at the current node).

b) Second, the current node is the right child of the parent. This is an interesting case.
In this case, as you keep going up the ancestor chain, you encounter smaller values if you are
going left, but larger values if you are going right. The successor node will be the first node up
the ancestor chain that you encounter on the right chain.
*/


public class InorderSuccessor {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode result = null;
    while (root != null) {
      if (root.val > p.val) { // root is a possible successor, so we store it to result and move left
        // to see if there is any more node whose value is greater than that of p
        result = root;
        root = root.left;
      } else { // root.val <= p.val therefore, neither root, nor any node to its left, can be a successor.
        // So we move to the right
          root = root.right;
      }
    }
    return result;
  }

  /*
  // Similarly, for predecessor, we do:

  public TreeNode inorderPredeccessor(TreeNode root, TreeNode p) {
    TreeNode result = null;
    while (root != null) {
      if (root.val < p.val) {
        result = root;
        root = root.right;
      } else {
        root = root.left;
      }

    }
  }
  */

  /*
  // The solution below doesn't work for a tree with only 1 node; will revisit later

  // Resources: https://www.youtube.com/watch?v=5cPbNCrdotA
  // O(h), where h is height of tree => O(log n)
  public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

    if (root == null) return root;

    TreeNode current = p;

    // Case 1: Node p has a right subtree
    if (current.right != null)
      return findMin(current.right);

    // Case 2: Node p has no right subtree
    else { // current.right == null
      TreeNode successor = null;
      TreeNode ancestor = root;

      while (ancestor != current) {
        if (current.val < ancestor.val) {
          successor = ancestor; // so far, this is the deepest node for which current is in left
          ancestor = ancestor.left;
        } else {
          ancestor = ancestor.right;
        }
      }
      return ancestor;
    }

  }

  public static TreeNode findMin(TreeNode root) {
    if (root == null) return null;
    while (root.left != null)
      root = root.left;
    return root;
  }

  */
}