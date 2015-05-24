require_relative './../../linked_lists/implement_linked_list.rb'
# Problem: Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node

# EXAMPLE
# Input: the node ‘c’ from the linked list a->b->c->d->e
# Result: nothing is returned, but the new linked list looks like a->b->d->e

# SOLUTION
# We can only solve this problem if the node to be deleted is not the last one in the linked list.

# PSEDOCODE
# We copy the value from the next node of the input node to the current node.
# We then delete the next node

def delete_node_in_middle(node)
  return false if node == nil || node.next_node == nil

  node.value = node.next_node.value
  node.next_node = node.next_node.next_node
  true
end

# TEST DRIVE
e = Node.new(5, nil)
d = Node.new(4, e)
c = Node.new(3, d)
b = Node.new(2, c)
a = Node.new(1, b)

list = List.new(a)

print "Initially, the list is: "
list.each {|node| print node.value, " "}

delete_node_in_middle(c)
print "\n\nAfter removing the node of value 3, the list becomes:"
list.each {|node| print node.value, " "}
puts