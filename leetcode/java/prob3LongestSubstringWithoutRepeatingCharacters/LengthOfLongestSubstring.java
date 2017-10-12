/*
  Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.
For example, the longest substring without repeating letters for "abcabcbb" is "abc",
whith the length of 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class LengthOfLongestSubstring {

  // O(n) running time and O(n) space complexities
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

  // Solution 2: O(n) running time and O(1) space complexities
  /*

  We initialize i and maxLen to 0. i will point to the index of the beginning of the
  current substring without repeating characters; maxLen will track the longest
  lenth so far as we traverse the input string.

  We also define a  mapping of the characters to their index. Note that there are 256 ASCII characters,
  so we define an array, charMap, of size 256 and initialize each of its elements to -1.

  For each character c of the input string s, charMap[c] (same as charMap[(int) c]) will be set to the
  index of c in s. Note that (int) c is the corresponding integer ASCII value of c.
  If c is repeated somewhere in s, charMap[c] will, at the end, hold the index of the last position of c in s.

  Example, if s = "abdae", since the ASCII value of 'a' is 97, and the 1st 'a' is at position 0 in "abdae",
  charMap[97] will intially be set to 0. But eventually, when we reach the 2nd 'a' at position 3, charMap[97]
  will be set to 3.
  Also, since the ASCII value of 'd' is 100 and 'd' is at position 2 in "abdae", charMap[100] will be set to 2.
  Similarly, charMap[98] will be set to 1 (for 'b'), and charMap[101] will be set to 4 (for 'e').

  We loop through the characters of input string s.
    Remember i points to the beginning of the current substring in consideration.

    If the current character has already been seen, we update i to the maximub between i
    and the index of the next character
    Remeber that charMap[c] represents the position of character c in s. Therefore, setting i to
    charMap[c] + 1 will make i point to the next character in s.

    We then set the value of charMap[c] to the current index. We also update maxLen to the number of characters from
    i to the current character it this is greater than the previous maxLen.
  */
  public static int lengthOfLongestSubstring2(String s) {

    if (s == null || s.length() == 0) return 0;

    int i = 0, maxLen = 0, n = s.length();
    int[] charMap = new int[256];
    Arrays.fill(charMap, -1);

    for (int j = 0; j < n; j++) {
      char c = s.charAt(j);
      /*
      if (charMap[c] >= i) // if character c has already been seen
        i = charMap[c] + 1; // then move i to the right of c
      */
      // same as above commented if statement:
      i = Math.max(i, charMap[c]+1); // update i to the max between i and the next character's index

      charMap[c] = j;
      maxLen = Math.max(maxLen, j-i+1);
    }
    return maxLen;
  }

  // Solution 3 using Hashmap: O(n) runtime and O(n) space complexities
  public static int lengthOfLongestSubstring3(String s) {
    if (s == null || s.length() == 0) return 0;
    int n = s.length(), left = 0, right, max = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (right = 0; right < n; right++) {
      char c = s.charAt(right);

      if (map.containsKey(c)) {
        left = Math.max(left, map.get(c)+1);
      }

      map.put(c, right);
      max = Math.max(max, right-left+1);
    }
    return max;
}

  public static void main(String[] args) {

    System.out.println("Testing solution1 with O(n) runtime and O(n) space:");
    System.out.println("lengthOfLongestSubstring(\"null\") = " + lengthOfLongestSubstring(null)); // 0
    System.out.println("lengthOfLongestSubstring(\"\") = " + lengthOfLongestSubstring("")); // 0
    System.out.println("lengthOfLongestSubstring(\"a\") = " + lengthOfLongestSubstring("a")); // 1
    System.out.println("lengthOfLongestSubstring(\"abcabcbb\") = " + lengthOfLongestSubstring("abcabcbb")); // 3
    System.out.println("lengthOfLongestSubstring(\"bbbbb\") = " + lengthOfLongestSubstring("bbbbb")); // 1
    System.out.println("lengthOfLongestSubstring(\"ab\") = " + lengthOfLongestSubstring("ab")); // 2
    System.out.println("lengthOfLongestSubstring(\"pwwkew\") = " + lengthOfLongestSubstring2("pwwkew")); // 3

    System.out.println("\nTesting solution2 with O(n) runtime and O(1) space:");
    System.out.println("lengthOfLongestSubstring2(\"null\") = " + lengthOfLongestSubstring2(null)); // 0
    System.out.println("lengthOfLongestSubstring2(\"\") = " + lengthOfLongestSubstring2("")); // 0
    System.out.println("lengthOfLongestSubstring2(\"a\") = " + lengthOfLongestSubstring2("a")); // 1
    System.out.println("lengthOfLongestSubstring2(\"abcabcbb\") = " + lengthOfLongestSubstring2("abcabcbb")); // 3
    System.out.println("lengthOfLongestSubstring2(\"bbbbb\") = " + lengthOfLongestSubstring2("bbbbb")); // 1
    System.out.println("lengthOfLongestSubstring2(\"ab\") = " + lengthOfLongestSubstring2("ab")); // 2
    System.out.println("lengthOfLongestSubstring2(\"pwwkew\") = " + lengthOfLongestSubstring2("pwwkew")); // 3

    System.out.println("\nTesting solution3 with O(n) runtime and O(n) space:");
    System.out.println("lengthOfLongestSubstring3(\"null\") = " + lengthOfLongestSubstring3(null)); // 0
    System.out.println("lengthOfLongestSubstring3(\"\") = " + lengthOfLongestSubstring3("")); // 0
    System.out.println("lengthOfLongestSubstring3(\"a\") = " + lengthOfLongestSubstring3("a")); // 1
    System.out.println("lengthOfLongestSubstring3(\"abcabcbb\") = " + lengthOfLongestSubstring3("abcabcbb")); // 3
    System.out.println("lengthOfLongestSubstring3(\"bbbbb\") = " + lengthOfLongestSubstring3("bbbbb")); // 1
    System.out.println("lengthOfLongestSubstring3(\"ab\") = " + lengthOfLongestSubstring3("ab")); // 2
    System.out.println("lengthOfLongestSubstring3(\"pwwkew\") = " + lengthOfLongestSubstring3("pwwkew")); // 3
  }
}
