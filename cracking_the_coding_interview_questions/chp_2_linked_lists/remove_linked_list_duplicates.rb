require_relative './../../linked_lists/implement_linked_list.rb'

# Problem 2.1 (Cracking the Coding Interview):
# Write code to remove duplicates from an unsorted linked list
# FOLLOW UP
# How would you solve this problem if a temporary buffer is not allowed?

# SOLUTION 1
# Pseudocode
# We intially define 2 pointers,current_node and previous_node, that point to the head of the linked list
# We also initialize a hash, number_of_repeats, with a default value of 0
# We loop through the linked list and we add the values of the nodes in the hash. The hash values will represent the number of times each node value is present in list.
# If we reach a node that is not a repeat, we increment the hash key value of the corresponding node value by 1; we then set the next node of 'previous_node' to the 'current_node'
# If we reach a node whose value is a repeat (the corresponding hash value is > 0), we set the next node of 'previous_node' to the next node of the 'current_node'
def remove_linked_list_duplicates(head)
  current_node = head
  previous_node = head
  number_of_repeats = Hash.new(0)
  while current_node != nil
    if number_of_repeats[current_node.value] > 0
      previous_node.next_node = current_node.next_node
    else
      number_of_repeats[current_node.value] += 1
      previous_node = current_node
    end
    current_node = current_node.next_node
  end
  head
end

# SOLUTION 2: without a temporary buffer

# TEST DRIVE
e = Node.new(1, nil)
d = Node.new(4, e)
c = Node.new(3, d)
b = Node.new(3, c)
a = Node.new(1, b)

list = List.new(a)

print "Initially, the values of the list are: "
list.each {|node| print node.value, " "}
puts

remove_linked_list_duplicates(a)

print "\nAfter removing the duplicates, the values of the list are: "
list.each {|node| print node.value, " "}
puts