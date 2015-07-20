# Problem: Given a sequence of numbers, write a program to find a subsequence (not necessarily contiguous)
# whose elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible.

# Example:
# nums = [3, 4, -1, 0, 6, 2, 3] => output = [-1, 0, 2,3]
# nums = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15] => output = [0, 2, 6, 9, 11, 15]

# returns the length of the longest increasing subsequence
def longest_increasing_subsequence(nums)
  len = nums.length
  return len if len < 2

# After calculating lis for each index, take a max by 1 value equal to max, go backwards on lis array, and every time we find an element equal to max, we add that element to result and decrement max by 1. Hereby we'll get the indexes array in reversed order.
  lis_array = find_lis_lengths(nums)

  result = []
  max = lis_array[-1]
  i = len - 1
  while i >= 0
    if lis_array[i] == max
      result.unshift(nums[i])
      max -= 1
    end
    i-= 1
  end
  result

end

def find_lis_lengths(nums)
  len = nums.length
  lis_array = Array.new(len) {1} # initialize to 1 since at least the longest increasing subsequence has 1 element

  for i in (1...len)
    for j in (0...i)
      if nums[i] > nums[j] && lis_array[j] + 1 > lis_array[i]
        lis_array[i] = lis_array[j] + 1
      end
    end
  end
  lis_array
end

nums1 = [3, 4, -1, 0, 6, 2, 3]
nums2 = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]

p longest_increasing_subsequence(nums1) == [-1, 0, 2, 3]
p longest_increasing_subsequence(nums2) == [0, 2, 6, 9, 11, 15]

