require_relative 'binary_trees'

# Problem: Given a binary tree, write a program to find the maximum width (also called diameter) of the tree.
# The width of a tree is the maximum of widths of all levels
# Example
#      1
#    /    \
#   2      3
#  / \    /
# 4   5  6
#       /
#      8

# For the binary tree above, width of level 1 = 1, width of level 2 = 2, width of level 3 = 3, and width of level 4 = 1.
# The program would therefore return 3 for the above tree

# SOLUTION
def maximum_binary_tree_width(root)
  # root = tree.root
  max = 0
  height = get_height(root)
  i = 1
  while i <= height
    level_max = level_width(root, i)
    max = (max > level_max) ? max : level_max
    i += 1
  end
  max
end

def get_height(root)
  return 0 if !root

  left_height, right_height = 0, 0
  left_height = get_height(root.left_child) if root.left_child
  right_height = get_height(root.right_child) if root.right_child

  (left_height > right_height) ? (1 + left_height) : (1 + right_height)
end

def level_width(root, level)
  return 0 if !root
  if level == 1
    return 1
  else
    return level_width(root.left_child, level-1) + level_width(root.right_child, level-1)
  end
end

# TEST DRIVE
#      1
#    /    \
#   2      3
#  / \    /
# 4   5  6
#       /
#      8

h = Node.new(8)
f = Node.new(6, h)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a


p maximum_binary_tree_width(root) == 3
p maximum_binary_tree_width(d) == 1
p maximum_binary_tree_width(c) == 1