=begin

Problem: Find duplicates in O(n) time and O(1) extra space
Given an array of n elements which contains elements from 1 to n-1, with any of these numbers appearing any number of times. Find the repeating numbers in O(n) and using only constant memory space - 0(1).

For example, let n be 7 and array be [1, 2, 3, 1, 3, 6, 6], the answer should be 1, 3 and 6

=end

def find_duplicates(array)
  found_duplicate = false
  array.each do |element|
    abs_value = element.abs

    if array[abs_value] > 0 # the element has not been seen yet
      array[abs_value] = -array[abs_value]
    elsif array[abs_value] < 0 # this element has already been seen, so it is a duplicate. Therefore we print it
      found_duplicate = true
      print abs_value, " "
    end
  end
puts "\n" if found_duplicate
end

# TEST CASES
find_duplicates([]) # nothing is printed
find_duplicates([1,1]) # 1 is printed
find_duplicates([2, 3, 1, 3, 6,1, 6]) # 1 3 6 is printed
find_duplicates([2, 2, 2]) # 2 2 is printed (duplicate twice)