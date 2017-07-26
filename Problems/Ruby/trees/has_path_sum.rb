require_relative 'binary_trees'

# Problem: Given a binary tree and a number, return true if the tree has a root-to-leaf path
# such that adding up all the values along the path equals the given number.
# Return false if no such path can be found.

# Example, for the binary tree below,
#      1
#    /    \
#   2      3
#  / \    /
# 4   5  6
#       /
#      8
# the root to leaf path sums are: 7 => 1 2 4; 8 => 1 2 5; 18 => 1 3 6 8
# The function will return true for numbers 7, 8, or 18, and false otherwise

def has_path_sum?(root, sum)
  return sum == 0 if !root
  remaining_sum = sum - root.value
  if !root.left_child && !root.right_child
    return remaining_sum == 0
  elsif root.left_child && root.right_child
    return has_path_sum?(root.left_child, remaining_sum) || has_path_sum?(root.right_child, remaining_sum)
  elsif root.left_child
    return has_path_sum?(root.left_child, remaining_sum)
  else
    return has_path_sum?(root.right_child, remaining_sum)
  end
end

h = Node.new(8)
f = Node.new(6, h)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a

p has_path_sum?(root, 7) == true
p has_path_sum?(root, 18) == true
p has_path_sum?(root, 1) == false
p has_path_sum?(h, 8) == true
p has_path_sum?(nil, 0) == true
p has_path_sum?(c, 17) == true