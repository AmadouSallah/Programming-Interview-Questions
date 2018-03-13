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
import java.util.Map;
import java.util.HashMap;

public class FindAnagrams {

  public static List<Integer> findAnagrams(String s, String p) {

    List<Integer> result = new ArrayList<>();

    if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length())
      return result;

    int sLen = s.length(), pLen = p.length();
    // pArray stores count of all characters of p whereas
    // sArray stores count of current window of s
    char[] sArray = new char[26], pArray = new char[26];

    for (int i = 0; i < pLen; i++) {
      sArray[s.charAt(i) - 'a']++;
      pArray[p.charAt(i) - 'a']++;
    }

    //  Traverse through remaining characters of s
    for (int i = pLen; i < sLen; i++) {

      // compares counts of current window of s with that of pArray
      if (isSame(sArray, pArray))
          result.add((i-pLen));

      // Move window to the right by 1 character by removing the 1st
      // character of window (in sArray) and adding current character
      sArray[s.charAt(i-pLen) - 'a']--;
      sArray[s.charAt(i) - 'a']++;
    }

    // check for the last window
    if (isSame(sArray, pArray))
      result.add(sLen-pLen);

    return result;
  }

  public static boolean isSame(char[] arr1, char[] arr2) {
    if (arr1.length != arr2.length) return false;
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i])
        return false;
    }
    return true;
  }


  // doesn't work for s: "cbaebabacd" p: "abc"; get stuck at last char 'd'
  public static List<Integer> findAnagrams2(String s, String p) {
    List<Integer> result = new ArrayList<>();

    if (p.length() > s.length()) return result;

    Map<Character, Integer> map = new HashMap<>();

    for (char c : p.toCharArray())
      map.put(c, map.getOrDefault(c, 0)+1);

    int counter = map.size(), left = 0, right = 0;

    while (right < s.length()) {
//System.out.println(s.charAt(right));
      char c = s.charAt(right);
      if (map.containsKey(c)) {
        map.put(c, map.get(c)-1);
        if (map.get(c) == 0)
          counter--;
      }
      right++;

      while (counter == 0) {
        char c2 = s.charAt(left);
        if (map.containsKey(c2)) {
          map.put(c2, map.get(c2)+1);
          if (map.get(c2) > 0) // to check if c2 is matched with a key in hash
            counter++; // if so, increment counter. (bc it was decremented by 1 in outer loop)

          if (right - left == p.length())
            result.add(left);

          left++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("findAnagrams(\"cbaebabacd\", \"abc\") = " + findAnagrams("cbaebabacd", "abc"));
    System.out.println("findAnagrams(\"abab\", \"ab\") = " + findAnagrams("abab", "ab"));

    // System.out.println("findAnagrams2(\"cbaebabacd\", \"abc\") = " + findAnagrams2("cbaebabacd", "abc"));
    System.out.println("findAnagrams2(\"abab\", \"ab\") = " + findAnagrams2("abab", "ab"));

  }
}
/* Resources:
https://www.youtube.com/watch?time_continue=1&v=-rcfE1Tj2E0
http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
*/

/*
SOLUTION 2: findAnagrams2

// It says: Time Limit Exceeded

Comment by chenliuliu
For example, if t = 'abb', s = 'abbabb'.
Here we can create a hash table for string t :
Key (Value) : a(1), b(2). [Here, counter =2]
When iterating right, when it makes counter == 0, it means : substring 'abb' of s is
an anagram of p. (This is because, we only decrement counter when the value of end is 0.
Now, the hash table is : Key (Value) : a(0), b(0). [Here, counter =0, we increment end.]

Knowing this, we want to continue checking whether "bba"is an anagram of t. Here, we
update the begin pointer to the second char of s. Before we do so, we have to check
if there is some impact by pervious left, which is the first char of s. Because we slid
the window to s.substring(1,4) instead of s.substring(0,3), we want to get rid of the
previous impact of first char of s.

We use map.get(c2) > 0 to check whether or not s.charAt(left) is matched with a key in hash
table before . If it is matched before, we should increase counter because it would be
unmatched when we only want to check s.substring(0,3).

Why use map.get(tempc) > 0 ? Because in the outer while loop, for each char that is matched,
its value must be larger than 0. (Because the char has to be in hash table.)
In the outer while loop, we decrement the its value by 1, in the inner while loop, we
increment its value by 1. So, after all, its value should be larger than 0.
*/


// Resources: https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
