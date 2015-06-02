# Problem: given n, find the number of different ways to write n as the sum of 1, 3, 4
# Example: for n = 5, the answer is 6:
# 5 = 1 + 1 + 1 + 1 + 1 = 1 + 1 + 3 = 1 + 3 + 1 = 3 + 1 + 1 = 1 + 4 = 4 + 1

# Find the recurrence
# – Consider one possible solution n = x1 + x2 + · · · + xm
# – If xm = 1, the rest of the terms must sum to n − 1. Thus, the number of sums that end with xm = 1 is equal to Dn−1
# – Take other cases into account (xm = 3, xm = 4)
# Recurrence is then: Dn = Dn−1 + Dn−3 + Dn−4

# I Solve the base cases
# – D0 = 1 (0 = 0*1 + 0*3 + 0*4)
# – Dn = 0 for all negative n
# – Alternatively, can set: D0 = D1 = D2 = 1, and D3 = 2 (0 = 0*1 + 0*3 + 0*4, 1=1, 2 = 1+1, 3 = 1+1+1 = 0*1 + 3 + 0*4)
# For all n >= 4, Dn = Dn-1 + Dn-3 + Dn-4

def number_of_ways_to_write(number)
  # Base case: result_array[0] = result_array[1] = result_array[2] = 1 and result_array[3] = 2
  result_array = [1, 1, 1, 2]
  return result_array[number] if number <= 3

  i = 4
  while i <= number
    result_array << result_array[i-1] + result_array[i-3] + result_array[i-4]
    i += 1
  end
  result_array[number]
end

p number_of_ways_to_write(0) == 1
p number_of_ways_to_write(1) == 1
p number_of_ways_to_write(5) == 6
p number_of_ways_to_write(10) == 64