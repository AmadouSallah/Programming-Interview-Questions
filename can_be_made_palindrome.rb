# Write an efficient function that checks whether any permutation of an input string is a palindrome

def can_be_made_palindrome?(string)
  return true if string.length < 2

  hash = Hash.new(0)
  string.chars.each {|key| hash[key] += 1}

  number_of_odd_chars = 0 # will hold the number of keys whose value is odd
  hash.values.each do |value|
    number_of_odd_chars += 1 if value % 2 != 0
    # All the hash keys except one should have an even value for the string to be a palindrome.
    # Therefore we return false whenever number_of_odd_chars is > 1.
    return false if number_of_odd_chars > 1
  end
  # We return true since we didn't find more than 1 character whose hash value is > 1
  true
end

# TEST CASES
p can_be_made_palindrome?("") == true
p can_be_made_palindrome?("a") == true
p can_be_made_palindrome?("mmo") == true
p can_be_made_palindrome?("yakak") == true
p can_be_made_palindrome?("civic") == true
p can_be_made_palindrome?("ivicc") == true
p can_be_made_palindrome?("ab") == false
p can_be_made_palindrome?("travel") == false
