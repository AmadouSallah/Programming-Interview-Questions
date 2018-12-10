/*
Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, and there
exists one unique longest palindromic substring.

*/

public class LongestPalindromeSubstring {
  // Solution 1 - Brute Force: 0(n^3) running time and 0(1) space complexities
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

  // Solution 2 - Dynamic Programming: O(n^2) runtime and O(n^2) space complexities
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

  // Solution 3 - Expand Around Center: O(n^2) runtime and O(1) space complexities
  public static String longestPalindrome3(String s) {
    if (s == null || s.length() == 0) return "";
    int n = s.length();
    if (n < 2) return s;
    String res = s.substring(0, 1);

    for (int i = 0; i < n; i++) {
      // get the longest palindrome centered at i
      String s1 = traverse(s, i, i);
      // update res if necessary
      if (s1.length() > res.length()) res = s1;

      // get the longest palindrome centered between i and i+1
      String s2 = traverse(s, i, i+1);
      // update res if necessary
      if (s2.length() > res.length()) res = s2;
    }
    return res;
  }

  public static String traverse(String s, int l, int r) {
    int n = s.length();
    while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return s.substring(l+1, r);
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
    System.out.println("longestPalindrome2(null) = " + longestPalindrome2(null));
    System.out.println("longestPalindrome2(\"\") = " + longestPalindrome2(""));
    System.out.println("longestPalindrome2(\"a\") = " + longestPalindrome2("a"));
    System.out.println("longestPalindrome2(\"ab\") = " + longestPalindrome2("ab"));
    System.out.println("longestPalindrome2(\"babad\") = " + longestPalindrome2("babad"));
    System.out.println("longestPalindrome2(\"cbbd\") = " + longestPalindrome2("cbbd"));
    System.out.println("longestPalindrome2(\"abcba\") = " + longestPalindrome2("abcba"));
    System.out.println("longestPalindrome2(\"abccba\") = " + longestPalindrome2("abccba"));
    System.out.println("longestPalindrome2(\"abccbad\") = " + longestPalindrome2("abccbad"));
    System.out.println("longestPalindrome2(\"banana\") = " + longestPalindrome2("banana"));
    System.out.println("longestPalindrome2(\"bananas\") = " + longestPalindrome2("bananas"));

    System.out.println("\nExpand Around Center: O(n^2) runtime and O(1) space complexities");
    System.out.println("longestPalindrome3(null) = " + longestPalindrome3(null));
    System.out.println("longestPalindrome3(\"\") = " + longestPalindrome3(""));
    System.out.println("longestPalindrome3(\"a\") = " + longestPalindrome3("a"));
    System.out.println("longestPalindrome3(\"ab\") = " + longestPalindrome3("ab"));
    System.out.println("longestPalindrome3(\"babad\") = " + longestPalindrome3("babad"));
    System.out.println("longestPalindrome3(\"cbbd\") = " + longestPalindrome3("cbbd"));
    System.out.println("longestPalindrome3(\"abcba\") = " + longestPalindrome3("abcba"));
    System.out.println("longestPalindrome3(\"abccba\") = " + longestPalindrome3("abccba"));
    System.out.println("longestPalindrome3(\"abccbad\") = " + longestPalindrome3("abccbad"));
    System.out.println("longestPalindrome3(\"banana\") = " + longestPalindrome3("banana"));
    System.out.println("longestPalindrome3(\"bananas\") = " + longestPalindrome3("bananas"));
  }
}
