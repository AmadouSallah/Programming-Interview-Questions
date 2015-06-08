class Binary_tree
  attr_accessor :root, :left_child, :right_child
  def initialize(root = nil, left_child = nil, right_child = nil)
    @root = root
    @left_child = left_child
    @right_child = right_child
  end

  def add_child(child_node)
    (@left_child == nil) ? @left_child = child_node : @right_child = child_node
  end
end

# TEST DRIVE
# binary_tree = Binary_tree.new(2)
# puts "Initially, the binary tree has: root = #{binary_tree.root}, left_child = #{binary_tree.left_child}, right_child = #{binary_tree.right_child}"

# binary_tree.add_child(1)
# binary_tree.add_child(3)
# puts "\nAfter adding nodes 1 and 3 to the root, the binary tree has: root = #{binary_tree.root}, left_child = #{binary_tree.left_child}, right_child = #{binary_tree.right_child}"