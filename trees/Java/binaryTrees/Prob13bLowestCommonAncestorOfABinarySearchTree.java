/*
From https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Leetcode Problem 235: Lowest Common Ancestor of a Binary Search Tree
Given a binary search tree (BST), find the lowest common ancestor (LCA)
of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor
is defined between two nodes v and w as the lowest node in T that has both
v and w as descendants (where we allow a node to be a descendant of itself).”
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
Another example is LCA of nodes 2 and 4 is 2, since a node can be a
descendant of itself according to the LCA definition.
*/

package treesPackage;

public class Prob13bLowestCommonAncestorOfABinarySearchTree {

  public Node lowestCommonAncestorOfABinarySearchTree(Node root, Node p, Node q) {

   if (root == null)
      return root;


   if ( ((p.getData() < root.getData()) && (root.getData() < q.getData())) || ((q.getData() < root.getData()) && (root.getData() < p.getData())) )
      return root;

   else if ( (p.getData() < root.getData()) && (q.getData() < root.getData()) )
      return lowestCommonAncestorOfABinarySearchTree(root.getLeftChild(), p, q);

   else if ( (p.getData() > root.getData()) && (q.getData() > root.getData()) )
      return lowestCommonAncestorOfABinarySearchTree(root.getRightChild(), p, q);

   else
      return root;

  }
}