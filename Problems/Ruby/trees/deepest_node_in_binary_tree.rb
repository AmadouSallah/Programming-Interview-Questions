require_relative 'binary_trees'
require_relative './../stacks_and_queues/queue/implement_queue'

# Problem: Write a program that takes a binary tree root node and returns the deepest node

def deepest_node(root)
  return root if !root
  queue = Queue.new()
  node = Node.new()
  queue.enqueue(root)
  while !queue.is_empty?
    node = queue.dequeue

    queue.enqueue(node.left_child) if node.left_child
    queue.enqueue(node.right_child) if node.right_child
  end
  node
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

p deepest_node(root) # Should return the node with value 8 (h)