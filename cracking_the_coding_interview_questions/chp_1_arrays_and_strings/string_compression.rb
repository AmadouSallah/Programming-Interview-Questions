# Problem 1.5, 5th edition
# Impement a method to perform basic string compression using the counts of repeated characters.
# For example, 'aabcccccaaa' would become 'a2b1c5a3'.
# If the 'compressed' string would not become smaller than the original string, your method should return the original string.

# PSEUDOCODE:
# 1) If the length of the input string is < 2, we return it since this would make the compressed string larger than the input string.
# 2) We initiate an empty string, compressed.
# 3) We loop through the input string.
#    a) We initiate a counter that keeps track of the number of times a character is repeated consecutively
#    b) In a new loop, we increment counter as long as the current character is the same as the next one.
#    c) Once we are done through the inner loop, we append to 'compressed' the current character + counter (as a string)
# 4) We return compressed at the end of the outer loop.


def compress(string)
  return string if string.length < 2
  compressed = ""

  i = 0
  while i < string.length

    counter = 1 # counter counts the number of repeated characters string[i]
    until string[i] != string[i+counter]
      counter += 1 # increments it as long as the current and next characters are identical
    end

    # we append to 'compressed' the current character + the counts of its repetition
    compressed << string[i] + counter.to_s
    i += counter # the looping goes to the next non repeated character
  end

  compressed
end

# TEST
p compress("") == ""
p compress(" ") == " "
p compress("a") == "a" # input string 'a' is smaller thatn the compressed string 'a1', so input string is returnded
p compress("aabcccccaaa") == "a2b1c5a3"
