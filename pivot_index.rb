# Problem: Write a method that returns the "pivot" index of a list of integers.
# We define the pivot index as the index where the sum of the numbers on the left is equal to the sum of the numbers on the right.
# Example: Given [1, 4, 6, 3, 2], the method should return 2, since the sum of the numbers to the left of index 2 is equal to the sum of numbers to the right of index 2 (1 + 4 = 3 + 2).
# If no such index exists, it should return -1. If there are multiple pivots, you can return the left-most pivot.

def pivot_index(array)
  array.each_index do |index|
    return index if array[0...index].inject(:+) == array[index+1...array.length].inject(:+)
  end
end
# This is 0(n^2)

def pivot_index_2(array)
  array_sum = array.inject(:+)
  left_sum = 0
  array.each_with_index do |element, index|
    # index is the pivot when the sum to the left = sum to the right = left_sum
    return index if array_sum == (left_sum + element + left_sum)
      left_sum += element
  end
end
# This is 0(n)

# TEST DRIVE
array = [1,3,2,7,4,2]
p pivot_index(array) == 3
p pivot_index([1, 4, 6, 3, 2]) == 2

p pivot_index_2(array) == 3
p pivot_index_2([1, 4, 6, 3, 2]) == 2