require_relative './../../linked_lists/implement_linked_list.rb'

# Problem: Write code to partition a linked list around a value x, such that all
# nodes less than x come before all nodes greater than or equal to x.

def partition(head, x)
  smaller_nodes = nil
  larger_nodes = nil

  while head
    next_one = head.next_node
    if head.value < x
      head.next_node = smaller_nodes
      smaller_nodes = head
    else
      head.next_node = larger_nodes
      larger_nodes = head
    end
    head = next_one
  end

  return larger_nodes if smaller_nodes == nil

  node = smaller_nodes
  while node.next_node
    node = node.next_node
  end

  node.next_node = larger_nodes
  smaller_nodes
end

# TEST DRIVE
f = Node.new(0, nil)
e = Node.new(3, f)
d = Node.new(4, e)
c = Node.new(3, d)
b = Node.new(6, c)
a = Node.new(5, b)

list = List.new(a)

print "Initially, the list is: "
list.each {|node| print node.value, " "}

head_partition = partition(a, 3)

print "\n\nAfter doing a partition at value 3, the list becomes: "
List.new(head_partition).each {|node| print node.value, " "}
puts