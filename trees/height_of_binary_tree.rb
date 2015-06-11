require_relative 'binary_trees'

# Problem: Write a program to find the height (depth) of a binary tree

def height_of_binary_tree(root)
  return 0 if !root
  heigth, left_height, right_height = 0, 0, 0
  left_height = height_of_binary_tree(root.left_child) if root.left_child
  right_height = height_of_binary_tree(root.right_child) if root.right_child

  (left_height > right_height) ? (1 + left_height) : (1 + right_height)
end

# TEST DRIVE
#      1
#    /    \
#   2      3
#  / \    / \
# 4   5  6   7

h = Node.new(8)
g = Node.new(7)
f = Node.new(6)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f, g)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a
p height_of_binary_tree(root) == 3
p height_of_binary_tree(d) == 1
p height_of_binary_tree(b) == 2