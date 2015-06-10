require_relative 'binary_trees'
require_relative './../stacks_and_queues/queue/implement_queue'

# Problem: Given a binary tree, print out the tree in level order (ie, from left to right, level by level). Output a newline after the end of each level
# For example, for the following binary tree,

#      1
#    /    \
#   2      3
#  / \    / \
# 4   5  6   7

# the output will be:
# 1
# 2 3
# 4 5 6 7

def print_level_order(root)
  return if !root
  queue = Queue.new()
  queue.enqueue(root)
  total_nodes_in_current_level = 1
  total_nodes_in_next_level = 0

  while (!queue.is_empty?) # as long as the queue is not empty
    current_node = queue.dequeue

    # if the current_node is not nil, we print its value and decrement total_nodes_in_current_level by 1. We then add its children (if any) to the queue and increment total_nodes_in_next_level by 2.
    if current_node
      print current_node.value, " "
      total_nodes_in_current_level -= 1

      queue.enqueue(current_node.left_child) if current_node.left_child
      queue.enqueue(current_node.right_child) if current_node.right_child
      total_nodes_in_next_level += 2
    end

    if total_nodes_in_current_level == 0 # this means we finished printing the node values in the current node
      print "\n"
      # swap total_nodes_in_current_level and total_nodes_in_next_level
      total_nodes_in_current_level = total_nodes_in_next_level
      total_nodes_in_next_level = total_nodes_in_current_level
    end
  end
  print "\n"
end

# TEST DRIVE
binary_tree = Binary_Tree.new()
root = Node.new(1)
a = Node.new(2)
b = Node.new(3)
d = Node.new(4)
e = Node.new(5)
f = Node.new(6)
g = Node.new(7)

binary_tree.root = root

binary_tree.root.left_child = a
binary_tree.root.right_child = b

a.left_child = d
a.right_child = e

b.left_child = f
b.right_child = g

print_level_order(root)
