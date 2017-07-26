/*
From https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Leetcode Problem 236: Lowest Common Ancestor of a Binary

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
between two nodes v and w as the lowest node in T that has both v and w as descendants
(where we allow a node to be a descendant of itself).”
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of
itself according to the LCA definition.
*/

package treesPackage;

public class Prob13aLowestCommonAncestorOfABinaryTree {
  public static Node lowestCommonAncestor(Node root, Node p, Node q) {

    if (root == null || root == p || root == q)
      return root;


    Node left = lowestCommonAncestor(root.getLeftChild(), p, q);
    Node right = lowestCommonAncestor(root.getRightChild(), p, q);

    if (left != null && right != null)
      return root;

    return (left == null) ? right : left;

  }
}