# 1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null-terminating string

# Solution: We will do it in Ruby instead :)

# A C/C++ string means that each string ends with a null character (0); example "hi" would be represented as 3 characters ("hi0")


def reverse(string)
  i = string.length - 2 # -2 (instead of -1) since we do not want to include the null terminating character
  reversed_string = ""
  while i >= 0
    reversed_string += string[i]
    i -= 1
  end
  reversed_string
end

# Note: If we want the returned string (reversed_string) to include a null terminating character, we replace line 15 by reversed_string + "0"

# Test
p reverse("I love Programming0") == "gnimmargorP evol I"
p reverse("0") == ""
p reverse("Hello0") == "olleH"
