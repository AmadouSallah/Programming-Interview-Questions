class Tree
  attr_accessor :root, :children
  def initialize(root)
    @root = root
    @children = []
  end

  def add_child(child_node)
    @children << child_node
  end
end

# tree = Tree.new(5)
# tree.add_child(3)
# tree.add_child(2)
# tree.add_child(8)

# p tree.root
# p tree.children

#   5
# / | \
# 3 2  8
