/*
Leetcode Problem 76: Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/description/

Given a string S and a string T, find the minimum window in S which
will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

import java.util.Map;
import java.util.HashMap;

public class MinWindowSubstring {
  public static String minWindow(String s, String t) {

    if (s == null || t == null || s.length() == 0 || s.length() < t.length())
      return "";

    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray())
      map.put(c, map.getOrDefault(c, 0) + 1);

    int left = 0, minLeft = 0, minLen = s.length() + 1, numberOfMissingChars = t.length();

    for (int right = 0; right < s.length(); right++) {
      char curr = s.charAt(right);

      if (map.containsKey(curr)) {
        map.put(curr, map.get(curr) - 1);

        if (map.get(curr) >= 0)
          numberOfMissingChars--;

        while (numberOfMissingChars == 0) {
          int currentLen = right - left + 1;
          if (currentLen < minLen) {
            minLen = currentLen;
            minLeft = left;
          }

          char leftChar = s.charAt(left);
          if (map.containsKey(leftChar)) {
            map.put(leftChar, map.get(leftChar) + 1);

            if (map.get(leftChar) > 0)
              numberOfMissingChars++;
          }
          left++;
        }
      }
    }
    return (minLen > s.length()) ? "" : s.substring(minLeft, minLeft + minLen);
  }

  public static void main(String[] args) {
    System.out.println("minWindow(\"ADOBECODEBANC\", \"\") = " + minWindow("ADOBECODEBANC", "") );
    System.out.println("minWindow(\"ADOBECODEBANC\", \"ABC\") = " + minWindow("ADOBECODEBANC", "ABC") );
  }
}
