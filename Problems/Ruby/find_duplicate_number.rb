=begin

Suppose you have an array of n+1 integers. The integers are in random order, but you know each of the integers is between 1 and n (inclusive). In addition, each number appears only once in the array, except for one number, which occurs twice. Describe an algorithm to find the repeated number in the most efficient way, that is in
0(n) time and 0(1) space.

=end

# PSEUDOCODE:
# We initialize result to 0. We then xor all the array elements
# with the indexes from 0 to n (there are n+1 elements) and put it to result.
# This would result to the duplicate element since it is the only
# element that ends up being xor'ed 3 times. All the other elements
# get xor'ed twice, which is 0. We return result

# Example, if array = [1, 4, 2, 1, 3], we get:
# result = 0^(1^0)^(4^1)^(2^2)^(1^3)^(3^4)
#        = (1^1^1)^(2^2)^(3^3)^(4^4) = 1

def find_duplicate(nums)
  result = 0
  nums.each_with_index do |num, index|
    result ^= num ^ index
  end
  result
end

# TEST CASE
p find_duplicate([1,4,2,1,3]) == 1
p find_duplicate([5, 2, 1, 2, 3, 4]) == 2