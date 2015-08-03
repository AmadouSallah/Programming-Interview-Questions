# Problem: Given an array of n numbers, determine a contiguous subsequence a[i]...a[j] for which the sum of elements is maximum
# Example:
# input: [1, -3, 4, -2, -1, 6] => output = 7
# input = [1, -5, 2, -1, 3] => output = 4
# input = [-2, 11, -4, 13, -5, 2] => output = 20

# SOLUTION 1: Running time 0(n^2) and space 0(1) complexities
def maximum_value_contiguous_subsequence(array)
  len = array.length
  return array.max if all_negatives?(array)

  max = array[0]
  for i in (0...len)
    current_sum = 0
    for j in (i...len)
      current_sum += array[j]
      max = maximum(max, current_sum)
    end
  end
  max
end

# SOLUTION 2: Using Dynamic Programming - 0(n) running time and 0(n) space complexities
def maximum_value_contiguous_subsequence_dp(array)
  len = array.length
  result = [array[0]]

  for i in (1...len)
    result[i] = maximum(array[i], array[i] + result[-1])
  end

  result.max
end

# SOLUTION 3: 0(n) running time and 0(1) space
def maximum_value_contiguous_subsequence_3(array)
  len = array.length
  max_sum, current_sum = 0, 0

  for i in (0...len)
    current_sum = (current_sum + array[i] > 0) ? current_sum + array[i] : 0

    max_sum =  (current_sum > max_sum) ? current_sum : max_sum
  end
  max_sum
end

def maximum(a, b)
  a > b ? a : b
end

# Returns true if all the elements of the input array are negative and false otherwise
def all_negatives?(nums)
  nums.each { |element| return false if element >= 0 }
  true
end

# TEST DRIVE
puts "Solution 1: 0(n^2) running time and 0(1) space complexities"
p maximum_value_contiguous_subsequence([-4, -3, -7, -1, -2]) == -1
p maximum_value_contiguous_subsequence([1, -3, 4, -2, -1, 6]) == 7
p maximum_value_contiguous_subsequence([1, -5, 2, -1, 3]) == 4
p maximum_value_contiguous_subsequence([-2, 11, -4, 13, -5, 2]) == 20

puts "Solution 2 using Dynamic Programming: 0(n) running time and 0(n) space complexities"
p maximum_value_contiguous_subsequence([-4, -3, -7, -1, -2]) == -1
p maximum_value_contiguous_subsequence_dp([1, -3, 4, -2, -1, 6]) == 7
p maximum_value_contiguous_subsequence_dp([1, -5, 2, -1, 3]) == 4
p maximum_value_contiguous_subsequence_dp([-2, 11, -4, 13, -5, 2]) == 20

puts "Solution 3: 0(n) running time and 0(1) space complexities"
p maximum_value_contiguous_subsequence_3([1, -3, 4, -2, -1, 6]) == 7
p maximum_value_contiguous_subsequence_3([1, -5, 2, -1, 3]) == 4
p maximum_value_contiguous_subsequence_3([-2, 11, -4, 13, -5, 2]) == 20
