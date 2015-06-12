require_relative 'binary_trees'

# Problem: Geven the roots of 2 binary trees, write a program to determine
# if the 2 trees are structurally identical

def structurally_identical_binary_trees?(root1, root2)
  return true if (!root1 && !root2)
  if (!root1 && root2) || (root1 && !root2)
    return false
  elsif root1.value != root2.value
    return false
  else
    left = structurally_identical_binary_trees?(root1.left_child, root2.left_child)
    right = structurally_identical_binary_trees?(root1.right_child, root2.right_child)
    return left && right
  end
  # false
end

# TEST DRIVE
#      1
#    /    \
#   2      3
#  / \    / \
# 4   5  6   7
#       /
#      8

h1 = Node.new(8)
g1 = Node.new(7)
f1 = Node.new(6, h1)
e1 = Node.new(5)
d1 = Node.new(4)
c1 = Node.new(3, f1, g1)
b1 = Node.new(2, d1, e1)
a1 = Node.new(1, b1, c1)

root1 = a1

h2 = Node.new(8)
g2 = Node.new(7)
f2 = Node.new(6, h2)
e2 = Node.new(5)
d2 = Node.new(4)
c2 = Node.new(3, f2, g2)
b2 = Node.new(2, d2, e2)
a2 = Node.new(1, b2, c2)

root2 = a2

empty = Node.new()
p structurally_identical_binary_trees?(a1, a1) == true
p structurally_identical_binary_trees?(h1, h1) == true
p structurally_identical_binary_trees?(root1, root2) == true
p structurally_identical_binary_trees?(a1, b1) == false
p structurally_identical_binary_trees?(empty, empty) == true
p structurally_identical_binary_trees?(empty, a2) == false
p structurally_identical_binary_trees?(a1, empty) == false