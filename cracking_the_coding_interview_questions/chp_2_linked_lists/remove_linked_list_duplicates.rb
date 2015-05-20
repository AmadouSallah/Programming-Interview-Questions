require_relative './../../linked_lists/implement_linked_list.rb'

# Problem 2.1 (Cracking the Coding Interview):
# Write code to remove duplicates from an unsorted linked list
# FOLLOW UP
# How would you solve this problem if a temporary buffer is not allowed?

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