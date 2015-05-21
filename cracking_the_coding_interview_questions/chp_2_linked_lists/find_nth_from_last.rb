require_relative './../../linked_lists/implement_linked_list.rb'

# Problem: Implement an algorithm to find the nth to last element of a singly linked list (that is the nth counting from the last node).

def find_nth_from_last(head, n)
  return head if head == nil  || n < 1
  node1 = head
  node2 = head
  # we advance node2 by n nodes
  i = 0
  while i < n
    # Error check: check to see if the linked list if less than n nodes;
    # return nil if so, otherwise make node2 go to the next node
    return nil if node2 == nil
    node2 = node2.next_node
    i += 1
  end

  # Now, move both node1 and node2 to the right (with the same speed) until node2 points to nil (i.e. node2 is at the end). At that point, node1 will be pointing to the nth node from the last node.
  while (node2.next_node != nil)
    node1 = node1.next_node
    node2 = node2.next_node
  end
  node1
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
puts

third_from_last = find_nth_from_last(a, 3)
puts "The 3rd node from the last has value: #{third_from_last.value}"
print "The list starting from the 3rd node from the last is: "
List.new(third_from_last).each  {|node| print node.value, " "}
puts