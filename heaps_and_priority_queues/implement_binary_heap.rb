# Implement a binary heap

class BinaryHeap
  attr_accessor :size, :heap_array
  def initialize
    @size = 0
    @heap_array = []
  end

  # returns the index of the parent of i
  def parent(i)
    raise "Your input index should neither be <=0, nor >= size of heap - Out of range" if i <= 0 || i >= @size
    (i - 1) / 2
  end

  # returns the index of the left child of i
  def left_child(i)
    left = (2 * i) + 1
    raise "The element at index #{i} doesn't have a left child; sorry" if left >= @size
    left
  end

  # returns the index of the right child of i
  def right_child(i)
    right =2 * (i + 2)
    raise "The element at index #{i} doesn't have a right child; sorry" if right >= @size
    right
  end

  # returns the value of the left child of the element at index i
  def left_child_key(i)
    heap_array[2 * i + 1]
  end

  # returns the value of the right child of the element at index i
  def right_child_key(i)
    heap_array[2 * i + 2]
  end

end


# heap = BinaryHeap.new()
# p heap.right_child_key(0)