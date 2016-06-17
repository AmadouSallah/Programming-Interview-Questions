/*
printPostorder()

Given a binary tree, print out the nodes of the tree according to a bottom-up
"postorder" traversal -- both subtrees of a node are printed out completely
before the node itself is printed, and each left subtree is printed before
the right subtree. So the tree...

       4
     /   \
    2     5
  /   \
 1     3
Produces the output "1 3 2 5 4". The description is complex, but the code is simple.
This is the sort of bottom-up traversal that would be used, for example, to evaluate
an expression tree where a node is an operation like '+' and its subtrees are,
recursively, the two subexpressions for the '+'.
*/