/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Leetcode Problem 3: Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.
For example, the longest substring without repeating letters for "abcabcbb" is "abc",
whith the length of 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class LengthOfLongestSubstring {

  // Solution 1: Brute force - Time Limit Exceeded
  // : O(n^3) runtime and O(min(n, m)) space complexities
  // We need O(k) space for checking a substring has no duplicate characters, where k is
  // the size of the Set. The size of the Set is upper bounded by the size of the string n and
  // the size of the charset/alphabet m
  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) return 0;

    int n = s.length(), res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j <= n; j++) {
        if (allUnique(s, i, j) && res < j-i) {
          res = j-i;
        }
      }
    }
    return res;
  }

  public static boolean allUnique(String s, int start, int end) {
    Set<Character> set = new HashSet<>();
    for (int i = start; i < end; i++) {
      char c = s.charAt(i);
      if (set.contains(c)) return false;
      set.add(c);
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("\nSolution 1: Brute force - O(n^3) runtime, O(min(n, m)) space");
    System.out.println("lengthOfLongestSubstring(\"abcabcbb\") = " + lengthOfLongestSubstring("abcabcbb")); // 3, "abc"
    System.out.println("lengthOfLongestSubstring(\"bbbbb\") = " + lengthOfLongestSubstring("bbbbb")); // 1. "b"
    System.out.println("lengthOfLongestSubstring(\"pwwkew\") = " + lengthOfLongestSubstring("pwwkew")); // 3, "pwke"
  }

}

// Resources: https://leetcode.com/articles/longest-substring-without-repeating-characters/
