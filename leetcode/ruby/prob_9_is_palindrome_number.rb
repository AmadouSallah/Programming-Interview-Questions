def is_palindrome_number(num)
  return false if num < 0
  return true if num < 10 # case for num between 0 and 9

  reverse_num = 0
  temp_value = num
  while (temp_value > 0)
    reverse_num = reverse_num * 10 + temp_value % 10
    temp_value /= 10
  end
  reverse_num == num
end

# TEST CASES
p is_palindrome_number(-1) == false
p is_palindrome_number(0) == true
p is_palindrome_number(12) == false
p is_palindrome_number(123) == false
p is_palindrome_number(11) == true
p is_palindrome_number(121) == true
p is_palindrome_number(12321) == true
