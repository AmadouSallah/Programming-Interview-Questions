require_relative 'binary_trees'
require_relative './../stacks_and_queues/queue/implement_queue'

# Problem: Write a program to find the number of half nodes in a binary tree without using recursion
# Note: A half node is a node with only 1 child

def number_of_half_nodes_in_binary_tree(root)
  return 0 if !root
  count = 0
  queue = Queue.new()
  queue.enqueue(root)
  while(!queue.is_empty?)
    node = queue.dequeue

    count += 1 if (node.left_child && !node.right_child) || (!node.left_child && node.right_child)

    queue.enqueue(node.left_child) if node.left_child
    queue.enqueue(node.right_child) if node.right_child
  end
  count
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
f = Node.new(6, h)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f, g)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a

p number_of_half_nodes_in_binary_tree(root) == 1
p number_of_half_nodes_in_binary_tree(d) == 0
p number_of_half_nodes_in_binary_tree(b) == 0
p number_of_half_nodes_in_binary_tree(c) == 1


