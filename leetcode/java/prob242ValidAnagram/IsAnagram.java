/*
Problem 242: Valid Anagram
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class IsAnagram {

  // Using HashMap: O(n) runtime, and O(n) space complexities,
  // where n is the length of the longest string between s and t
  public static boolean isAnagram(String s, String t) {
    int sLen = s.length(), tLen = t.length();
    if (sLen != tLen) return false;
    if (sLen == 0 && tLen == 0) return true;
    if (sLen == 0 || tLen == 0) return false; // this means that only one of them is 0

    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();

    Arrays.sort(sArray);
    Arrays.sort(tArray);

    for (int i = 0; i < sLen; i++) {
      if (sArray[i] != tArray[i])
        return false;
    }

    return true;
  }

  // Using HashMap: O(n) runtime, and O(n) space complexities,
  // where n is the length of the longest string between s and t
  public static boolean isAnagram2(String s, String t) {

    if (s.length() != t.length()) return false;

      Map<Character, Integer> map = new HashMap<>();

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
        }
      }

      for (int i = 0; i < t.length(); i++) {
        char c = t.charAt(i);
        if (!map.containsKey(c)) {
          return false;
        }

        map.put(c, map.get(c) - 1);

        if (map.get(c) == 0) {
          map.remove(c);
        }
      }

      return map.isEmpty();
  }

  // Using HashMap: O(n) runtime, and O(1) space complexities,
  // where n is the length of the longest string between s and t
  public static boolean isAnagram3(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }

      int[] counter = new int[26];
      for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
      }

      for (int count : counter) {
        if (count != 0) return false;
      }

      return true;
  }

  public static void main(String[] args) {
    System.out.println("\nTesting with solution 1: O(n) runtime and O(1) space complexities");
    System.out.println("isAnagram(\"\", \"\") = " + isAnagram("", ""));
    System.out.println("isAnagram(\"a\", \"\") = " + isAnagram("a", ""));
    System.out.println("isAnagram(\"\", \"b\") = " + isAnagram("", "b"));
    System.out.println("isAnagram(\"a\", \"b\") = " + isAnagram("a", "b"));
    System.out.println("isAnagram(\"anagram\", \"nagaram\") = " + isAnagram("anagram", "nagaram"));
    System.out.println("isAnagram(\"rat\", \"car\") = " + isAnagram("rat", "car"));
    System.out.println("isAnagram(\"hello\", \"hi\") = " + isAnagram("hello", "hi"));

    System.out.println("\nTesting with solution 2 using HashMap: O(n) runtime and O(1) space complexities");
    System.out.println("isAnagram2(\"\", \"\") = " + isAnagram2("", ""));
    System.out.println("isAnagram2(\"a\", \"\") = " + isAnagram2("a", ""));
    System.out.println("isAnagram2(\"\", \"b\") = " + isAnagram2("", "b"));
    System.out.println("isAnagram2(\"a\", \"b\") = " + isAnagram2("a", "b"));
    System.out.println("isAnagram2(\"anagram\", \"nagaram\") = " + isAnagram2("anagram", "nagaram"));
    System.out.println("isAnagram2(\"rat\", \"car\") = " + isAnagram2("rat", "car"));
    System.out.println("isAnagram2(\"hello\", \"hi\") = " + isAnagram2("hello", "hi"));

    System.out.println("\nTesting with solution 3: O(n) runtime and O(1) space complexities");
    System.out.println("isAnagram3(\"\", \"\") = " + isAnagram3("", ""));
    System.out.println("isAnagram3(\"a\", \"\") = " + isAnagram3("a", ""));
    System.out.println("isAnagram3(\"\", \"b\") = " + isAnagram3("", "b"));
    System.out.println("isAnagram3(\"a\", \"b\") = " + isAnagram3("a", "b"));
    System.out.println("isAnagram3(\"anagram\", \"nagaram\") = " + isAnagram3("anagram", "nagaram"));
    System.out.println("isAnagram3(\"rat\", \"car\") = " + isAnagram3("rat", "car"));
    System.out.println("isAnagram3(\"hello\", \"hi\") = " + isAnagram3("hello", "hi"));
    }
}
