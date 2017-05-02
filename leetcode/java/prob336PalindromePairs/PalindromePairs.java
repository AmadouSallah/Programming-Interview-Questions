/*
Problem 336. Palindrome Pairs

Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that
the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]

Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/

/*
    EXPLANATION

We intialize a hashmap and put all input words in it with value to be the corresponding index

We iterate through the words in the input array of strings.
  For each word, we iterate through it and in each iteration, we divide the left and righ sides
  into 2 subtrings, s1 (prefix, 1st part of the word) and s2 (the rest of the word).

    Case 1: s1 is a palindrome
    In this case, we reverse s2 (we called the reversed string s2Rev) and check to see if hmap contains s2Rev.
    If so, this means appending s2Rev to the beginning of the current word (i.e. s2Rev + word = s2Rev + s1 + s2)
    would form a palindrome.
    Example, if word = "abacdef" (j will go from 0 to 7 included)
    At j = 3, we have s1 = "aba", s2 = "cdef". Then s1 is a palindrome and s2Rev = "fedc".
    If s2Rev is in the hash, then s2Rev + word = s2Rev + s1 + s2 = "fedcabacdef" is a palindrome.
    Therefore, we add [index-of-s2Rev, index-of-word] to the result

    Case 2: s2 is a palindrome.
    We reverse s1 (s1Rev) and check to see if hmap contains s1Rev. If so, this means appending s1Rev
    to the end of word (i.e word + s1Rev = s1 + s2 + s1Rev) would form a palindrome.
    Example, if word = "abcdc" (j will go from 0 to 5 included)
    At j = 2, we get s1 = "ab", s2 = "cdc". Then s2 is a palindrome and s1Rev = "ba".
    If s1Rev is in the hash, then word + s1Rev = s1 + s2 + s1Rev = "abcdcba" is a palindrome.
    Therefore, we add [index-of-word, index-of-s1Rev] to the result

We return the result at the end     

*/
public class PalindromePairs {

}
