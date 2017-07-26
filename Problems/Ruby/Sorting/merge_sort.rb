def merge_sort(array)
  len = array.length
  return array if len < 2
  middle_index = len / 2

  left_sorted_array = merge_sort(array[0, middle_index])
  right_sorted_array = merge_sort(array[middle_index, len - middle_index])
  return merge(left_sorted_array, right_sorted_array)
end

def merge(array1, array2)
  return_array = []

  while array1.length > 0 && array2.length > 0
    if array1[0] < array2[0]
      return_array << array1.shift
    else
      return_array << array2.shift
    end
  end
  return_array += array1 + array2
end

# TEST DRIVE
my_array = [5, 1, -1, 0, 8, 5]

p merge_sort([]) == []
p merge_sort([3]) == [3]
p merge_sort([30, 3]) == [3, 30]
p merge_sort(my_array) == [-1, 0, 1, 5, 5, 8]
p merge_sort([-1,1,3,1,4, 3, 1]) == [-1, 1, 1, 1, 3, 3, 4]