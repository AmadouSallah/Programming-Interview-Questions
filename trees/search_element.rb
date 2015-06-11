require_relative 'binary_trees'
require_relative './../stacks_and_queues/queue/implement_queue'

# Problem: Write a program to search for an element in a binary tree.
# It should return 1 if the element is present in the binary tree, and -1 otherwise.

# SOLUTION 1: DFS (recursion)
def search_element_DFS(root, key)
  return 0 if !root
  return 1 if root.value == key

  left_result = search_element_DFS(root.left_child, key) #if root.left_child

  if left_result == 1 # key found on left side
    return left_result
  else # search on right side
    return search_element_DFS(root.right_child, key) if root.right_child
  end
  -1 # key not found in binary tree
end


# SOLUTION 2: BFS
def search_element_BFS(root, key)
  return -1 if !root
  return 1 if root.value == key

  queue = Queue.new()
  queue.enqueue(root)

  while !queue.is_empty?
    current_node = queue.dequeue
    return 1 if current_node.value == key

    queue.enqueue(current_node.left_child) if current_node.left_child
    queue.enqueue(current_node.right_child) if current_node.right_child
  end
  -1
end

# TEST DRIVE
#      1
#    /    \
#   2      3
#  / \    / \
# 4   5  6   7

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

puts "Testing method with Depth First Search"
p search_element_DFS(root, 7) == 1
p search_element_DFS(root, 4) == 1
p search_element_DFS(root, 0) == -1
p search_element_DFS(root, -5) == -1

puts "Testing method with Breath First Search"
p search_element_BFS(root, 7) == 1
p search_element_BFS(root, 4) == 1
p search_element_BFS(root, 0) == -1
p search_element_BFS(root, -5) == -1