# Problem: Given an array of numbers (not all negative), write a program to find the
# maximum sum of a subsequence with the constraint that no 3 numbers in the sequence
# should be adjacent in the array
# Answer the question in the most efficient way.

# SOLUTION
# The decision to make is whether to select the ith element (array[i]) or not when computing result[i]
# The restriction is not to select 3 continuous numbers, but we can select 2 elements continuously and skip the 3rd one.
# Case 1: select 2 continuous elements and skip the 3rd one (array[i] + array[i-1] + result[i-3])
# Case 2: select the ith element and skip the i-1 th element (array[i] + result[i-2])
# Case 3: don't select the ith element => solve the problem with i-1 elements
# result[i] is the maximum of all 3 cases above

def maximum_sum_with_no_3_continuous_numbers(array)
  len = array.length
  result = []
  result[0] = array[0]
  result[1] = [array[0], array[1]].max
  result[2] = [array[0], array[1], array[2]].max

  for i in (3...len)
    two_continuous = array[i] + array[i-1] + result[i-3]
    non_two_continuous = array[i] + result[i-2]
    i_not_selected = result[i-1]

    result[i] = [two_continuous, non_two_continuous, i_not_selected].max
  end
  result[len-1]
end

# SOLUTION 2: 0(n) running time and 0(1) space complexities
def maximum_sum_with_no_3_continuous_numbers_2(nums)
  len = nums.length
  x = nums[0]
  y = maximum(x, nums[1])
  z = maximum(x, maximum(y, nums[2]) )

  for i in (3...len)
    a = nums[i] + nums[i-1] + x
    b = nums[i] + y
    c = z

    temp = maximum(a, maximum(b, c))
    x = y
    y = z
    z = temp
  end
  z
end

def maximum(a, b)
  a > b ? a : b
end
# TEST CASE
p maximum_sum_with_no_3_continuous_numbers([1,2,3,8,1,5]) == 17

p maximum_sum_with_no_3_continuous_numbers_2([1,2,3,8,1,5]) == 17