# Implementing a Stack using an array
# A stack is an ordered list in which insertion and deletion are done at one end called top.
# The last element  inserted is the first one to be deleted => Last In first Out (LIFO)
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
