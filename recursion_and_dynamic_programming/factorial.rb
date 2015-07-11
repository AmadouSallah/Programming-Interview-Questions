# Write a program that takes an integer n, and returns its factorial value
# 0! = 1
# 1! = 1
# n! = n*(n-1)! for all n > 0

# SOLUTION 1: recursion - 0(n) running time and 0(n) space complexity
def factorial_recursive(n)
  return nil if n < 0

  if n < 2 # Base case
    return n
  else # Recursive case
    return n * factorial_recursive(n-1)
  end

end

# SOLUTION 2: Dynamic Programming - 0(n) running time and 0(n) space
def factorial_dp(n)
  dp_array = [1, 1] # the factorial of both 0 and 1 are 1
  i = 2
  while i <= n
    dp_array[i] = i * dp_array[i-1]
    i += 1
  end
  dp_array[n]
end

# TEST CASES
p factorial_recursive(10) == 3628800
# p factorial_recursive(1000000) # Stactk too deep :(

p factorial_dp(10) == 3628800
