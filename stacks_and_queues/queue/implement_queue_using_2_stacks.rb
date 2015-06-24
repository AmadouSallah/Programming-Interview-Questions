require_relative './../stacks/implement_stack'

# Problem: Implement a queue using 2 stacks

# We use 2 stacks, stack1 and stack2.
# 1) To enqueue (adding an element to the queue), we push the element to stack1
# 2) To dequeue (removing an element from the queue), we do the followings
# a) If both stacks are empty, we throw an error
# b) If stack2 is empty, we refill it by poping every element from stack1 and
# push it into stack2.
# c) We pop from stack2 and return the poped element

class QueueUsing2Stacks
  attr_accessor :stack1, :stack2
  def initialize
    @stack1 = Stack.new()
    @stack2 = Stack.new()
  end

  # adds element to the queue
  def enqueue(element)
    @stack1.push(element)
  end

  # removes an element from the queue
  def dequeue
    raise "Queue is empty" if @stack1.is_empty? && @stack2.is_empty?

    if @stack2.is_empty?
      while !@stack1.is_empty?
        @stack2.push(@stack1.pop())
      end
    end
    @stack2.pop()
  end

end


my_queue = QueueUsing2Stacks.new()

puts "Adding elements 1, 2, and 3 to the queue:"
my_queue.enqueue(1)
my_queue.enqueue(2)
my_queue.enqueue(3)
puts "The queue has the following elements in it (all located in stack1): #{my_queue.stack1.store}"

puts "\nRemoving an element from the queue:"
my_queue.dequeue
puts "Now the queue has the following elements in it (all located in stack2): #{my_queue.stack2.store}"

