# Quick sort is similar to merge sort; like merge sort, it runs in 0(nlogn) time but it is often quicker than merge sort.
# It works by partitioning the input array into 2 array separated by a single element, pivot.
# pivot is >= (respectively <=) to all the elements to its left (resp. right).

def quick_sort(array)
  sort(array, 0, array.length-1)
end

def sort(array, first_index, last_index)
  return array if last_index - first_index < 1

  partition_index = partition(array, first_index, last_index)
  sort(array, first_index, partition_index)
  sort(array, partition_index+1, last_index)
end

def partition(array, low_index, high_index)
  pivot = array[low_index]
  left_index = low_index
  right_index = high_index
  while left_index < right_index
    # We move right_index to the left as long as its corresponding element is greater than the pivot
    while left_index < right_index && array[right_index] >= pivot
      right_index -= 1
    end
    array[left_index] = array[right_index] if left_index < right_index

    # We move left_index to the right as long as its corresponding element is less than or equal to the pivot
    while left_index < right_index && array[left_index] <= pivot
      left_index += 1
    end
    array[right_index] = array[left_index] if left_index < right_index
  end

  array[right_index] = pivot
  right_index
end

# TEST DRIVE
my_array = [5, 1, -1, 5, 8, 0]

p quick_sort([]) == []
p quick_sort([3]) == [3]
p quick_sort([30, 3]) == [3, 30]
p quick_sort(my_array) == [-1, 0, 1, 5, 5, 8]

