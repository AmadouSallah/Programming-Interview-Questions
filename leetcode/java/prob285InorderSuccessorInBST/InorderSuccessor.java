/*
Problem 285: Inorder Successor in BST

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.


        15
     /      \
    10       20
   /  \      / \
  8   12    17  25
 /    /     /     \
6    11    16     27

For the tree above, the inorder traversal is 6, 8, 10, 11, 12, 15, 16, 17, 20, 25, 27
So, inorder successor of 10 (node has a right child), is 11;
inorder successor of 12 (node has no right child) is 15
*/