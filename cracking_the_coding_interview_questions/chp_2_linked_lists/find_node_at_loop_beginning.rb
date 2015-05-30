require_relative './../../linked_lists/implement_linked_list.rb'

# Problem: Given a circular linked list, implement an algorithm which returns node at the beginning of the loop

# DEFINITION
# Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list
# EXAMPLE
# Input: A -> B -> C -> D -> E -> C [the same C as earlier] Output: C

# SOLUTION
# We'll use Floyd's cycle-finding algorithm: http://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare

# PSEUDOCODE
# 1) We create 2 nodes, fast_node and slow_node
# 2) We move fast_node (respectively, slow_node) at a rate of 2 (resp. 1) nodes.
# 3) Error check: case where there is no collision, i.e. no loop
#    we return nil if either fast_node or fast_node.next is nil
# 4) At this point, both pointers meet.
# We then move slow_node to the beginning of the list; each of them is now at the same distance from the beginning of the loop
# In a new iteration, we move them both at the same rate of 1 (moving them at this same rate means they will meet at the beginning of the loop).
# 5) At the end of the iteration above, both nodes point to the beginning of the loop.


def find_node_at_loop_beginning(head)
  fast_node = head
  slow_node = head

  while fast_node && fast_node.next_node
    fast_node = fast_node.next_node.next_node
    slow_node = slow_node.next_node
    break if slow_node == fast_node # collision occurs
  end

  # Error check: the nodes don't meet, that means no collision
  return nil if fast_node == nil || fast_node.next_node == nil

  slow_node = head
  while fast_node != slow_node
    fast_node = fast_node.next_node
    slow_node = slow_node.next_node
  end

  # Both fast_node and slow_node point to the beginning of the loop
  slow_node
end

# # TEST DRIVE
# f = Node.new(5, c)
# e = Node.new(4, f)
# d = Node.new(3, e)
# c = Node.new(2, d)
# b = Node.new(1, c)
# a = Node.new(0, b)

# list = List.new(a)

# loop_found = find_node_at_loop_beginning(a)
# p loop_found.value