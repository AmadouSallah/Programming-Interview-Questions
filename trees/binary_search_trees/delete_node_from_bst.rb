require_relative 'implement_binary_search_tree'
# Problem: Write a program to delete an element from a Binary Search Tree.

# See algorithm at https://en.wikipedia.org/wiki/Binary_search_tree#Deletion

# PSEUDOCODE
# We have 3 cases to consider for the node to be deleted: it has no children, has only 1 child, or both children
# Case 1: If the node to be deleted has no children, just remove the node from the tree
# case 2: If the node to be deleted has only 1 child, remove the node and replace it with its child
# case 3: If the node to be deleted has both left and right children, do the followings:
# i) Replace the key of the node with the largest element in the left subtree ( that is with the inorder predecessor node).
# The largest node cannot have a right child; it has atmost 1 child (left child).
# ii) Delete this largest element by replacing it with its child. (case 2)


def find_max(root)
  return nil if !root
  while root.right_child
    root = root.right_child
  end
  root
end

