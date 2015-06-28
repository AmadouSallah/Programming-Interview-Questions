require_relative 'implement_binary_heap'
# Assuming a max heap, write a method to heapify it.

def max_heapify(heap, i)
  max_index = i
  left_index = heap.left_child(i)
  right_index = heap.right_child(i)

  max_index = left_index if heap.heap_array[max_index] && heap.left_child_key(i) && (heap.heap_array[max_index] < heap.left_child_key(i))
  max_index = right_index if heap.heap_array[max_index] && heap.rigth_child_key(i) && (heap.heap_array[max_index] < heap.rigth_child_key(i))


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
p max_heapify(heap, 0)

