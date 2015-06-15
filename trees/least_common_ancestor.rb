require_relative 'binary_trees'

# Problem: Given a binary tree and two nodes, write a program to find the least common ancestor (LCA).
# Example: For the tree below,
#      1
#    /    \
#   2      3
#  / \    /
# 4   5  6
#       /
#      8
# LCA(8, 5) = 1, LCA(1,6) = 1, LCA(4,5) = 2

# SOLUTION
# 1) If any of the input keys matches the root, then the root is the LCA.
# 2) Otherwise, we recursively call the funtion on the left and right children of root;
# a) if a node has one of the keys in its left subtree and the other key
# in its right subtree, (both recursions return somethin non nil) that node is the LCA.
# b) However, if both keys lie in a left (respectively right) subtree, then the left (resp. right) subtree has the LCA.

def least_common_ancestor(root, node1, node2)
  return root if !root
  return root if (root == node1 || root == node2)

  left_lca = least_common_ancestor(root.left_child, node1, node2)
  right_lca = least_common_ancestor(root.right_child, node1, node2)

  return root if left_lca && right_lca

  return (left_lca ? left_lca : right_lca)
end

h = Node.new(8)
f = Node.new(6, h)
e = Node.new(5)
d = Node.new(4)
c = Node.new(3, f)
b = Node.new(2, d, e)
a = Node.new(1, b, c)

root = a

p least_common_ancestor(root, a, f) == root
p least_common_ancestor(root, h, e) == a
p least_common_ancestor(root, d, e) == b
p least_common_ancestor(root, b, d) == b
p least_common_ancestor(root, a, a) == a
