# Problem 1.4, 4th edition: Write a method to decide if two strings are anagrams or not

# SOLUTION1:
# Pseudocode:
# We return false if the 2 input strings have different length
# We split each string into an array, we sort and compare these 2 arrays.

def anagram(string1, string2)
  return false if string1.length != string2.length
  string1.chars.sort == string2.chars.sort
end

# SOLUTION2:
# Pseudocode:
# 1) We return false if the 2 input strings have different length
# 2) We initialize a hash with default value of 0. We go through the 1st input string (string1) and put its characters in the hash
# 3) We loop through the second input string (string2). If we find a character that is not in the hash, we return false since this means that this character is not present in string1. Otherwise we reduce the value of that hash key by 1
# 4) We go through the hash values and if we see a value that is not equal to 0, we return false because this would mean that there is a character (the hash key) in one of the strings that is not present in the other string.

def anagram_2(string1, string2)
  return false if string1.length != string2.length

  hash = Hash.new(0)
  string1.chars.each {|letter| hash[letter] += 1}

  string2.chars.each do |letter|
    return false unless hash.has_key?(letter)
    hash[letter] -= 1
  end

  hash.each_value {|value| return false if value != 0}
  true
end

# Test for anagram1
p anagram("", "") == true
p anagram(" ", " ") == true
p anagram("cinema", "iceman") == true
p anagram("ab", "abc") == false
p anagram("ab", "ac") == false
p anagram("ab", "aa") == false

# Test for anagram2
p anagram_2("", "") == true
p anagram_2(" ", " ") == true
p anagram_2("cinema", "iceman") == true
p anagram_2("ab", "abc") == false
p anagram_2("ab", "ac") == false
p anagram_2("ab", "aa") == false