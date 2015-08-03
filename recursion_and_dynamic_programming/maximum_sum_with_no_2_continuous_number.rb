# Problem: Given an array of numbers (not all negative), write a program to find the
# maximum sum of a subsequence with the constraint that no 2 numbers in the sequence
# should be adjacent in the array
# Answer the question in the most efficient way.

# Example:
# [3, 2, 7, 10] should return 13 (sum of 3 and 10);
# [3, 2, 5, 10, 7] should return 15 (sum of 3, 5 and 7).

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

# TEST DRIVE
p maximum_sum_with_no_2_continuous_number([10]) == 10
p maximum_sum_with_no_2_continuous_number([1, -1]) == 1
p maximum_sum_with_no_2_continuous_number([3, 2, 7, 10]) == 13
p maximum_sum_with_no_2_continuous_number([3, 2, 5, 10, 7]) == 15
