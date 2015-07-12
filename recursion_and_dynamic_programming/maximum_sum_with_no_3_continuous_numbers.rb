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
