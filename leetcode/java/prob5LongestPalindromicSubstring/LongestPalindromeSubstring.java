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

  // Dynamic Programming: O(n^2) runtime and O(n^2) space complexities
  public static String longestPalindrome2(String s) {
    if (s == null || s.length() == 0) return "";
    int n = s.length();
    if (n < 2) return s;
    int left = 0, maxLen = 1;
    boolean[][] isPalindrome = new boolean[n][n];

    // Single characters are palindromes
    for (int i = 0; i < n; i++) {
      isPalindrome[i][i] = true;
    }

    // Palindromes of length 2
    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i+1)) {
        isPalindrome[i][i+1] = true;
        left = i;
        maxLen = 2;
      }
    }

    // Palindromes os length >= 3
    for (int len = 3; len <= n; len++) {
      for (int start = 0; start <= n-len; start++) {
        int end = start + len - 1;
        char firstChar = s.charAt(start), lastChar= s.charAt(end);
        if (firstChar == lastChar && isPalindrome[start+1][end-1]) {
          isPalindrome[start][end] = true;
          left = start;
          maxLen = len;
        }
      }
    }

    return s.substring(left, left + maxLen);
  }


  public static void main(String[] args) {
    System.out.println("Brute force solution: 0(n^3) running time and 0(1) space complexities");
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

    System.out.println("\nDynamic Programming solution: 0(n^2) running time and 0(n^2) space complexities");
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
