# Question: Given two strings, write a method to decide if one is a permutation of the other.

# Pseudocode:
# Let's assume that the comparison is case sensitive, that is permutation?('abc', 'bAc') would return false.
# 1) If the 2 strings, say s and t, have different lengths, we return false since 2 strings must have the same length in order for them to be permutations of one another.
# We will solve the problem in 2 different ways.

# SOLUTION 1:
# a) We initialize a hash with default value of 0.
# b) We loop through the first string adding each character in the hash; the hash key represent the string character whereas the hash value represent the number of times this character is present in the string
# c) Next, we loop through the second string.
# We return false if we encounter a character that is not in the hash: For each character in the 2nd string, we reduce the corresponding hash value by 1 (if the character is not in the string, hash[character] = 0 initially) and we immediately return false if hash[character] < 0 (hash[char] = 0 )
# d) At this point, all the values of the hash should be 0. So we loop through the hash and if we find a value > 0, we return false
# e) We return true at the end since this means we haven't encountered a case that would make it false.

# SOLUTION 2:
# For each of the string inputs, we separate the characters and put them in an array that we sort. We then compare these 2 arrays; we return true if they are the same, otherwise false.

def permutation?(string_1, string_2)
  # return false if string_1.length != string_2.length

  hash = Hash.new(0)

  string_1.split("").each {|letter| hash[letter] += 1}

  string_2.split("").each do |char|
    hash[char] -= 1
    return false if hash[char] < 0
  end

  hash.each_value {|value| return false if value != 0}
  true
end


def permutation_2?(string_1, string_2)
  return false if string_1.length != string_2.length
  string_1.chars.sort == string_2.chars.sort
end

### TESTING
p permutation?("", " ") == false
p permutation?("abc", "cAb") == false
p permutation?("bac", "cab") == true
p permutation?("hello hi", "ih olleh") == true

p permutation_2?("", " ") == false
p permutation_2?("abc", "cAb") == false
p permutation_2?("bac", "cab") == true
p permutation_2?("hello hi", "ih olleh") == true