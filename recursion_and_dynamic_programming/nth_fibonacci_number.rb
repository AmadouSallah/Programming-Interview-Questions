# Write a program to generate the nth Fibonacci number
# Example for n = 6, the program returns 8
# 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, ...

# SOLUTION 1: Using recursion - 0(2^n) running time and 0(1) space
def fibonacci(n)
  if n < 2
    return n
  else
    return fibonacci(n-1) + fibonacci(n-2)
  end
end

# TEST CASES
p fibonacci(0) == 0
p fibonacci(1) == 1
p fibonacci(2) == 1
p fibonacci(10) == 55
# p fibonacci(100) == 2584 # This takes for ever to compute