/*
From: http://cslibrary.stanford.edu/110/BinaryTrees.pdf

doubleTree()
For each node in a binary search tree, create a new duplicate node,
and insert the duplicate as the left child of the original node.
The resulting tree should still be a binary search tree.

 So the tree...
     2
    / \
   1   3
 is changed to...
          2
         / \
        2   3
       /   /
      1   3
    /
   1

*/