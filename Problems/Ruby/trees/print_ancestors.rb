require_relative 'binary_trees'

# Problem: Given a Binary Tree and a key node, write a function that prints all the ancestors of the key in the given binary tree.
# Example, for the binary tree below and key node 8, the ouput is: 6, 3, 1
#      1
#    /    \
#   2      3
#  / \    /
# 4   5  6
#       /
#      8

# SOLUTION
def print_ancestors(root, node)
  return false if !root
  return true if root.value == node.value

  if (print_ancestors(root.left_child, node) || print_ancestors(root.right_child, node))
    print root.value, " "
    return true
  end

  false
end

h = Node.new(8)
f = Node.new(6, h)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a

p print_ancestors(root, h) # 6, 3, 1
p print_ancestors(root, b) # 1