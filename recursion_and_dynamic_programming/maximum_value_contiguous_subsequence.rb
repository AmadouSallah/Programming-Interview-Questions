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

# TEST DRIVE
p maximum_value_contiguous_subsequence([1, -3, 4, -2, -1, 6]) == 7
p maximum_value_contiguous_subsequence([1, -5, 2, -1, 3]) == 4
p maximum_value_contiguous_subsequence([-2, 11, -4, 13, -5, 2]) == 20