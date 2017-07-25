# Write a program to return all the duplicate numbers from an array of non negative numbers.
# Example, for array = [1,3,2,1,2,9,7,9], the output is [1,2,9]

# SOLUTION 1: Brute force - 0(n^2) running time and 0(n) space
def find_duplicate_numbers(array)
  result = []
  len = array.length

  i = 0
  while i < len
    element = array[i]

    j = i + 1
    while j < len
      result << element if element == array[j]
      j += 1
    end

    i += 1
  end
  result
end

# SOLUTION 2
def find_duplicate_numbers_2(array)
  result = []

  # Find the largest value in array
  max = array[0]
  array.each {|elt| max = elt if elt > max}

  # Create a boolean array of length max whose values are all initially set to false
  boolean = Array.new(max) {false}

  i = 0
  while i < array.length
    element = array[i]
    if boolean[element] && !result.include?(element)
      result << element
    else
      boolean[element] = true
    end
    i += 1
  end
  result
end

# TEST DRIVE

puts "Testing brute force solution:"
p find_duplicate_numbers([1,3,2,1,2,9,7,9]) == [1, 2, 9]
p find_duplicate_numbers([1,2,3]) == []
p find_duplicate_numbers([0, 0, 1]) == [0]
p find_duplicate_numbers([25]) == []

puts "\nTesting the second, more efficient solution:"
p find_duplicate_numbers_2([1,3,2,1,2,9,7,9]) == [1, 2, 9]
p find_duplicate_numbers_2([1,2,3]) == []
p find_duplicate_numbers_2([0, 0, 1]) == [0]
p find_duplicate_numbers_2([8]) == []