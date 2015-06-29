# Implement a binary heap

class BinaryHeap
  attr_accessor :size, :heap_array
  def initialize
    @size = 0
    @heap_array = []
  end

  # returns the index of the parent of i if 0 < i < @size; otherwise returns -1
  def parent(i)
    (i - 1) / 2
  end

  # returns the index of the left child of i if
  def left_child(i)
    (2 * i) + 1
  end

  # returns the index of the right child of i
  def right_child(i)
    2 * (i + 1)
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

    max_index = left_index if @heap_array[max_index] && self.left_child_key(i) && (@heap_array[max_index] < self.left_child_key(i))
    max_index = right_index if @heap_array[max_index] && self.right_child_key(i) && (@heap_array[max_index] < self.right_child_key(i))

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

  # inserts an element inside the heap
  def insert(element)
    i = @size
    @heap_array << element
    @size += 1

    while i > 0
      parent = self.parent(i)

      if @heap_array[i] > @heap_array[parent]
        swap(@heap_array, i, parent)
      else
        break
      end

      i = parent
    end

  end

end

def swap(array, i, j)
  temp = array[i]
  array[i] = array[j]
  array[j] = temp
end


heap = BinaryHeap.new()

print "Inserting 5 into the heap; "
heap.insert(5)
puts "The heap array is now: #{heap.heap_array}"
print "\nInserting 10 into the heap; "
heap.insert(10)
puts "The heap array is now: #{heap.heap_array}"
print "\nInserting 0 into the heap; "
heap.insert(0)
puts "The heap array is now: #{heap.heap_array}"
print "\nInserting 20 into the heap; "
heap.insert(20)
puts "The heap array is now: #{heap.heap_array}"
print "\nInserting 1 into the heap; "
heap.insert(1)
puts "The heap array is now: #{heap.heap_array}"

puts "\nThe maximum element in the heap is #{heap.get_max_element}"


puts "The left child of 10 is #{heap.heap_array[heap.left_child(10)]}"
# p heap.left_child(0)
# p heap.right_child(3) == -1
# p heap.right_child_key(2) == nil
# p heap.max_heapify(0) == nil

# p heap.delete_max
