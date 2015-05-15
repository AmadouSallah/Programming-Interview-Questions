def selection_sort(array)
  len = array.length
  i = 0
  while i < len - 1
    min_index = i
    j = i+1
    while j < len
      # We keep track of the index of the smallest element
      min_index = j if array[j] < array[min_index]
      j += 1
    end
    # We now swpa the element at index i with the smallest
    swap(array, i, min_index) if i < min_index
    i += 1
  end
  array
end

def swap(array, index1, index2)
  temp = array[index1]
  array[index1] = array[index2]
  array[index2] = temp
end

# TEST DRIVE
my_array = [5, 1, -1, 0, 8, 5]

p selection_sort([]) == []
p selection_sort([3]) == [3]
p selection_sort([5, 3]) == [3, 5]
p selection_sort(my_array) == [-1, 0, 1, 5, 5, 8]
