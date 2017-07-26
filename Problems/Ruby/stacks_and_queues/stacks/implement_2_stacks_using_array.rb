# Problem: Implement two Stacks using only one array.

class TwoStacksUsingArray
  attr_accessor :array, :size, :top1, :top2
  def initialize(size = 4) # giving it a default size
    @array = Array.new(size)
    @size = size
    @top1 = top1 = -1
    @top2 = top2 = @size
  end

  # Adds an element to stack 1
  def push_stack1(element)
    raise 'Stack Overflow - Stack is full' if @top1 >= @top2 - 1
    @top1 += 1
    @array[@top1] = element
  end

    # Adds an element to stack2
  def push_stack2(element)
    raise 'Sack Overflow - Stack is full' if @top1 >= @top2 - 1
    @top2 -=1
    @array[@top2] = element
  end

  # Removes the top element from stack1
  def pop_stack1
    raise "Stack Underflow - Stack1 is empty" if @top1 < 0
    element = @array[@top1]
    @array[@top1] = nil
    @top1 -= 1
    element
  end

  # Removes the top element from stack2
  def pop_stack2
    raise "Stack Underflow - Stack2 is empty" if @top2 > @size - 1
    element = @array[@top2]
    @array[@top2] = nil
    @top2 += 1
    element
  end

end

two_stacks = TwoStacksUsingArray.new()

puts "Adding 1, and 2 to stack1"
two_stacks.push_stack1(1)
two_stacks.push_stack1(2)
p two_stacks.array

puts "\nAdding 3, and 4 to stack2"
two_stacks.push_stack2(3)
two_stacks.push_stack2(4)
p two_stacks.array

puts "\nRemoving the top element, #{two_stacks.pop_stack1}, from stack1"
p two_stacks.array

puts "\nRemoving the top element, #{two_stacks.pop_stack2}, from stack2"
p two_stacks.array