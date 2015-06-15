require_relative 'binary_trees'
require_relative './../stacks_and_queues/stacks/implement_stack'
# Given the root of a binary tree, print out the tree in zig zag level order
# (ie, from left to right, then right to left for the next level and alternate between).
# Output a newline after the end of each level.

#      1
#    /    \
#   2      3
#  / \    / \
# 4   5  6   7
# Example, for the tree above, the zig zag level order output is:
# 1
# 3 2
# 4 5 6 7

def zigzag_traversal(root)
  return if !root
  left_to_right = 1 # keeps track of current level's order (it is 1 for left to right and 0 for right to left)
  current_level_stack = Stack.new()
  next_level_stack = Stack.new()

  current_level_stack.push(root)
  while !current_level_stack.is_empty?
    temporal_node =  current_level_stack.pop
    if temporal_node
      print temporal_node.value, " "

      # if left_to_right is 1, we push the temporal_node’s left child, then its right child to next_level_stack.
      # Otherwise (meaning the track of current level's order is from right to left), we push the temporal_node’s right child, then its left child to next_level_stack
      if left_to_right == 1
        next_level_stack.push(temporal_node.left_child) if temporal_node.left_child
        next_level_stack.push(temporal_node.right_child) if temporal_node.right_child
      else
        next_level_stack.push(temporal_node.right_child) if temporal_node.right_child
        next_level_stack.push(temporal_node.left_child) if temporal_node.left_child
      end

      # When current_level_stack is empty, we print end of line, change left_to_right
      if current_level_stack.is_empty?
        puts "\n"
        left_to_right = 1 - left_to_right
          # swap current_level_stack with next_level_stack
        temp = Stack.new()
        temp = current_level_stack
        current_level_stack = next_level_stack
        next_level_stack = temp
      end
    end
  end
end


# TEST DRIVE
h = Node.new(8)
g = Node.new(7)
f = Node.new(6)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f, g)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a

zigzag_traversal(root)
puts

zigzag_traversal(h)
puts

zigzag_traversal(b)