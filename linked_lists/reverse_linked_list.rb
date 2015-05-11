require_relative 'implement_linked_list'

# Iterative Solution
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

