require_relative 'binary_trees'
require_relative './../stacks_and_queues/queue/implement_queue'
require_relative './../stacks_and_queues/stacks/implement_stack'

# Problem: Write a program that takes a binary tree root and return a reversed level order traversal.
# Example, for the binary tree below, the output will be: 4567231
#      1
#    /    \
#   2      3
#  / \    / \
# 4   5  6   7

# SOLUTION
# To solve this problem, we will use both a stack and a queue. We will do a regular level order traversal with some changes:
# 1) When adding nodes to the queue, we first add the node's right child then its left child.
# 2) We then push the node value to the stack
# Once the queue is empty, we then print the contents of the stack 1 at a time by 'popping' them.

def level_order_reverse(root)
  return if ! root
  queue = Queue.new()
  stack = Stack.new()

  queue.enqueue(root)
  while !queue.is_empty?
    temporal_node = queue.dequeue
    stack.push(temporal_node.value)

    queue.enqueue(temporal_node.right_child) if temporal_node.right_child
    queue.enqueue(temporal_node.left_child) if temporal_node.left_child
  end

  while !stack.is_empty?
    print stack.pop(), " "
  end
  puts
end

# TEST DRIVE
g = Node.new(7)
f = Node.new(6)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f, g)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a
level_order_reverse(root) # Should return 4 5 6 7 2 3 1