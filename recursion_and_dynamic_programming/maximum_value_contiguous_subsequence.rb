# Problem: Given an array of n numbers, determine a contiguous subsequence a[i]...a[j] for which the sum if elements is maximum
# Example:
# input: [1, -3, 4, -2, -1, 6] => output = 7
# input = [1, -5, 2, -1, 3] => output = 4
# input = [-2, 11, -4, 13, -5, 2] => output = 20

# SOLUTION 1: Running time 0(n^2) and space 0(1) complexities
def maximum_value_contiguous_subsequence(array)
  max = 0
  len = array.length

  for i in (0...len)
    current_sum = 0
    for j in (i...len)
      current_sum += array[j]
      max = (current_sum > max) ? current_sum : max
    end
  end
  max
end

# SOLUTION 2: Using Dynamic Programming - 0(n) running time and 0(n) space complexities
def maximum_value_contiguous_subsequence_dp(array)
  len = array.length
  result = []
  # if the 1st array[0] is positive, put it in the result array, otherwise put 0
  result[0] = (array[0] > 0) ? array[0] : 0

  array.each_with_index do |element, index|
    result[index] = (result[index-1] + element > 0) ? (result[index-1] + element) : 0
  end

  max = 0
  result.each do |element|
    max = (max > element) ? max : element
  end

  max
end

# TEST DRIVE
p maximum_value_contiguous_subsequence([1, -3, 4, -2, -1, 6]) == 7
p maximum_value_contiguous_subsequence([1, -5, 2, -1, 3]) == 4
p maximum_value_contiguous_subsequence([-2, 11, -4, 13, -5, 2]) == 20

puts "Solution 2 using Dynamic Programming:"
p maximum_value_contiguous_subsequence_dp([1, -3, 4, -2, -1, 6]) == 7
p maximum_value_contiguous_subsequence_dp([1, -5, 2, -1, 3]) == 4
p maximum_value_contiguous_subsequence_dp([-2, 11, -4, 13, -5, 2]) == 20