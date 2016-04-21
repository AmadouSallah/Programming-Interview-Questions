/*
Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, and there
exists one unique longest palindromic substring.

*/

public class LongestPalindrome {
  public static String longestPalindrome(String s) {

    if (s == null || s.length() == 0) return "";

    int len = s.length();
    String result = s.substring(0, 1); // the 1st character

    if (len == 1) return result;

    for (int i = 0; i < len; i++) {
      // get the longest palindrome centered at i (for cases where
      // there is no consecutive equal characters. Example "abcab")
      String s1 = longestPalindromeHelper(s, i, i);
      // update result if necessary
      if (s1.length() > result.length()) result = s1;

      // get the longest palindrome centered between i and i+1
      // (for cases where there is repeated consecutive chars.
      // Example: s = abccba, and i = 2)
      String s2 = longestPalindromeHelper(s, i, i+1);
      // update result if necessary
      if (s2.length() > result.length()) result = s2;
    }
    return result;

  }

  public static String longestPalindromeHelper(String s, int left, int right) {
    int len = s.length();
    while (left >= 0 && right < len && (s.charAt(left) == s.charAt(right)) ) {
      left--;
      right++;
    }

    return s.substring(left+1, right);
  }

  public static void main(String[] args) {
    System.out.println("longestPalindrome(null) = " + longestPalindrome(null));
    System.out.println("longestPalindrome(\"\") = " + longestPalindrome(""));
    System.out.println("longestPalindrome(\"a\") = " + longestPalindrome("a"));
    System.out.println("longestPalindrome(\"ab\") = " + longestPalindrome("ab"));
    System.out.println("longestPalindrome(\"abcba\") = " + longestPalindrome("abcba"));
    System.out.println("longestPalindrome(\"abccba\") = " + longestPalindrome("abccba"));
    System.out.println("longestPalindrome(\"abccbad\") = " + longestPalindrome("abccbad"));
    System.out.println("longestPalindrome(\"banana\") = " + longestPalindrome("banana"));
    System.out.println("longestPalindrome(\"bananas\") = " + longestPalindrome("bananas"));
  }
}