require_relative 'implement_binary_search_tree'

# Write code to find the minimum element in a binary search tree

# In a BST, the minimum element is the left most node which does not have a left child:

# Iterative Solution
def find_min_element_iterative(root)
  return nil if !root
  while root.left_child
    root = root.left_child
  end
  root
end

# Recursive Solution
def find_min_element_recursive(root)
  return nil if !root
  if !root.left_child
    return root
  else
    return find_min_element_recursive(root.left_child)
  end
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

p find_min_element_iterative(nil) == nil
p find_min_element_iterative(root) == d
p find_min_element_iterative(c) == f

p find_min_element_recursive(nil) == nil
p find_min_element_recursive(root) == d
p find_min_element_recursive(c) == f