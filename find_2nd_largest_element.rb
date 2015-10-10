# Write a program to find the second largest element in an unsorted array
# Example, for input [1, -4, 3, 7, 9, 0], the output should be7

# SOLUTION 1: Using the built in sort method - 0(nlogn) running time and 0(n) space
def find_2nd_largest_element(array)
  sorted = array.sort # sorts array in ascending order
  sorted[-2] # returns the 2nd to last element
end

# SOLUTION 2: 0(n) running time and 0(1) space complexities
def find_2nd_largest_element_2(array)
  len = array.length
  return nil if len < 2

  largest, second_largest = array[0], array[0]
  array.each do |element|
    if element > largest
      second_largest = largest
      largest = element
    elsif element > second_largest
      second_largest = element
    end
  end

  second_largest
end

# TEST CASE:
puts "Testing Solution 1:"
p find_2nd_largest_element([1, -4, 3, 7, 9, 0]) == 7
p find_2nd_largest_element([]) == nil
p find_2nd_largest_element([1]) == nil
p find_2nd_largest_element([1, 1]) == 1

puts "\nTesting Solution 2:"
p find_2nd_largest_element_2([1, -4, 3, 7, 9, 0]) == 7
p find_2nd_largest_element_2([]) == nil
p find_2nd_largest_element_2([1]) == nil
p find_2nd_largest_element_2([1, 1]) == 1
