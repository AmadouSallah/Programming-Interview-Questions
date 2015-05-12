require_relative 'implement_linked_list'

# Write a merge_2_sorted_lists function that takes two lists, each of which is sorted in increasing order,
# and merges the two together into one list which is in increasing order.
# merge_2_sorted_lists should return the new list, which should be made by splicing together the nodes of the first two lists.

# For example if the first linked list a is 5->10->15 and the other linked list b is 2->3->20,
# then merge_2_sorted_lists should return a pointer to the head node of the merged list 2->3->5->10->15->20.

def merge_2_sorted_lists(head_1, head_2)
  return head_1 if head_2 == nil
  return head_2 if head_1 == nil

  result_head = nil
  if head_1.value < head_2.value
    result_head = head_1
    result_head.next_node = merge_2_sorted_lists(head_1.next_node, head_2)
  else
    result_head = head_2
    result_head.next_node = merge_2_sorted_lists(head_1, head_2.next_node)
  end
  result_head
end

# TEST DRIVE

c = Node.new(15, nil)
b = Node.new(10, c)
a = Node.new(5, b)

g = Node.new(20, nil)
f = Node.new(3, g)
e = Node.new(2, f)

merged = merge_2_sorted_lists(a, e)
List.new(merged).each {|node| print node.value, " "}
puts
