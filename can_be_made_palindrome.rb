# Write an efficient function that checks whether any permutation of an input string is a palindrome

def can_be_made_palindrome?(string)
  return true if string.length < 2

  hash = Hash.new(0)
  string.chars.each {|key| hash[key] += 1}

  number_of_odd_chars = 0
  hash.values.each do |value|
    number_of_odd_chars += 1 if value % 2 != 0
    return false if number_of_odd_chars > 1
  end
  true
end

