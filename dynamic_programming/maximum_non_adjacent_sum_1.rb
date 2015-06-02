# Problem: Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array.
# Example [3, 2, 7, 10] should return 13 (sum of 3 and 10);  [3, 2, 5, 10, 7] should return 15 (sum of 3, 5 and 7).
# Answer the question in most efficient way.

# SOLUTION
# Let's solve the problem using Dynamic Programming:
# Let sum be an array such that for all i between 0 and n-1 (where n is the lenght of the input array),
# sum[i] represent the maximum sum of non-consecutive elements from array[0] to array[i].
# Therefore, we have: sum[0] = array[0], sum[1] = max(sum[0], array[1]), and
# for all i >=2, sum[i] = max(sum[i-1], array[i] + sum[i-2])
# We return the last element of sum, i.e sum[n-1]

def max_non_adjacent_sum(array)
  len = array.length # the problem assumes len >= 1
  return array[0] if len == 1
  sum = []
  sum[0] = array[0]
  sum[1] = max(sum[0], array[1])

  i = 2
  while i < len
    sum[i] = max(sum[i-1], array[i] + sum[i-2])
    i += 1
  end

  sum[len - 1]
end

def max(a, b)
  a > b ? a : b
end

# TEST DRIVE
p max_non_adjacent_sum([10]) == 10
p max_non_adjacent_sum([1, -1]) == 1
p max_non_adjacent_sum([3, 2, 7, 10]) == 13
<<<<<<< HEAD
p max_non_adjacent_sum([3, 2, 5, 10, 7]) == 15
=======
p max_non_adjacent_sum([3, 2, 5, 10, 7]) == 15
>>>>>>> 49777c8f5e1ad61ec4d9f25f01fc8c8703e4d2f5
