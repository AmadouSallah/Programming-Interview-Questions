# Implement a binary heap

class BinaryHeap
  attr_accessor :size, :heap_array
  def initialize
    @size = 0
    @heap_array = []
  end

  # returns the index of the parent of i if 0 < i < @size; otherwise returns -1
  def parent(i)
    if i <= 0 || i >= @size
      return -1
    else
      return (i - 1) / 2
    end
  end

  # returns the index of the left child of i if
  def left_child(i)
    left = (2 * i) + 1
    if left >= @size
      return -1
    else
      return left
    end
  end

  # returns the index of the right child of i
  def right_child(i)
    right = 2 * (i + 2)
    if right >= @size
      return -1
    else
      return right
    end
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
# p heap.left_child(1) == -1
# p heap.right_child(3) == -1
# p heap.right_child_key(2) == nil