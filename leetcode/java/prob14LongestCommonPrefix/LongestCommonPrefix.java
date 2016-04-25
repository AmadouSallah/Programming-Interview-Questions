/*
Longest Common Prefix

Write a function to find the longest common prefix string
amongst an array of strings.
*/

public class LongestCommonPrefix {

  public static String longestCommonPrefix(String[] strs) {

    if (strs == null || strs.length == 0) return "";

    int len = strs.length;
    String result = strs[0];

    for (int i = 1; i < len; i++) {

      String s = strs[i];
      int minLen = Math.min(s.length(), result.length());
      int j = 0;

      while ( (j < minLen) && (result.charAt(j) == s.charAt(j)) )
        j++;

      result = result.substring(0, j);
    }

    return result;
  }
}