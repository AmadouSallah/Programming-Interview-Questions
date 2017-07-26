require_relative 'implement_binary_search_tree'
# Problem: Write a program to delete an element from a Binary Search Tree.

# See algorithm at https://en.wikipedia.org/wiki/Binary_search_tree#Deletion

# PSEUDOCODE
# We have 3 cases to consider for the node to be deleted: it has no children, has only 1 child, or both children
# Case 1: If the node to be deleted has no children, just remove the node from the tree
# case 2: If the node to be deleted has only 1 child, remove the node and replace it with its child
# case 3: If the node to be deleted has both left and right children, do the followings:
# i) Replace the key of the node with the largest element in the left subtree ( that is with the inorder predecessor node).
# The largest node cannot have a right child; it has atmost 1 child (left child).
# ii) Delete this largest element by replacing it with its child (if any) (case 1 or 2)

def delete(root, data)
# puts "Value = *** #{root.value} ****,  data = #{data}"
  if !root
    puts "The tree or a subtree is empty!"
    return nil
  elsif data < root.value
    root.left_child = delete(root.left_child, data)
  elsif data > root.value
    root.right_child = delete(root.right_child, data)
  else # we found the value the node to be deleted
    if root.left_child && root.right_child # if both left and right children exists
      inorder_predecessor = find_max(root.left_child)
      # replace root's value with that of inorder_predecessor
      root.value = inorder_predecessor.value
      # now replace root's left by delete inorder_predecessor's node
      root.left_child = delete(root.left_child, root.value)
    else # root has at most 1 child; replace it with its child if any
      if !root.left_child && !root.right_child # if root has no children
        root = nil
      elsif root.left_child # if root has a left child, replace it but that child
        root = root.left_child
      else # root has right child, therefore replace it by that child
        root = root.right_child
      end
    end
  end
  root
end

def find_max(root)
  return nil if !root
  while root.right_child
    root = root.right_child
  end
  root
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

delete(root, 3) # the tree should now look like below:
#      3
#    /    \
#   2      6
#  /      / \
# 1      5   7

p root

