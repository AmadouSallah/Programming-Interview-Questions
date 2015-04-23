# Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?

# PSEUDOCODE:
# We create a hash with default value of 0. We then split the characters of the input string into an array (characters) and we iterate through this array.
# We add each element of characters to the hash; if a key (character) is encountered more than once, it's corresponding value is incremented accordingly.
# Each time we add a key (character) to the hash, we check to see if it's value is greater than 1; if so, we return false since this would mean that we encountered it more than once and therefore the particular character is not unique.
def is_uniq_chars?(string)
  hash = Hash.new(0)
  characters = string.chars
  characters.each do |char|
    hash[char] += 1
    return false if hash[char] > 1
  end
  true
end

puts "Testing:"
p is_uniq_chars?("Hello") == false
p is_uniq_chars?('World!') == true
p is_uniq_chars?("") == true
p is_uniq_chars?(" ") == true