# Given an array with n numbers. Give an algorithm to find the cumulative sum of the sum of all pairs of numbers. the algorithm should be O(n) time
# Example, for array = [1,2,3,4], the output is (1+2) + (1+3) + (1+4) + (2+3) + (2+4) + (3+4) = 30

# SOLUTION
# We could do this in 0(n^2) with 2 loops:
def sum_of_all_pairs_bad(array)
  sum = 0
  i = 0
  while i < array.length
    j = i + 1
    while j < array.length
      sum += array[i] + array[j]
      j += 1
    end
    i += 1
  end
  sum
end
# But this will give 0(n^2) and that is not what is asked. We need to do it in 0(n)

def sum_of_all_pairs(array)
  len = array.length
  sum = 0
  array.each do |element|
    sum += element * (len - 1)
  end
  sum
end

p sum_of_all_pairs([]) == 0
p sum_of_all_pairs([1, 3]) == 4
p sum_of_all_pairs([1,2,3,4]) == 30