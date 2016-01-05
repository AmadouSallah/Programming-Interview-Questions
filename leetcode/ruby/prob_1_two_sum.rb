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

# TEST CASES
two_sum1([2, 7, 11, 15], 9) # index1=1, index2=2
two_sum1([2, 7, 11, 15], 13) # index1=1, index2=3
two_sum1([2, 7, 11, 15], 17) # index1=1, index2=4
two_sum1([2, 7, 11, 15], 18) # index1=2, index2=3
two_sum1([2, 7, 11, 15], 22) # index1=2, index2=4