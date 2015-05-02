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

# TEST DRIVE:
array = [-8, -3, -1, 0, 1, 4, 5, 9]
p square_sorted_array([]) == []
p square_sorted_array([-2]) == [4]
p square_sorted_array(array) == [0, 1, 1, 9, 16, 25, 64, 81]