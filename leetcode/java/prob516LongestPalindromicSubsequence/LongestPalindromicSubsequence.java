/*
Leetcode Problem 516. Longest Palindromic Subsequence
https://leetcode.com/problems/longest-palindromic-subsequence/description/

Given a string s, find the longest palindromic subsequence's length in s.
You may assume that the maximum length of s is 1000.

Example 1:
Input: "bbbab"
Output: 4
One possible longest palindromic subsequence is "bbbb".

Example 2:
Input: "cbbd"
Output: 2
One possible longest palindromic subsequence is "bb".
*/

public class LongestPalindromicSubsequence {
  public static int longestPalindromeSubseq(String s) {
    if (s == null || s.length() == 0) return 0;
    int n = s.length();
    if (n == 1) return 1;
    int[][] res = new int[n][n];

    for (int i = n-1; i >= 0; i--) {
      res[i][i] = 1;
      for (int j = i+1; j < n; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          res[i][j] = 2 + res[i+1][j-1];
        } else {
          res[i][j] = Math.max(res[i+1][j], res[i][j-1]);
        }
      }
    }
    return res[0][n-1];
  }

  public static void main(String[] args) {
    System.out.println("longestPalindromeSubseq(\"bbbab\") = " + longestPalindromeSubseq("bbbab"));
    System.out.println("longestPalindromeSubseq(\"cbbd\") = " + longestPalindromeSubseq("cbbd"));
  }
}
