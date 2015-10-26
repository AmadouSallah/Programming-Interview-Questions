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