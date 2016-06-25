/*
http://cslibrary.stanford.edu/110/BinaryTrees.pdf
http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

A binary search tree (BST) is a node based binary tree data structure which has the following properties.
• The left subtree of a node contains only nodes with keys less than the node’s key.
• The right subtree of a node contains only nodes with keys greater than the node’s key.
• Both the left and right subtrees must also be binary search trees.

From the above properties it naturally follows that:
• Each node (item in the tree) has a distinct key.

Write a function, isBST(), that returns true if a tree is a binary search tree and false otherwise.

Version 1:
Suppose you have helper functions minValue() and maxValue() that return the
min or max int value from a non-empty tree. Use the helper functions, and don't
forget to check every node in the tree. It's ok if your solution is not very efficient.

Version 2:
Version 1 above runs slowly since it traverses over some parts of the tree many times.
A better solution looks at each node only once. The trick is to write a utility helper
function isBSTRecur(struct node* node, int min, int max) that traverses down the tree
keeping track of the narrowing min and max allowed values as it goes, looking at each node
only once. The initial values for min and max should be INT_MIN and INT_MAX -- they narrow from there.
*/