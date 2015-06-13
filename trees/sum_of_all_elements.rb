require_relative 'binary_trees'

# Problem: Give an algorithm for finding the sum of all elements in binary tree

# SOLUTION 1: DFS
def sum_of_all_elements_DFS(root)
  return 0 if !root
  return root.value + sum_of_all_elements_DFS(root.left_child) + sum_of_all_elements_DFS(root.right_child)
end

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

p sum_of_all_elements_DFS(root) == 29
p sum_of_all_elements_DFS(h) == 8
p sum_of_all_elements_DFS(f) == 14
p sum_of_all_elements_DFS(nil) == 0