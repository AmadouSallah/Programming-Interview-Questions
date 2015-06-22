require_relative 'implement_binary_search_tree'
# Write code to find the maximum element in a binary search tree

# In a BST, the maximum element is the right most node which does not have a right child

# Iterative solution
def find_max_element_iterative(root)
  return nil if !root
  return root if !root.right_child
  while root.right_child
    root = root.right_child
  end
  root
end

# Recursive solution
def find_max_element_recursive(root)
  return nil if !root
  return root if !root.right_child
  return find_max_element_recursive(root.right_child)
end

# TEST DRIVE
#      4
#    /    \
#   2      6
#  / \    / \
# 1   3  5   7

d = Node.new(1)
e = Node.new(3)
f = Node.new(5)
g = Node.new(7)

b = Node.new(2, d, e)
c = Node.new(6, f, g)

a = Node.new(4, b, c)

root = a

p find_max_element_iterative(nil) == nil
p find_max_element_iterative(root) == g
p find_max_element_iterative(b) == e

p find_max_element_recursive(nil) == nil
p find_max_element_recursive(root) == g
p find_max_element_recursive(b) == e