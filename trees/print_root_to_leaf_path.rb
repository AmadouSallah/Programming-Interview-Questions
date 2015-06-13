require_relative 'binary_trees'

# Problem: Given a binary tree, print out all of its root-to-leaf paths one per line
# Example for the binary tree below,
#      1
#    /    \
#   2      3
#  / \    /
# 4   5  6
#       /
#      8
# the output will be:
# 1 2 4
# 1 2 5
# 1 3 6 8

def print_root_to_leaf_path(root)
  print_path(root, [], 0)
end

def print_path(node, path_array, path_lenght)
  return if !node
  path_array[path_lenght] = node.value # push the node value to the array
  path_lenght += 1 # Increment path_length for next node value in the path

  if !node.left_child && !node.right_child # if the node is a leave
    print_array(path_array) # print the elements of the array
  else # call the function recursively for both left and right children with same array but with a path_length that was incremented by 1 from above
    print_path(node.left_child, path_array, path_lenght)
    print_path(node.right_child, path_array, path_lenght)
  end
end

def print_array(array)
  array.each {|element| print element, " "}
  puts "\n"
end

h = Node.new(8)
f = Node.new(6, h)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a

print_root_to_leaf_path(root)