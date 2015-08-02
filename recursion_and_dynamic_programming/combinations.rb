# Write a program that takes in a string and prints all the possible combinations of the characters in the input string

# PSEUDOCODE:

# For each letter in input string:
#   Append the letter to the output string
#   Print the output
#   Generate remaining combinations starting at next position (recursion)
#   Delete the last character of the output string

def combinations(string)
  combine(string, "", 0)
end

def combine(string, output, start_index)
  i = start_index
  while i < string.length
    output << string[i]
    puts output

    combine(string, output, i + 1)
    output.chop!

    i += 1
  end
end

# TEST DRIVE
puts "The combinations of 'a' is:"
combinations("a")

puts "\nThe combinations of 'abc' are:"
combinations("abc")