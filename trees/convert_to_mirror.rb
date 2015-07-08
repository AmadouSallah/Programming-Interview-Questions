require_relative 'binary_trees'

# Problem: Write a program to convert a Binary Tree into its Mirror Tree
# A mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
# Example:
#      1
#    /    \
#   2      3
#  / \    /
# 4   5  6
#       /
#      8

# becomes
#      1
#    /    \
#   3      2
#    \    / \
#     6  5  4
#       \
#         8
def convert_binary_tree_to_mirror(root)
  return if !root
  temp_node = Node.new()
  # recursively call the method on both left and right subtrees
  convert_binary_tree_to_mirror(root.left_child)
  convert_binary_tree_to_mirror(root.right_child)

  # swap the left and right subtrees
  temp_node = root.left_child
  root.left_child = root.right_child
  root.right_child = temp_node

  return root
end


# SOLUTION 2
def convert_binary_tree_to_mirror_2(root)
  return if !root

  # swap the left and right children of root
  temp = Node.new()
  temp = root.left_child
  root.left_child = root.right_child
  root.right_child = temp

  # recursive call on both the left and rigth children
  convert_binary_tree_to_mirror_2(root.left_child)
  convert_binary_tree_to_mirror_2(root.right_child)

  return root
end

# TEST DRIVE
h = Node.new(8)
f = Node.new(6, h)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a

mirror = convert_binary_tree_to_mirror(root)

p convert_binary_tree_to_mirror_2(mirror) == root