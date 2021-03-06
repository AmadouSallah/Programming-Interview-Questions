# This is problem 1.3 from the 4th edition of Cracking the Coding Interview:

# Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer
# NOTE: One or two additional variables are fine An extra copy of the array is not

# PSEUDOCODE
# 0) We return the input string if its lenth is less than 2 (no duplicates in this case)
# 1) We define a varialbe "tail" to represent the boundary to the left of which there is no duplicates (initially at position 1)
# 2) We make an outer loop going from position 1 to the end of the input string.
# a) For each i of the outer loop, we start an inner loop whose counter j goes from 0 to tail-1 at most. If we find a duplicate to string[i], we break from this loop.
# b) After this inner loop, we know that a duplicate is not found when j == tail. In that case, we copy the value of string[i] to string[tail] and increment tail by 1 (now string[i] is part of the non duplicate characters, i.e. to the left of tail)
# 3) At the end of the outer loop, we return the non duplicate characters, that is the characters from 0 to tail

def remove_duplicates(string)
  return string if string.length < 2

  tail = 1

  i = 1
  while i < string.length

    # For each i, the inner loop below goes from 0 to tail-1 (at most). If we find a duplicate to string[i], we break from this inner loop.
    j = 0
    while j < tail
      break if string[j] == string[i]
      j += 1
    end

    # A duplicate is not found when j == tail, i.e. no duplicate from 0 to tail. We then copy string[i] to string[tail] and we increment tail by 1
    if j == tail # A duplicate was not found
      string[tail] = string[i] # we add string[i] to the characters with no duplicate
      tail += 1 # We increment tail to make sure that string[i] is part of the non duplicates chars
    end

    i += 1
  end
  # We return the substring from 0 to tail since it represents the non duplicate characters
  string.slice(0, tail)
end

# SOLUTION 2: Using additional memory
# PSEUDOCODE:
# 0) We return the string if string.lenth is less than 2 (no duplicates in this case)
# 1) We initialize an empty array, no_duplicates
# 2) We iterate through all the characters of the input string, and we put each of them in the no_duplicates array as long as the array doesn't contain the character.
# 3) Once we are done looping through the input string, we join the no_duplicates array and return the joined string.

def remove_duplicates_2(string)
  return string if string.length < 2
  no_duplicates = []
  string.chars.each do |letter|
    no_duplicates << letter unless no_duplicates.include?(letter)
  end
  no_duplicates.join()
end

# TEST Cases
p remove_duplicates("") == ""
p remove_duplicates(" ") == " "
p remove_duplicates("a") == "a"
p remove_duplicates("aaa") == "a"
p remove_duplicates("abababa") == "ab"
p remove_duplicates("aaabbb") == "ab"
p remove_duplicates("abcd") == "abcd"

p remove_duplicates_2("") == ""
p remove_duplicates_2(" ") == " "
p remove_duplicates_2("a") == "a"
p remove_duplicates_2("aaa") == "a"
p remove_duplicates_2("abababa") == "ab"
p remove_duplicates_2("aaabbb") == "ab"
p remove_duplicates_2("abcd") == "abcd"