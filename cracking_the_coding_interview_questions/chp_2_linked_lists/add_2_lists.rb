require_relative './../../linked_lists/implement_linked_list.rb'

# Problem: You have two numbers represented by a linked list, where each node contains a single digit.
# The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
# Write a function that adds the two numbers and returns the sum as a linked list.
# FOLLOW UP
# Support the digits are stored in forward order. Repeat the above problem.

# EXAMPLE
# Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
# Output: 8 -> 0 -> 8

def add_2_lists(head1, head2)
  return nil if head1 == nil && head2 == nil

  result_head = Node.new(nil, nil)
  prev_node = Node.new(nil, nil)
  carry = 0

  while head1 || head2

    value1 = head1 ? head1.value : 0
    value2 = head2 ? head2.value : 0
    sum = carry + value1 + value2

    # Update value and carry
    carry = sum / 10
    value = sum % 10
    # Create a new node with "value" as its value
    current_node = Node.new(value, nil)

    # If current_node is the 1st node, we set it as the head of result_head; otherwise we connect it to the rest.
    if result_head.value == nil
      result_head = current_node
    else
      prev_node.next_node = current_node
    end

    # Move prev_node to current_node for the next insertion
    prev_node = current_node

    # Move head1 and head2 to the next node if possible
    head1 = head1.next_node if head1
    head2 = head2.next_node if head2
  end

  current_node.next_node = Node.new(carry, nil) if carry > 0

  result_head
end

# RECURSIVE METHOD
def add_2_lists_2(head1, head2)
  add_lists_helper(head1, head2, 0)
end

def add_lists_helper(head1, head2, carry)
  return nil if head1 == nil && head2 == nil

  # result_head = Node.new(nil, nil)
  sum = carry

  sum += head1.value if head1
  sum += head2.value if head2

  value = sum % 10
  carry = sum / 10

  result_head = Node.new(value, nil)

  remaining_nodes = add_lists_helper(head1 == nil ? nil : head1.next_node, head2 == nil ? nil : head2.next_node, carry)

  result_head.next_node = remaining_nodes

  result_head
end

# TEST DRIVE
f = Node.new(2, nil)
e = Node.new(9, f)
d = Node.new(5, e)

c = Node.new(5, nil)
b = Node.new(1, c)
a = Node.new(3, b)

list1 = List.new(a) # 3 -> 1 -> 5
list2 = List.new(d) # 5 -> 9 -> 2

print "list1 is: "
list1.each {|node| print node.value, " "}

print "\nlist2 is: "
list2.each {|node| print node.value, " "}

puts "\n\n----------- Testing recursive method ------"
r = add_2_lists(a, d) # 8 -> 0 -> 8 (513 + 295 = 808)
print "\nlist1 + list 2 gives: "
List.new(r).each {|n| print n.value, " "}

puts "\n\n----------- Testing recursive method ------"
r2 = add_2_lists_2(a, d) # 8 -> 0 -> 8 (513 + 295 = 808)
print "\nlist1 + list 2 gives: "
List.new(r).each {|n| print n.value, " "}
puts "\n\n"
