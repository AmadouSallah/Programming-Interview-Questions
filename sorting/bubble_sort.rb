# We iterate the input array from the 1st element to the last, comparing each pair of
# elements and swapping them if needed.

def bubble_sort(array)
  i = 0
  while i < array.length
    j = i + 1
    while j < array.length
      swap(array, i, j) if array[j] < array[i]
      j += 1
    end
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

p bubble_sort([]) == []
p bubble_sort([3]) == [3]
p bubble_sort([30, 3]) == [3, 30]
p bubble_sort(my_array) == [-1, 0, 1, 5, 5, 8]

