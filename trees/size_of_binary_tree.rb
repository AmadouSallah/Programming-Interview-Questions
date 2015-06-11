require_relative 'binary_trees'
require_relative './../stacks_and_queues/queue/implement_queue'

# Problem: Write a program to find the size of a binary tree

# SOLUTION 1: Depth First Search (DFS)
def size_of_binary_tree_DFS(root)
  return 0 if !root
  return 1 + size_of_binary_tree_DFS(root.left_child) + size_of_binary_tree_DFS(root.right_child)
end

# SOLUTION 2: Breath First Search (BFS)
def size_of_binary_tree_BFS(root)
  return 0 if !root

  count = 0
  queue = Queue.new()
  queue.enqueue(root)
  while !queue.is_empty?
    temporal_node = queue.dequeue
    count += 1
    queue.enqueue(temporal_node.left_child) if temporal_node.left_child
    queue.enqueue(temporal_node.right_child) if temporal_node.right_child
  end
  count
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

puts "Test Drive using the DFS solution"
p size_of_binary_tree_DFS(root) == 7
p size_of_binary_tree_DFS(a) == 3
p size_of_binary_tree_DFS(d) == 1

puts "\nTest Drive using the BFS (level order) solution"
p size_of_binary_tree_BFS(root) == 7
p size_of_binary_tree_BFS(a) == 3
p size_of_binary_tree_BFS(d) == 1