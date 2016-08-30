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