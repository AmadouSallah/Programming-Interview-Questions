=begin

Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers
(both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

=end

# SOLUTION 1: 0(n^2) running time and 0(1) space

# Pseudocode:
# We go through the input array from the begining. For each array element, we go through the
# rest of the array elements to see if there is an element whose sum with the current element
# adds up to the target. If so, these 2 elements are the ones we are looking for.
# We then print each of their indexes + 1 (since it's not zero based, we add 1 to each index).

def two_sum1(numbers, target)
  len = numbers.length

  i = 0
  while i < len
    first_element = numbers[i]
    j = i+1
    while j < len
      second_element = numbers[j]
      if first_element + second_element == target
        puts "index1=#{i+1}, index2=#{j+1}"
        return
      end
      j +=1
    end
    i +=1
  end
end

# SOLUTION 2: 0(n) running time and 0(n) space complexities

# Pseudocode:
# We initialize an empty hash.
# We go through the array (numbers) once. For each element, we set 2 variables, num1 &  num2:
# num1 represent the difference between "target" and the current element whereas num2 represent the
# current element. The hash will have as key-value pairs num1 => num2; i.e. for each
# num1 and num2, hash[num1] = num2.
# As we traverse the array, for each element, we check if key num2 alreay exists in the hash.
# If so, that would signal that we have found the second element that we are looking for
# and that the 1st element is just num1 since num1 +  num2 = target. We then print the indexes and return.
# Otherwise (key num2 is not in the hash), we set the hash value of num1 to be num2

def two_sum2(numbers, target)
  len = numbers.length
  my_hash = {}

  i = 0
  while i < len
    num2 = numbers[i]
    num1 = target - num2

    if my_hash[num2] # A match is found since num1 + num2 = target
      index1 = numbers.index(num1) + 1
      index2 = i + 1
      puts "index1=#{index1}, index2=#{index2}"
      return
    else
      my_hash[num1] = num2
    end
    i += 1
  end
end

# TEST CASES
two_sum1([2, 7, 11, 15], 9) # index1=1, index2=2
two_sum1([2, 7, 11, 15], 13) # index1=1, index2=3
two_sum1([2, 7, 11, 15], 17) # index1=1, index2=4
two_sum1([2, 7, 11, 15], 18) # index1=2, index2=3
two_sum1([2, 7, 11, 15], 22) # index1=2, index2=4
puts
two_sum2([2, 7, 11, 15], 9) # index1=1, index2=2
two_sum2([2, 7, 11, 15], 13) # index1=1, index2=3
two_sum2([2, 7, 11, 15], 17) # index1=1, index2=4
two_sum2([2, 7, 11, 15], 18) # index1=2, index2=3
two_sum2([2, 7, 11, 15], 22) # index1=2, index2=4