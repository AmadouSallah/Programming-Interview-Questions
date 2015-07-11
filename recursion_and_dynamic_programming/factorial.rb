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

# TEST CASES
p factorial_recursive(10) == 3628800
# p factorial_recursive(1000000) # Stactk too deep :(