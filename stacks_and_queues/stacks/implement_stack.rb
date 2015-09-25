# Implementing a Stack using an array
# A stack is an ordered list in which insertion and deletion are done at one end called top.
# The last element  inserted is the first one to be deleted => Last In first Out (LIFO)

class Stack

  attr_reader :container, :stack_size
  def initialize(stack_size)
    @container = []
    @stack_size = stack_size
  end

  # adds an element to the top (end) of the stack
  def push(element)
    raise "Stack Overflow! - The Stack is full" if @container.length > @stack_size - 1
    @container << element
  end

  # Returns the top stack element if the stack is not empty.
  def peek
    raise "Stack Underflow - The Stack is empty!" if self.is_empty?
    @container.last
  end

  # Removes and returns the top stack element if the stack is not empty.
  def pop
    raise "Stack Underflow - The Stack is empty!" if self.is_empty?
    @container.pop
  end

  # Returns true if the stack is empty, and false otherwise
  def is_empty?
    @container.length == 0
  end

  # Returns true if the stack is full, and false otherwise
  def is_full?
    @container.length == @stack_size
  end
end

myStack = Stack.new(2)

p myStack.is_empty? == true
p myStack.is_full? == false

myStack.push(1)
p myStack.container == [1]

myStack.push(2)
p myStack.container == [1, 2]

p myStack.is_empty? == false
p myStack.is_full? == true

p myStack.peek == 2
myStack.pop

p myStack.container == [1]

######################################
=begin
class Stack
  attr_accessor :store, :top
  def initialize
    @store = []
    @top = -1
  end

  # adds an element to the top of the stack
  def push(element)
    @store.push(element)
    @top += 1
  end

  # Returns the top stack element if the stack is not empty.
  def peek
    raise "Stack Underflow - The stack is empty" if self.is_empty?
    @store[top]
  end

  # Removes the top element from the stack if it is not empty
  def pop
    raise "Stack Underflow - The stack is empty" if self.is_empty?
    top_element = @store.pop
    @top -= 1
    top_element
  end

  # Returns the size of the stack, that is the number of elelments in the stack
  def size
    @store.length
  end

  # Checks if the stack is empty or not
  def is_empty?
    self.size == 0
  end

end

# myStack = Stack.new

# puts "Initially the stack is empty: #{myStack.store}."

# puts "\nAdding 'A', 'B', and 'C' to the stack:"
# myStack.push('A')
# myStack.push('B')
# myStack.push('C')
# puts "The stack is now: #{myStack.store} with a size of #{myStack.size}. The top element is #{myStack.peek}"

# puts "\nRemoving the last element from the stack #{myStack.pop}"
# puts "The stack in now #{myStack.store} and the last element of the stack is #{myStack.peek}; the size of the stack is now #{myStack.size}"

=end

