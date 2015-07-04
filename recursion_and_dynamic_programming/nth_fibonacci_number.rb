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

# SOLUTION 2: Using Dynamic Programming - 0(n) running time and 0(n) space
def fibonacci_dp(n)
  result = [0, 1] # the first 2 elements of the fibonacci sequence are 0, and 1.

  i = 2
  while i <= n
    result[i] = result[i-1] + result[i-2]
    i += 1
  end
  result[n]
end

# SOLUTION 3: 0(n) time and 0(1) space
def fibonacci_3(n)
  a, b, = 0, 1
  c = a + b
  return a if n == 0

  i = 2
  while i <= n
    c = a + b
    a = b
    b = c

    i += 1
  end
  c
end

# TEST CASES

puts "Test case using Recursion:"
p fibonacci(0) == 0
p fibonacci(1) == 1
p fibonacci(2) == 1
p fibonacci(10) == 55
# p fibonacci(100) == 354224848179261915075 # This takes for ever to compute

puts "Test case using Dynamic Programming:"
p fibonacci_dp(0) == 0
p fibonacci_dp(1) == 1
p fibonacci_dp(2) == 1
p fibonacci_dp(10) == 55
p fibonacci_dp(100) == 354224848179261915075 # this one runs fast whereas in the recursive case, it takes forever

puts "Test case using more efficient solution:"
p fibonacci_3(0) == 0
p fibonacci_3(1) == 1
p fibonacci_3(2) == 1
p fibonacci_3(10) == 55
p fibonacci_3(100) == 354224848179261915075