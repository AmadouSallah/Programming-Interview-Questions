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

  temporal_node = nil # we initialize it to nil since the last node of the reversed list will point to it.
  while head
    next_node = head.next_node
    head.next_node = temporal_node
    temporal_node = head
    head = next_node
  end
  temporal_node
end

# RECURSIVE Solution
# PSEUDOCODE:
# 1) We return nil if the input head is nil
# 2) Base case: we return head if its next pointer is nil (we are at the last node)
# 3) Recursive part:
# a) We define a variable second_node that points to the next node of head and we set the next pointer of head to nil
# b) We recursively call the function on second_node and we store the ouput of this call in a variable (reversed_rest_of_list)
# 4) We join the 2 lists (head and second_node) by pointing the next pointer of second_node to head
# 5) We return reversed_rest_of_list

def reverse_recursive(head)
  return nil if head == nil

  # Base case
  return head if head.next_node == nil

  # Recursive case
  second_node = head.next_node
  head.next_node = nil # we unlink head from the rest of the list
  reversed_rest_of_list = reverse_recursive(second_node) # we reverse everything from the second node
  second_node.next_node = head # We join the 2 lists
  reversed_rest_of_list
end


# TEST DRIVE
e = Node.new(5, nil)
d = Node.new(4, e)
c = Node.new(3, d)
b = Node.new(3, c)
a = Node.new(1, b)

puts "Testing the iterative solution"
print "The initial linked list has these consecutive values: "
List.new(a).each {|node| print node.value, " "}
puts

rev = reverse(a)
print "After reversing the list, the new linked list has these consecutive values: "
List.new(rev).each {|node| print node.value, " "}

###################
puts "Testing the recursive solution"
puts "-"*20

e = Node.new(5, nil)
d = Node.new(4, e)
c = Node.new(3, d)
b = Node.new(3, c)
a = Node.new(1, b)

print "The initial linked list has these consecutive values: "
List.new(a).each {|node| print node.value, " "}
puts

rev_rec = reverse_recursive(a)
print "After reversing the list, the new linked list has these consecutive values: "
List.new(rev_rec).each {|node| print node.value, " "}
puts