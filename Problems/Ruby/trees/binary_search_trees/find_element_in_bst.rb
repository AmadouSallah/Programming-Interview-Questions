require_relative 'implement_binary_search_tree'

# Recursive solution
def find(root, data)
  return nil if !root
  return root if root.value == data
  if data < root.value
    return find(root.left_child, data)
  else
    return find(root.right_child, data)
  end
end

# Iterative solution
def find_iterative(root, data)
  return nil if !root
  while root
    if root.value == data
      return root
    elsif data < root.value
      root = root.left_child
    else
      root = root.right_child
    end
  end
  nil
end

# TEST DRIVE
#      4
#    /    \
#   2      6
#  / \    / \
# 1   3  5   7

d = Node.new(1)
e = Node.new(3)
f = Node.new(5)
g = Node.new(7)

b = Node.new(2, d, e)
c = Node.new(6, f, g)

a = Node.new(4, b, c)

root = a

p find(nil, 2) == nil
p find(root, 2) == b
p find(c, 3) == nil

p find_iterative(nil, 2) == nil
p find_iterative(root, 2) == b
p find_iterative(c, 3) == nil