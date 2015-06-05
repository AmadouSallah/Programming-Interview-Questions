# Implementing a queue
# A queue is an ordered list in which insertions are done at one end (back)
# and deletions are done at another end (front). The first element to be inserted
# is the first one to be deleted. Hence, it is called First In First Out (FIFO)

class Queue
  attr_accessor :store
  def initialize
    @store = []
  end

  # Adds an element to the back of the queue
  def enqueue(element)
    @store << element
  end

  # removes the element at the front and returns it
  def dequeue
    raise "Queue Underflow - The queue is empty" if self.is_empty?
    @store.shift
  end

  # returns the element at the front (without removing it)
  def peek
    @store.first
  end

  # returns the size of the queue
  def size
    @store.length
  end

  # checks to see if the queue is empty or not
  def is_empty?
    self.size == 0
  end

end

# TEST DRIVE
# my_queue = Queue.new

# puts "\nInitially, the queue is #{my_queue.store} with a size of #{my_queue.size}"

# puts "\nAdding A, B, C, and D to the queue:"
# my_queue.enqueue('A')
# my_queue.enqueue('B')
# my_queue.enqueue('C')
# my_queue.enqueue('D')
# puts "The queue is now #{my_queue.store} with a size of #{my_queue.size}."

# puts "\nRemoving the first element:\n"
# element = my_queue.dequeue
# puts "Element #{element} has been removed from the queue, which is now: #{my_queue.store}"