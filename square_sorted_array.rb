# Problem:
# Given a sorted array, how would you square each element of this array, while keeping it sorted?
# Example array = [-8, -3, -1, 0, 1, 4, 5, 9] => [0, 1, 1, 9, 16, 25, 64, 81]

# Solution 1
# Pseudocode: We square each element of the array, we then sort the array and return it.

def square_sorted_array(array)
  squared_array = []
  array.each {|element| squared_array << element * element}
  squared_array.sort
end

# Solution 2
#Pseudocode:
# 1) We define a new empty array, squred_array that will be returned
# 2) Since the array is sorted, we loop through it once each time comparing the absolute value of the first and last elements.
# 3) Whichever is larger, we square it and put it in squared_array: we start adding from position length -1 down to 0; this will ensure that squared_array is sorted
# 4) We repeat 2) and 3) by increasing the front index or decreasing the last index depending on the largest element from 3).
# Here we are doing the sort and square in one loop

def square_sorted_array_2(array)
  return array if array.length == 0
  squared_array = []
  left_index = 0
  right_index = array.length - 1

  while left_index <= right_index
    if array[left_index].abs < array[right_index].abs
      squared_array[right_index - left_index] = array[right_index] * array[right_index]
      right_index -= 1
    else
      squared_array[right_index - left_index] = array[left_index] * array[left_index]
      left_index += 1
    end
  end
    squared_array
end

# TEST DRIVE:
array = [-8, -3, -1, 0, 1, 4, 5, 9]

p square_sorted_array([]) == []
p square_sorted_array([-2]) == [4]
p square_sorted_array(array) == [0, 1, 1, 9, 16, 25, 64, 81]

p square_sorted_array_2([]) == []
p square_sorted_array_2([-2]) == [4]
p square_sorted_array_2(array) == [0, 1, 1, 9, 16, 25, 64, 81]