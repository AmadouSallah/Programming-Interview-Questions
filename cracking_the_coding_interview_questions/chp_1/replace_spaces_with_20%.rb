# Problem 1.4, 5th ed.
# Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end of the string to hold the additional characters and that you are given the "true"  lenth of the string.

# Example Input : "Hi my   friend " Output: "Hi%20my%20friend"

# Solution 1
# Pseudocode
# We will call ruby's regular expression gsub to replace every space by '20%'

def replace_spaces(string, length)
  string.gsub(/\s/) { '20%' }
end

# Solution 2
# Pseudocode
# We initialize an empty string, string_without_spaces.
# We go through the input string; If we encounter an empty space, we add "20%" to string_without_spaces, otherwise we add the input string character to it.
# When we are done looping through the input string, we return string_without_spaces

def replace_spaces_2(string, length)
  string_without_spaces = ""
  string.chars.each do |letter|
    if letter == " "
      string_without_spaces << "20%"
    else
      string_without_spaces << letter
    end
  end
  string_without_spaces
end

p replace_spaces('', 0) == ""
p replace_spaces('  ', 2) == "20%20%"
p replace_spaces("I love    R U B Y ", 18) == "I20%love20%20%20%20%R20%U20%B20%Y20%"

p replace_spaces_2('', 0) == ""
p replace_spaces_2('  ', 2) == "20%20%"
p replace_spaces_2("I love    R U B Y ", 18) == "I20%love20%20%20%20%R20%U20%B20%Y20%"
