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

/*
ITERATIVE SOLUTION

Resources:
http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/BST-delete.html
http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/BST-delete2.html

        PSEUDOCODE:
We use the Hibbard deletion algorithm:

We initialize currentNode and parentNode to the input root node, and we initialize a boolean isLeftChild to false;
isLeftChild will be set to true if the deletion node is a left child of its parent, and false otherwise.

We first find the node to be deleted, i.e. the node whose value is key
If such node is not found, we return null since there is nothing to be deleted in such a case
But if we do find this deletion node, we call it deletionNode, and its parent deletionNodeParent.

We then use Hibbard algorithm:

There are 3 possibilities, depending on wheather deletionNode is a leaf node, or if it has only 1 subtree, or 2 subtrees.

Case 1: The deletion node has no subtree, i.e. it is a leaf node
  a) If the deletion node is the root node, we just return null because when we delete it, there is nothing left in the tree.
  b) If the deletion node is a left child of its parent node, we remove it by seting the left child of parent node to null;
  c) Similarly, if the deletion node is a right child of its parent node, we remove it by seting the right child of parent node to null;

Case 2: The deletion node has only 1 child
  a) The deletion node has only 1 left child (subtree)
    i) if the deletion node is the root node, we just set the root node to its left child
    ii) If the deletion node is a left child of its parent, we make the parent node's left child point to the left subtree of the
        deletion node (remember the deletion node has only a left subree).
    iii) Similarly, if the deletion node is a right child of its parent, we make the parent node's right child point to the
            left subtree of the deletion node (remember the deletion node has only a left subree).

  b) The deletion node has only 1 right child (subtree)
    i) if the deletion node is the root node, we just set the root node to its right child
    ii) If the deletion node is a left child of its parent, we make the parent node's left child point to the right subtree of the
        deletion node (remember the deletion node has only a right subree).
    iii) Similarly, if the deletion node is a right child of its parent, we make the parent node's right child point to the
            right subtree of the deletion node (remember the deletion node has only a left subree).

Case 3: The deletion node has 2 children
  a) We first find the successor node of the deletion node. The successor node is the smallest element to its right;
    So we go 1 step right, and then all the way left. The successor node cannot have a left child.
  b) Special Case: if the right node of the deletion node is its successor, i.e. the rigth subtree of the deletion node has no left branch
     In this case, we replace the value of the deletion node by that of its successor, and we make its right child
     point to the right child of its successor
  c) We remove the deletion node by:
      i) replacing deletion node's value by that of its successor
      ii) making the left child of the parent of the successor node point to the successor's right subtree.

*/

/*
// Iterative solution: O(log n) runtime and O(1) space complexities.
public TreeNode deleteNode(TreeNode root, int key) {

    TreeNode currentNode = root, parentNode = root;
    boolean isLeftChild = false; // will be set to true if the node to be deleted is a left child of its parent, and false otherwise

    // We first find the node to be deleted, that is the node whose value is equal to key
    while (currentNode != null && currentNode.val != key) {
        parentNode = currentNode;
        if (key < currentNode.val) {
            currrentNode = currentNode.left;
            isLeftChild = true;
        } else {
            currentNode = currentNode.right;
            isLeftChild = false;
        }
    }

    // if no node with a value of key is found, we return null since there is nothing to be deleted in such case
    if (currrentNode == null) return null;

    TreeNode deletionNode = currentNode, deletionNodeParent = parentNode;

    // We now use Hibbard's Algorithm

    // Case 1: The deletion node has no subtree, i.e. it is a leaf node
    if (deletionNode.left == null && deletionNode.right == null) {

        if (deletionNode == root) return null; // if deletionNode is the root node, we delete it by returning null

        // Now, if the deletion node is a left (respectively right) child of its parent node,
        // we just set the left (respectively right) child of parent node to null;
        if (isLeftChild) deletionNodeParent.left = null;
        else deletionNodeParent.right = null;
      }

      // Case 2: THE DELETION NODE HAS ONLY 1 CHILD (SUBTREE)

      // Case 2a: THE DELETION NODE HAS ONLY 1 LEFT SUBTREE
      else if (deletionNode.right == null) {

        // If the deletion node is the root node, we just set it to its left child
        if (deletionNode == root) root = root.left;

        // If the deletion node is a left child of its parent, we make the parent node's left child point to the left subtree
        // of the deletion node (remember the deletion node has only a left subree).
        else if (isLeftChild) {
          deletionNodeParent.left = deletionNode.left;
        } else { / Otherwise, we make the parent node's right child point to the left subtree of the deletion node
          deletionNodeParent.right = deletionNode.left;
        }
      }

      // Case 2b: THE DELETION NODE HAS ONLY 1 RIGHT SUBTREE
      else if (deletionNode.left == null) {

        // If the deletion node is the root node, we just set it to its right child
        if (deletionNode == root) root = root.right;

        // If the deletion node is a left child of its parent, we make the parent node's left child point to the right subtree
        // of the deletion node (remember the deletion node has only a right subree).
        else if (isLeftChild) {
          deletionNodeParent.left = deletionNode.right;
        } else { // Otherwise, we make the parent node's right child point to the right subtree of the deletion node
          deletionNodeParent.right = deletionNode.right;
        }
      }

      // Case 3: THE DELETION NODE HAS 2 CHILDREN

      else {

          // We first find the successor node of the deletion node. The successor node is the smallest element to its right;
          // So we go 1 step right, and then all the way left. The successor node cannot have a left child.
          TreeNode successorNode = deletionNode.right, successorParentNode = deletionNode;
          while (successorNode.left != null) {
            successorParentNode = successorNode;
            successorNode = successorNode.left;
          }

          // Special Case: the right node of the deletion node is its successor, i.e. the rigth subtree of deletion node
          // has no left branch
          if (successorNode == deletionNode.right) { // i.e deletionNode.right.left is null
            // we replace the value of deletion node by that of its successor, and make its right child
            // point to the right child of its successor 
            deletionNode.val = successorNode.val; // same as deletionNode.val =  deletionNode.right.val
            deletionNode.right = successorNode.right; // same as deletionNode.right =  deletionNode.right.right

          } else {
              // We remove the deletion node by first replacing its value by that of its successor, and then making
              // the left child of successorParentNode point to the successor's right subtree.
              deletionNode.val = successorNode.val; // replace deletion node's value by that of its successor
              successorParentNode.left = successorNode.right; // make the left child of successor's parent point to successor's right subtree.
          }

      }
      return root;
}
*/
