require_relative 'binary_trees'

# Problem: Write a program that takes a binary tree root node and returns the deepest node

def deepest_node(root)

end

# TEST DRIVE
#      1
#    /    \
#   2      3
#  / \    / \
# 4   5  6   7
#       /
#      8

h = Node.new(8)
g = Node.new(7)
f = Node.new(6, g)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f, g)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a

p deepest_node(root)