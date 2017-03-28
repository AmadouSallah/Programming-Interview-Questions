/*
Given an input string s, write a program to check if any of its anagrams is a palindrome.
The program returns true if at least one of its anagrams is a palindrome, and false otherwise.

Example
for input s = "carrace", 2 of its anagrams, "racecar" and "carerac", are both palindromes => true
For s = "aac", an anagram of s is "aca", which is a palindrome => true
For s = "abc", none of its anagrams is a palindrome => false
s = "icvic", anagram "civic" is a palindrome, so return true
s = "civil", none of its anagrams is a palindrome, so return false
*/

import java.util.Set;
import java.util.HashSet;

public class AnagramPalindrome {

  public static boolean anagramPalindrome(String s) {

    if (s == null || s.length() <= 1) return true;
    
    Set<Character> set = new HashSet<Character>();
    int n = s.length();

    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      // if c is in the set, we remove it; otherwise, we add it to the set
      if (set.contains(c)) {
        set.remove(c);
      } else {
        set.add(c);
      }
    }
    // The set should contains at most 1 character in other for any of its anagrams to be a palindrome.
    return set.size() <= 1;

  }
  public static void main(String[] args) {
    System.out.println("anagramPalindrome(\"carrace\") = " + anagramPalindrome("carrace"));
    System.out.println("anagramPalindrome(\"civic\") = " + anagramPalindrome("civic"));
    System.out.println("anagramPalindrome(\"civil\") = " + anagramPalindrome("civil"));
    System.out.println("anagramPalindrome(\"baa\") = " + anagramPalindrome("baa"));
    System.out.println("anagramPalindrome(\"bac\") = " + anagramPalindrome("bac"));
  }
}
