require_relative './../stacks_and_queues/queue/implement_queue'
class Node
  attr_accessor :value, :left_child, :right_child
  def initialize(value = nil, left_child = nil, right_child = nil)
    @value = value
    @left_child = left_child
    @right_child = right_child
  end
end

#      1
#    /    \
#   2      3
#  / \    / \
# 4   5  6   7

class Binary_Tree
  attr_accessor :root
  def initialize(root = nil)
    @root = Node.new(root)
  end

  # I - DEPTH FIRST TRAVERSALS: preorder, inorder, and postorder

  # 1) preorder traversal: each node is processed before (pre) either of its sub-trees: 1 2 4 5 3 6 7
  def preorder(node)
    return if !node
    print node.value, " "
    preorder(node.left_child)
    preorder(node.right_child)
  end

  # 2) inorder traversal: traverse left child, visit the node, then traverse the right child: 4 2 5 1 6 3 7
  def inorder(node)
    return if !node
    inorder(node.left_child)
    print node.value, " "
    inorder(node.right_child)
  end

  # 3) postorder traversal: traverse left, traverse right, then visit node: 4 5 2 6 7 3 1
  def postorder(node)
    return if !node
    postorder(node.left_child)
    postorder(node.right_child)
    print node.value, " "
  end

  # II - BREADTH FIRST TRAVERSAL: level order: 1 2 3 4 5 6 7
  def level_order(node)
    return if !node # return if the node is nil
    queue = Queue.new() # create an empty queue
    queue.enqueue(node) # add the node to the queue
    while !queue.is_empty? # loop as long as the queue is not empty
      temporal_node = queue.dequeue # remove an element from the queue and save it as temporal_node
      print temporal_node.value, " " # print the value of temporal_node
      # add both the left and right nodes (if they are not nil) to the queue
      queue.enqueue(temporal_node.left_child) if temporal_node.left_child
      queue.enqueue(temporal_node.right_child) if temporal_node.right_child
    end
  end
end

# TEST DRIVE
# binary_tree = Binary_Tree.new()
# root = Node.new(1)
# a = Node.new(2)
# b = Node.new(3)
# d = Node.new(4)
# e = Node.new(5)
# f = Node.new(6)
# g = Node.new(7)

# binary_tree.root = root

# binary_tree.root.left_child = a
# binary_tree.root.right_child = b

# a.left_child = d
# a.right_child = e

# b.left_child = f
# b.right_child = g

# print "Results after running Preorder on the binary tree: "
# binary_tree.preorder(root)

# print "\n\nResults after running inorder on the binary tree: "
# binary_tree.inorder(root)

# print "\n\nResults after running postorder on the binary tree: "
# binary_tree.postorder(root)

# print "\n\nResults after running level order on the binary tree: "
# binary_tree.level_order(root)
# puts
