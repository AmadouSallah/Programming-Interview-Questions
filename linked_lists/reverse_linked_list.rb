require_relative 'implement_linked_list'

# Iterative Solution
# PSEUDOCODE:
# 1) If the head node is nil, we just return it
# 2) We initialize a temporal_node to nil
# 3) We loop through the linked list starting from the head node (the input) until the last node. We will be moving head 1 node at a time until we reach the last node
# a) We define a variable next_node and have it point to the next node of head
# b) We make the next of head point to the temporal_node
# c) We set temporal_node equal to head
# d) We set head equal to next_node
# e) We repeat a) to d) until head becomes nil
# 4) We then return temporal_node

def reverse(head)
  return head if head == nil

  temporal_node = nil
  while head
    next_node = head.next_node
    head.next_node = temporal_node
    temporal_node = head
    head = next_node
  end
  temporal_node
end

# TEST DRIVE
e = Node.new(5, nil)
d = Node.new(4, e)
c = Node.new(3, d)
b = Node.new(3, c)
a = Node.new(1, b)

print "The initial linked list has these consecutive values: "
List.new(a).each {|node| print node.value, " "}
puts

rev = reverse(a)
print "After reversing the list, the new linked list has these consecutive values: "
List.new(rev).each {|node| print node.value, " "}
puts

