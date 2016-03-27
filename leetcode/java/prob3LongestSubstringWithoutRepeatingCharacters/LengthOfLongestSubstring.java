/*
  Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.
For example, the longest substring without repeating letters for "abcabcbb" is "abc",
whith the length of 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
import java.util.HashSet;

public class LengthOfLongestSubstring {

  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) return 0;

    int len = s.length();
    if (len == 1) return len;

    HashSet<Character> set = new HashSet<Character>();
    int i, j = 0, maxLen = 0;

    for (i = 0; i < len; i++) {
      char currentChar = s.charAt(i);
      if (set.contains(currentChar)) {
        maxLen = Math.max(maxLen, i-j);
        while ( s.charAt(j) != currentChar ) set.remove(s.charAt(j++));
        j++;

      } else
        set.add(currentChar);
    }

    return Math.max(maxLen, i-j);
  }

  public static void main(String[] args) {
    String s0 = null;
    String s1 = "";
    String s2 = "a";
    String s3 = "abcabcbb";
    String s4 = "bbbbb";
    String s5 = "ab";
    System.out.println(lengthOfLongestSubstring(s0)); // 0
    System.out.println(lengthOfLongestSubstring(s1)); // 0
    System.out.println(lengthOfLongestSubstring(s2)); // 1
    System.out.println(lengthOfLongestSubstring(s3)); // 3
    System.out.println(lengthOfLongestSubstring(s4)); // 1
    System.out.println(lengthOfLongestSubstring(s5)); // 2
  }
}