require_relative 'binary_trees'
require_relative './../stacks_and_queues/queue/implement_queue'

# Problem: Write a program that inserts an element into a binary tree

# SOLUTION
# Since the tree is a binary tree, we can insert the key wherever we find a node whose left child or right child is nil.
# To do this, we will use Breath First Search (level order traversal)

def insert_into_binary_tree(root, key)
  new_node = Node.new(key)
  return new_node if !root

  queue = Queue.new()
  queue.enqueue(root)
  while !queue.is_empty?
    temporal_node = queue.dequeue

    if temporal_node.left_child
      queue.enqueue(temporal_node.left_child)
    else
      temporal_node.left_child = new_node
      return
    end

    if temporal_node.right_child
      queue.enqueue(temporal_node.right_child)
    else
      temporal_node.right_child = new_node
      return
    end
  end
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

binary_tree = Binary_Tree.new(root)

print "Using level order traversal, the binary tree is initially: "
binary_tree.level_order(root)

insert_into_binary_tree(root, 8)

print "\n\nAfter inserting a node of value 8, the binary tree is now (using level order):"
binary_tree.level_order(root)
puts