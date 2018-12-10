/*
Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, and there
exists one unique longest palindromic substring.

*/

public class LongestPalindromeSubstring {
  // Brute Force: 0(n^3) running time and 0(1) space complexities
  // Time Limit Exceeded
  public static String longestPalindrome1(String s) {
    if (s == null || s.length() == 0) return "";
    String res = s.substring(0, 1);
    int n = s.length();
    if (n < 2) return res;

    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        String sub = s.substring(i , j+1);
        if (isPalindrome(sub) && sub.length() > res.length()) {
          res = sub;
        }
      }
    }
    return res;
  }

  public static boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) return false;
      l++;
      r--;
    }
    return true;
  }


  public static void main(String[] args) {
    System.out.println("longestPalindrome1(null) = " + longestPalindrome1(null));
    System.out.println("longestPalindrome1(\"\") = " + longestPalindrome1(""));
    System.out.println("longestPalindrome1(\"a\") = " + longestPalindrome1("a"));
    System.out.println("longestPalindrome1(\"ab\") = " + longestPalindrome1("ab"));
    System.out.println("longestPalindrome1(\"babad\") = " + longestPalindrome1("babad"));
    System.out.println("longestPalindrome1(\"cbbd\") = " + longestPalindrome1("cbbd"));
    System.out.println("longestPalindrome1(\"abcba\") = " + longestPalindrome1("abcba"));
    System.out.println("longestPalindrome1(\"abccba\") = " + longestPalindrome1("abccba"));
    System.out.println("longestPalindrome1(\"abccbad\") = " + longestPalindrome1("abccbad"));
    System.out.println("longestPalindrome1(\"banana\") = " + longestPalindrome1("banana"));
    System.out.println("longestPalindrome1(\"bananas\") = " + longestPalindrome1("bananas"));
  }
}
