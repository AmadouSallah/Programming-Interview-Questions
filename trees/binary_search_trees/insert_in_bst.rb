require_relative 'implement_binary_search_tree'

# write a method to insert a node into a binary search tree

def insert_in_bst(root, data)
  if !root
    root = Node.new(data)
  elsif data < root.value
    root.left_child = insert_in_bst(root.left_child, data)
  else
    root.right_child = insert_in_bst(root.right_child, data)
  end
  root
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

p insert_in_bst(root, 0) #will put 0 as the left child of 1
