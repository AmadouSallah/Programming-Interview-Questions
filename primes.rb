# Problem: Write a program to generate all prime numbers up to a number (we assume number > 1)
# Example, generate_primes_upto(11) would return [2,3,5,7,11]

# SOLUTION
# PSEUDOCODE
# We define an array @primes = [2,3] containing the 1st two primes number, i.e 2, and 3. This array will contain all the prime numbers up to the input number
# We check to see if the input number is in @primes, if so we return true
# Otherwise, we loop from (2 + the last element of @primes) all the way to the input number; whenever we encounter an integer
# that is prime (we will define a function to check that), we add it to @primes. Once we are done, iterating, we return @primes.

# We define is_prime? which will check to see if a number is prime or not.
# We return false if the number is < 2
# We iterate from 2 upto the square root of number (included). If we incounter an integer for which the input
# is divisibe by, we return false.
# Otherwise we return true

@primes = [2,3]

def generate_primes_upto(number)
  return @primes.select {|prime| prime <= number} if number <= @primes.last
  i = @primes.last + 2
  while i <= number
    @primes << i if is_prime?(i)
    i += 2
  end
  @primes
end

def is_prime?(number)
  return false if number < 2
  i = 2
  while i <= Math.sqrt(number) # See below why we stop at square root of number
    return false if number % i == 0
    i += 1
  end
  true
end

# if a number n = a*b and 1 < a <= b, then a^2 <= ab <= b^2
# therefore a^2 <=n <= b^2, then a <=sqrt(n) <= b
# there has to be a prime factor till sqrt(n) if n is composite. if there is no prime factor till sqrt(n), n is itself a prime.


# TEST DRIVE
p generate_primes_upto(0) == []
p generate_primes_upto(1) == []
p generate_primes_upto(3) == [2, 3]
p generate_primes_upto(4) == [2, 3]
p generate_primes_upto(100) == [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]