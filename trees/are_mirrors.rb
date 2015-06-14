require_relative 'binary_trees'

# Problem: Write a program to check if 2 binary trees are mirrors of each other

# Example:
# tree1
#      1
#    /    \
#   2      3
#  / \    /
# 4   5  6
#       /
#      8
# tree2
#      1
#    /    \
#   3      2
#    \    / \
#     6  5   4
#       \
#         8
# output should be true

def are_mirrors?(root1, root2)
  return true if !root1 && !root2
  if !root1 || !root2
    return false
  elsif root1.value != root2.value
    return false
  else
    return are_mirrors?(root1.left_child, root2.right_child) && are_mirrors?(root1.right_child, root2.left_child)
  end

end

h = Node.new(8)
f = Node.new(6, h)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root1 = a

h2 = Node.new(8)
f2 = Node.new(4)
e2 = Node.new(5)
d2 = Node.new(6)
d2.right_child = h2

c2 = Node.new(2, e2, f2)
b2 = Node.new(3)
b2.right_child = d2

a2 = Node.new(1, b2, c2)

root2 = a2
p are_mirrors?(root1, root1) == false
p are_mirrors?(root1, Node.new()) == false
p are_mirrors?(Node.new(), Node.new()) == true
p are_mirrors?(h, h2) == true
p are_mirrors?(b, c2) == true
p are_mirrors?(f, d2) == true
p are_mirrors?(c, b2) == true
p are_mirrors?(root1, root2) == true

