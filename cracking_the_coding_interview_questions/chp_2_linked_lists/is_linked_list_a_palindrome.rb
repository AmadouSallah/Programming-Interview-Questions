require_relative './../../linked_lists/implement_linked_list.rb'

# Problem: Implement a function to check if a linked list is a palindrome

# We will use a stack for this problem, so let's implement one with only push, pop, and is_empty? methods

class Stack
  attr_accessor :store, :size
  def initialize
    @store = []
    @size = 0
  end

  def push(element)
    @size += 1
    @store << element
  end

  def pop
    raise "Stack Underflow - The stack is empty" if self.is_empty?
    @size -= 1
    @store.pop
  end

  def is_empty?
    @size == 0
  end
end

# Now, back to the problem solution

# PSEUDOCODE
# 1) We return nil if the input head is nil or if it's next is nil
# 2) We define 2 pointers, slow_node and fast_node, that we intialize to head; we also initialize a stack.
# We iterate through the list: slow_node will move at a rate of 1 whereas fast_node will move at a rate of 2
# 3) We push the elements of the 1st half of the list to the stack (the values of slow_node)
# 4) If the linked list has odd number of elements, we skip the middle node
# 5) We iterare through the rest of the list and at each iteration, we compare the node value to the value at the top of the stack (we pop it at each iteration and compare)
# We return true if we finish the itereation without finding any difference; otherwise, we return false


def is_linked_list_a_palindrome?(head)
  return true if head == nil || head.next_node == nil

  slow_node = head
  fast_node = head
  stack = Stack.new()

  while fast_node && fast_node.next_node
    stack.push(slow_node.value)
    slow_node = slow_node.next_node
    fast_node = fast_node.next_node.next_node
  end

    # skip middle element if linked list has odd number of elements
    slow_node = slow_node.next_node if fast_node

    while slow_node
      return false if slow_node.value != stack.pop()
      slow_node = slow_node.next_node
    end
    true
end

# TEST DRIVE
e = Node.new(0, nil)
d = Node.new(1, e)
c = Node.new(2, d)
b = Node.new(1, c)
a = Node.new(0, b)

odd_list = List.new(a)

i = Node.new(3, nil)
h = Node.new(4, i)
g = Node.new(4, h)
f = Node.new(3, g)

even_list = List.new(f)

p is_linked_list_a_palindrome?(a) == true
p is_linked_list_a_palindrome?(f) == true
p is_linked_list_a_palindrome?(b) == false
p is_linked_list_a_palindrome?(h) == false