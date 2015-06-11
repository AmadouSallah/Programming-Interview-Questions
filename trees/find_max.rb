require_relative 'binary_trees'
require_relative './../stacks_and_queues/queue/implement_queue'

# Problem: Given the root of a binary tree, write a program to find the maximum element present in it.

# SOLUTION 1 Using DFS ( complexity: 0(n) time and 0(n) space)
def find_max_element_DFS(root)
  return if !root
  root_value = root.value
  left_max = root.value
  right_max = root.value

  left_max = find_max_element_DFS(root.left_child) if root.left_child
  right_max = find_max_element_DFS(root.right_child) if root.right_child

  maximum(root_value, maximum(left_max, right_max))
end

# SOLUTION 2: USING BFS (complexity: 0(n) time and 0(n) space)
def find_max_element_BFS(root)
  return if !root
  queue = Queue.new()
  max_element = root.value
  queue.enqueue(root)

  while (!queue.is_empty?)
    temp_node = queue.dequeue
    max_element = maximum(max_element, temp_node.value)

    queue.enqueue(temp_node.left_child) if temp_node.left_child
    queue.enqueue(temp_node.right_child) if temp_node.right_child

  end
  max_element
end

def maximum(a, b)
  a > b ? a : b
end

# TEST DRIVE
#      1
#    /    \
#   2      30
#  / \    / \
# 4   5  6   -7

binary_tree = Binary_Tree.new()
root = Node.new(1)
a = Node.new(2)
b = Node.new(30)
d = Node.new(4)
e = Node.new(5)
f = Node.new(6)
g = Node.new(-7)

binary_tree.root = root

binary_tree.root.left_child = a
binary_tree.root.right_child = b

a.left_child = d
a.right_child = e

b.left_child = f
b.right_child = g

p find_max_element_DFS(root)
p find_max_element_BFS(root)