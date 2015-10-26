=begin
Given an array of numbers, write a function that segregates even and odd numbers from the array. The function should put all even numbers first and then odd numbers.
The function shouldn't create a new array.
Example: input = [12, 34, 45, 9, 8, 90, 3], output = [12, 34, 90, 8, 9, 45, 3]
In the output, the order of numbers can be changed

=end

=begin
      PSEUDOCODE:
1) We initialize 2 variables, left_index = 0 and right_index = array.length-1
2) We increment left_index until we encounter an odd number.
3) We decrement right_index until we encounter an even number.
4) We swap the array elements at left_index and right_index if left_index < right_index

=end

def separate_even_odd(nums)
  left_index, right_index = 0, nums.length - 1
  while left_index < right_index
    # increment left_index until we encounter an odd number
    while (left_index < right_index) && (nums[left_index] % 2 == 0)
      left_index += 1
    end

    # decrement right_index until we encounter an even number
    while (left_index < right_index) && (nums[right_index] % 2 == 1)
      right_index -= 1
    end

    swap(nums, left_index, right_index) if left_index < right_index
  end

  nums
end

def swap(array, i, j)
  temp = array[i]
  array[i] = array[j]
  array[j] = temp
end

# TEST CASES
p separate_even_odd([]) == []
p separate_even_odd([1]) == [1]
p separate_even_odd([1, 2]) == [2, 1]
p separate_even_odd([12, 34, 45, 9, 8, 90, 3]) == [12, 34, 90, 8, 9, 45, 3]