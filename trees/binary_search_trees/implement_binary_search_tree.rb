# Implement a Binary Search Tree

class Node
  attr_accessor :value, :left_child, :right_child
  def initialize(value = nil, left_child = nil, right_child = nil)
    @value = value
    @left_child = left_child
    @right_child = right_child
  end
end


class BinarySearchTree
  attr_accessor :root
  def initialize(root)
    @root = Node.new(root)
  end

  ### WILL ADD MORE LATER #######
end

# TEST DRIVE
#      4
#    /    \
#   2      6
#  / \    / \
# 1   3  5   7
# root = BinarySearchTree.new(4)

# d = Node.new(1)
# e = Node.new(3)
# f = Node.new(5)
# g = Node.new(7)

# b = Node.new(2, d, e)
# c = Node.new(6, f, g)

# a = Node.new(4, b, c)

# bst = BinarySearchTree.new(a)

