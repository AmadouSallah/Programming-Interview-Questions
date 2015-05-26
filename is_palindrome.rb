# Problem: Write a code to check is a string is a palindrome or not
# Definition: A palindrome is a word, phrase, or sequence that reads the same backward as forward, e.g., madam.

def is_palindrome?(string)
  return true if string.length < 2
  i = 0
  j = string.length - 1
  while i <= j
    return false if string[i] != string[j]
    i += 1
    j -= 1
  end
  true
end

# TEST DRIVE
p is_palindrome?("") == true
p is_palindrome?("a") == true
p is_palindrome?("ab") == false
p is_palindrome?("madam") == true
p is_palindrome?("nurses run") == false
