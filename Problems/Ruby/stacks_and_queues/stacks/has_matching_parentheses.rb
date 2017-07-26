require_relative "implement_stack"
# Problem: Given a string, write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in the string.
# For example, the program should print true for string = “[()]{}{[()()]()}” and false for string = “[(])”

def has_matching_parentheses?(string)
  stack = Stack.new()
  hash_symbols = {'(' => ')', '[' => ']', '{' => '}'}

  string.split("").each do |letter|
    # if the letter is a key in hash_symbols, we add it to the stack
    stack.push(letter) if hash_symbols.keys.include?(letter)

    # If the letter is a value in hash_symbols, we return false if either the stack is empty or if the letter is not a closing symbol of the popped symbol from the stack
    if hash_symbols.values.include?(letter)
      return false if (stack.is_empty? || letter != hash_symbols[stack.pop])
    end

  end
  # If at the end of the string we don't hit a mismatch, return true
  true
end

# TEST DRIVE

string1 = "(I(really)love (al(g)or)ithms)"
string2 = ")hi("
string3 = "[a(b)c]{d}{e[f(g)(h)](i)}"
string4 = "what? [I (don't] understand) this :)"

p has_matching_parentheses?("[()]{}{[()()]()}") == true
p has_matching_parentheses?("[(])") == false
p has_matching_parentheses?(string1) == true
p has_matching_parentheses?(string2) == false
p has_matching_parentheses?(string3) == true
p has_matching_parentheses?(string4) == false