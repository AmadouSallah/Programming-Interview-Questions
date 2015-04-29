# Problem 1.8
# Assume you have a method isSubstring which checks if one word is a substring of another.
# Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i e , “waterbottle” is a rotation of “erbottlewat”)

# SOLUTION
# PSEUDOCODE
# If a string s is a rotation of another string t, then t is a substring of s+s.
# Example: s = "waterbottle", t = "erbottlewat", then s+s = "waterbottlewaterbottle" and we can clearly see that t is a substring of s+s.
# 1) We append s1 to s1 to get a string s1s1.
# 2) If s2 is not empty, we return the result of calling isSubstring(s1,s2). Otherwise, we return false.

def is_a_rotation?(s1, s2)
  s1 << s1 # we append s1 to s1 to get s1s1
  return isSubstring(s1, s2) if s2.length > 0
  false
end

p is_a_rotation?("waterbottle", "erbottlewat")