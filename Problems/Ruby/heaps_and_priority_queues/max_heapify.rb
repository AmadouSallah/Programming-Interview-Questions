require_relative 'implement_binary_heap'
# Assuming a max heap, write a method to heapify it.

def max_heapify(heap, i)
  max_index = i
  left_child_index = heap.left_child(i)
  right_child_index = heap.rigth_child(i)

  left_element = heap.heap_array(left_child_index)
  right_element = heap.heap_array(right_child_index)

  max_index = maximum(max_index, maximum(left_element, right_element))

  if max_index != i
    swap(heap.heap_array, i, max_index)
    max_heapify(heap, max_index)
  end

end

def maximum(a, b)
  a > b ? a : b
end

def swap(array, i, j)
  temp = array[i]
  array[i] = array[j]
  array[j] = temp
end


heap = BinaryHeap.new()
# p max_heapify(heap, 0)

