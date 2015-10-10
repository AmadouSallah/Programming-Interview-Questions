# Problem: Given an array of numbers (not all negative), write a program to find the
# maximum sum of a subsequence with the constraint that no 2 numbers in the sequence
# should be adjacent in the array
# Answer the question in the most efficient way.

# Example:
# [3, 2, 7, 10] should return 13 (sum of 3 and 10);
# [3, 2, 5, 10, 7] should return 15 (sum of 3, 5 and 7).

# SOLUTION 1: Using Dynamic Programming - 0(n) running time and 0(N) space complexities
def maximum_sum_with_no_2_continuous_number(array)
  len = array.length
  return array[0] if len < 2
  result = []
  result[0] = array[0]
  result[1] = (array[0] > array[1]) ? array[0] : array[1]

  for i in (2...len)
    result[i] = (result[i-2] + array[i] > result[i-1]) ? result[i-2] + array[i] : result[i-1]
  end
  result[len-1]
end

# SOLUTION 2: 0(n) running time and 0(1) space complexities
def maximum_sum_with_no_2_continuous_number_2(nums)
  len = nums.length
  return nums[0] if len < 2

  max1 = nums[0]
  max2 = maximum(nums[0], nums[1])

  for i in (2...len)
    temp = maximum(max1 + nums[i], max2)
    max1 = max2
    max2 = temp
  end
  max2
end

def maximum(a, b)
  a > b ? a : b
end


# TEST DRIVE
puts "Testing Solution 1 - 0(n) running time and 0(n) space complexities"
p maximum_sum_with_no_2_continuous_number([10]) == 10
p maximum_sum_with_no_2_continuous_number([1, -1]) == 1
p maximum_sum_with_no_2_continuous_number([3, 2, 7, 10]) == 13
p maximum_sum_with_no_2_continuous_number([3, 2, 5, 10, 7]) == 15

puts "Testing Solution 2 - 0(n) running time and 0(1) space complexities"
p maximum_sum_with_no_2_continuous_number_2([10]) == 10
p maximum_sum_with_no_2_continuous_number_2([1, -1]) == 1
p maximum_sum_with_no_2_continuous_number_2([3, 2, 7, 10]) == 13
p maximum_sum_with_no_2_continuous_number_2([3, 2, 5, 10, 7]) == 15