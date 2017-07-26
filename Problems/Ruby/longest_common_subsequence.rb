# Given two sequences, find the length of the longest subsequence present in both of them.
# A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
# For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.

# SOLUTION:
# Pseudocode
# I)
# We will first construct a 2D table from inputs string1 and string2 with a helper function common_subsequence_table;
# we will build this table in a bottom up way.
# The elements of the table, table[i][j], will contain the length of the longest
# common subsequence of string1[0..i-1] and strin2[0..j-1]
# The helper function, common_subsequence_table, returns this table
# The table will be built using the formula below:
#  table[i][j] = 0 if i = 0 or j = 0
#  table[i][j] = table[i-1][j-1] + 1 if i > 0, j > 0, and string1[i] = string2[j]
#  table[i][j] = max(table[i, j-1], table[i-1, j]) if i, j > 0 and tring1[i] != string2[j]

# II)
def longest_common_subsequence(string1, string2)
  table = common_subsequence_table(string1, string2)
  result = ""
  i = string1.length
  j = string2.length
  # we start from right bottom corner of table and 1 by 1 we store the common characters (of string1 and string2) into result.
  while i > 0 && j > 0
     # if current character in string1 and string2 are the same, we add it to result
    if string1[i-1] == string2[j-1]
      result.insert(0, string1[i-1]) # put current character at begining of result
      i -= 1 # decrement both i and j
      j -= 1
      # If the 2 characters are not the same, find the largest of 2 elements (left or up) from table and go into that direction
    elsif table[i-1][j] > table[i][j-1]
      i -= 1
    else
      j -= 1
    end
  end
  result
end

def common_subsequence_table(string1, string2)
  len1 = string1.length
  len2 = string2.length
  table = Array.new(len1+1) {Array.new(len2+1)}

  i = 0
  while i <= len1
    j = 0
    while j <= len2
      if i == 0 || j == 0
        table[i][j] = 0
      elsif string1[i-1] == string2[j-1]
        table[i][j] = table[i-1][j-1] + 1
      else
        table[i][j] = maximum(table[i][j-1], table[i-1][j])
      end
      j += 1
    end
    i += 1
  end
  table
end

def maximum(a, b)
  a > b ? a : b
end

p longest_common_subsequence("ABCBDAB", "BDCABC") == "BDAB"
p longest_common_subsequence("abc", "d") == ""
p longest_common_subsequence("ab", "a") == "a"
p longest_common_subsequence("ABCDGH", "AEDFHR") == "ADH"
p longest_common_subsequence("AGGTAB", "GXTXAYB") == "GTAB"