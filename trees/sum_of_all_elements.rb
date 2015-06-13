require_relative 'binary_trees'
require_relative './../stacks_and_queues/queue/implement_queue'

# Problem: Give an algorithm for finding the sum of all elements in binary tree

# SOLUTION 1: DFS
def sum_of_all_elements_DFS(root)
  return 0 if !root
  return root.value + sum_of_all_elements_DFS(root.left_child) + sum_of_all_elements_DFS(root.right_child)
end

# SOLUTION 2: BFS
def sum_of_all_elements_BFS(root)
  return 0 if !root
  sum = 0
  queue = Queue.new()
  queue.enqueue(root)
  while !queue.is_empty?
    node = queue.dequeue
    sum += node.value

    queue.enqueue(node.left_child) if node.left_child
    queue.enqueue(node.right_child) if node.right_child
  end
  sum
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

puts "Using DFS method:"
p sum_of_all_elements_DFS(root) == 29
p sum_of_all_elements_DFS(h) == 8
p sum_of_all_elements_DFS(f) == 14
p sum_of_all_elements_DFS(nil) == 0

puts "Using BFS method:"
p sum_of_all_elements_BFS(root) == 29
p sum_of_all_elements_BFS(h) == 8
p sum_of_all_elements_BFS(f) == 14
p sum_of_all_elements_BFS(nil) == 0