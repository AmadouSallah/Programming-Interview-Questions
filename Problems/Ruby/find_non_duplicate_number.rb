# Given an array that contains many duplicates integers and one unique integer, write a program to find and return the unique integer.
# Example, for input = [1, 4, 1, 7, 4], the output will be 7

# SOLUTION 1: Brute force 0(n^2) running time and 0(1) space
# For each array element, we go through the array starting from the following element to see if there is another identical element.
# If no identical element is found (meaning it is the unique one), we return that element.
def find_non_duplicate_integer_1(array)
  len = array.length
  i = 0
  while i < len
    element = array[i]
    found_duplicate = false

    # For each element, we loop through all the array elements, except array[i], to see if there is a duplicate
    j = 0
    while j < len
      j += 1 if i == j # skip so that we don't consider the same element twice

      # break out of this inner loop if we find a duplicate element
      if array[j] == element
        found_duplicate = true
        break
      end
      j += 1
    end

    # if no duplicate is found, return element
    return element if !found_duplicate
    i += 1
  end
  array[i]
end

# SOLUTION 2: Using a hash table - 0(n) running time and 0(n) space
def find_non_duplicate_integer_2(array)
  hash = Hash.new(0)
  array.each do |elt|
    hash[elt] += 1
  end

  # return the hash key with a value of 1
  hash.each {|key, value| return key if value == 1}
end

# SOLUTION 3: Using XOR - 0(n) running time and 0(1) space
# We know that if a and b are integers, a^b = 1 if a and b are different, otherwise a^b = 0
# We initially set result to zero. We then XOR it with every array element and returns the result of xoring.
# This will gives the non duplicate integer
# Example 0^1^2^1^3^2 = 0^(1^1)^(2^2)^3 = 0^(0^0)^3 = 0^0^3 = 0^3 = 3 therefore 3 is the non duplicate
def find_non_duplicate_integer_3(array)
  result = 0
  array.each {|element| result ^= element}
  result
end

# TEST DRIVE

puts "Testing Solution 1:"
p find_non_duplicate_integer_1([7]) == 7
p find_non_duplicate_integer_1([7, 1, 4, 1, 4]) == 7
p find_non_duplicate_integer_1([1, 4, 3, 1, 4]) == 3
p find_non_duplicate_integer_1([1, 4, 1, 4, 0]) == 0

puts "\nTesting solution 2:"
p find_non_duplicate_integer_2([7]) == 7
p find_non_duplicate_integer_2([7, 1, 4, 1, 4]) == 7
p find_non_duplicate_integer_2([1, 4, 3, 1, 4]) == 3
p find_non_duplicate_integer_2([1, 4, 1, 4, 0]) == 0

puts "\nTesting solution 3:"
p find_non_duplicate_integer_3([7]) == 7
p find_non_duplicate_integer_3([7, 1, 4, 1, 4]) == 7
p find_non_duplicate_integer_3([1, 4, 3, 1, 4]) == 3
p find_non_duplicate_integer_3([1, 4, 1, 4, 0]) == 0