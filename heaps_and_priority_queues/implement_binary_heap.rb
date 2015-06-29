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

  # returns the largest element of the heap (element at top)
  def get_max_element
    raise "Error: Heap is empty" if @size <= 0
    heap_array[0]
  end

  def max_heapify(i)
    max_index = i
    left_index = self.left_child(i)
    right_index = self.right_child(i)

    max_index = left_index if self.heap_array[max_index] && self.left_child_key(i) && (self.heap_array[max_index] < self.left_child_key(i))
    max_index = right_index if self.heap_array[max_index] && self.rigth_child_key(i) && (self.heap_array[max_index] < self.rigth_child_key(i))

    if max_index != i
      # swap elements at index i and at max_index
      swap(@heap_array, i, max_index)

      # call max_heapify at index max_index
      max_heapify(heap, max_index)
    end
  end

  # removes and returns the first element of the heap, which is the largest one.
  def delete_max
    max_element = self.get_max_element
    # replace this max element with the last element of the heap
    heap.heap_array[0] = heap.heap_array[-1]
    self.size -= 1 # reduce the size before sine the last element is now at top.
    self.max_heapify(0) # to make sure that the heap property is not violated
    max_element # returns the largest element
  end

end

def swap(array, i, j)
  temp = array[i]
  array[i] = array[j]
  array[j] = temp
end


heap = BinaryHeap.new()
p heap.left_child(1) == -1
p heap.right_child(3) == -1
p heap.right_child_key(2) == nil
p heap.max_heapify(0) == nil

p heap.delete_max
