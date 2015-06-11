require_relative 'binary_trees'
require_relative './../stacks_and_queues/queue/implement_queue'

# Problem: Write a program to find the size of a binary tree

# SOLUTION 1: Depth First Search (DFS)
def size_of_binary_tree_DFS(root)
  return 0 if !root
  return 1 + size_of_binary_tree_DFS(root.left_child) + size_of_binary_tree_DFS(root.right_child)
end

# TEST DRIVE
#      1
#    /    \
#   2      3
#  / \    / \
# 4   5  6   7

f = Node.new(7)
e = Node.new(6)
d = Node.new(5)
c = Node.new(4)
b = Node.new(3, e, f)
a = Node.new(2, c, d)
root = Node.new(1, a, b)

p size_of_binary_tree_DFS(root) == 7
p size_of_binary_tree_DFS(a) == 3
p size_of_binary_tree_DFS(d) == 1