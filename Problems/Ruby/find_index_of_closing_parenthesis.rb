=begin

Write a function that takes a string and a position of an opening parenthesis.
It should return the index of the corresponding closing parenthesis.
If no such closing parenthesis is found, the function should return -1

=end

def find_index_of_closing_parenthesis(string, position)
  len = string.length
  number_of_unclosed_parenthesis = 1

  i = position + 1
  while i < len
    char = string[i]
    if char == '('
      number_of_unclosed_parenthesis += 1
    elsif char == ')'
      number_of_unclosed_parenthesis -= 1
    end

    return i if number_of_unclosed_parenthesis == 0
    i += 1
  end
  return -1
end


# TEST CASES

string = "Hello (my(frined, how) are you?). I love this"
string2 = "Hello (my (frined)."

p find_index_of_closing_parenthesis("", 2) == -1
p find_index_of_closing_parenthesis(string, 6) == 31
p find_index_of_closing_parenthesis(string2, 6) == -1