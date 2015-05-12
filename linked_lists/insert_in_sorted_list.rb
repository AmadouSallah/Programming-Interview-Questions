require_relative 'implement_linked_list'

# Problem: Given a sorted linked list (assume sorted in ascending way), write a function to insert a node of a given value
# in a sorted way, that is, the linked list should be sorted after the insertion

# Precondition: the list is in ascending order
# Postcondition: the list is in ascending order and contain the node of value 'value'

# PSEUDOCODE
# 1) If the input node (head) is nil, or if the value of head is greater than or equal to the value to be inserted,
# we make a node whose value is the value to be inserted, and whose next pointer points to the head; we then make head point to this node. We return head
# 2) Otherwise, we define a node variable, current_node, that we initialize to head. We also define a varialbe, temporal_node, that we initialize to nil
# 3) We traverse the linked list until we either find a node of larger value or we reach the end of the list
# current_node will point to the current node we are at, whereas temporal node will point to the previous node.
# 4) At the end of the loop, we insert the node just before the larger item

def insert_in_sorted_list(head, value_to_insert)
  if head == nil || head.value >= value_to_insert
    head = Node.new(value_to_insert, head)
    return head
  end

  current_node = head
  temporal_node = nil
  # traverse the list until we either find a node of larger value or we reach the end of the list
  while (current_node && current_node.value < value_to_insert)
    temporal_node = current_node
    current_node = current_node.next_node
  end

  # we insert the node just before the larger item
  temporal_node.next_node = Node.new(value_to_insert, current_node)
  head

end

# TEST DRIVE
e = Node.new(15, nil)
d = Node.new(9, e)
c = Node.new(6, d)
b = Node.new(4, c)
a = Node.new(1, b)

head = List.new(a)
print "Initially, the list has values: "
head.each {|node| print node.value, " "}

puts "\n\nInserting a node of value 0 (at the beginning):"

a = insert_in_sorted_list(a, 0)

print "After inserting 0, the list has values: "
List.new(a).each {|node| print node.value, " "}

puts "\n\nInserting a node of value 6 (in the middle)"
a = insert_in_sorted_list(a, 6)
print "After inserting 6, the list has values: "
List.new(a).each {|node| print node.value, " "}

puts "\n\nInserting a node of value 20 (at the end)"
a = insert_in_sorted_list(a, 20)
print "After inserting 20, the list has values: "
List.new(a).each {|node| print node.value, " "}
puts
