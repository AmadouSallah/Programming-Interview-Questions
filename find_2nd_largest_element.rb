# Write a program to find the second largest element in an unsorted array
# Example, for input [1, -4, 3, 7, 9, 0], the output should be7

# SOLUTION 1: Using the built in sort method - 0(nlogn) running time and 0(1) space
def find_2nd_largest_element(array)
  sorted = array.sort # sorts array in ascending order
  sorted[-2] # returns the 2nd to last element
end


# TEST CASE:
p find_2nd_largest_element([1, -4, 3, 7, 9, 0]) == 7
p find_2nd_largest_element([]) == nil
p find_2nd_largest_element([1]) == nil
p find_2nd_largest_element([1, 1]) == 1

