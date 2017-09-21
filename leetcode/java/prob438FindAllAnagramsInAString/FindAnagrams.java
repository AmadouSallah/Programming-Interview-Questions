/*
Resources https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

Problem 438. Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s
and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

import java.util.List;
import java.util.ArrayList;

public class FindAnagrams {

  public static List<Integer> findAnagrams(String s, String p) {

    List<Integer> result = new ArrayList<>();

    if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length())
      return result;

    int sLen = s.length(), pLen = p.length();
    // pArray stores count of all characters of p whereas
    // sArray stores count of current window of s
    char[] sArray = new char[256], pArray = new char[256];

    for (int i = 0; i < pLen; i++) {
      sArray[s.charAt(i)]++;
      pArray[p.charAt(i)]++;
    }

    //  Traverse through remaining characters of s
    for (int i = pLen; i < sLen; i++) {

      // compare counts of current window of s with counts of pArray
      if (compare(sArray, pArray))
          result.add((i-pLen));

      // Move window to the right by 1 character by removing the 1st
      // character of window (in sArray) and adding current character
      sArray[s.charAt(i-pLen)]--;
      sArray[s.charAt(i)]++;
    }

    // check for the last window
    if (compare(sArray, pArray))
      result.add(sLen-pLen);

    return result;
  }

  public static boolean compare(char[] arr1, char[] arr2) {
    if (arr1.length != arr2.length) return false;
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i])
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("findAnagrams(\"cbaebabacd\", \"abc\") = " + findAnagrams("cbaebabacd", "abc"));
    System.out.println("findAnagrams(\"abab\", \"ab\") = " + findAnagrams("abab", "ab"));
    // s: "abab" p: "ab"
  }
}
/* Resources:
https://www.youtube.com/watch?time_continue=1&v=-rcfE1Tj2E0
http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
*/
