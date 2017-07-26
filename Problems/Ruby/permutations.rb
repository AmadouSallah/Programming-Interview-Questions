# Write a program that takes a string as input and prints all the permutations of the input string.
# For example, for input "abc", the output would be: "abc", "acb", "bac", "bca", "cab", and "cba" (each printed in a line)


# SOLUTION - Running time of 0(n!)

def permutations(string)
  permute(string, 0, string.length)
end

def permute(string, first_index, last_index)
  if first_index == last_index
    puts string
    return
  else
    i = first_index # fixing the 1st spot
    while i < last_index
      swap(string, first_index, i) # swap the first position with that at i
      permute(string, first_index + 1, last_index) # recursive call
      swap(string, first_index, i) # swap back

      i += 1
    end
  end
end

def swap(string, i, j)
  temp = string[i]
  string[i] = string[j]
  string[j] = temp
end

permutations("123")