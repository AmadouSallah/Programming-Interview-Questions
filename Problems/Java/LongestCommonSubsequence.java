/*
Longest Common Subsequence
From https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs
the differences between two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
*/

public class LongestCommonSubsequence {

  // Recursive solution: Exponential runtime
  public static int longestCommonSubsequence(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return 0;
    }
    return traverse(s, t, s.length(), t.length());
  }

  public static int traverse(String s, String t, int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    } else if (s.charAt(m-1) == t.charAt(n-1)) {
      return 1 + traverse(s, t, m-1, n-1);
    } else {
      int trimLeft = traverse(s, t, m-1, n);
      int trimRight = traverse(s, t, m, n-1);
      return Math.max(trimLeft, trimRight);
    }
  }

  // Dynamic Programming solutioin:
  public static int longestCommonSubsequenceDP(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return 0;
    }

    int m = s.length(), n = t.length();
    int[][] dp = new int[m+1][n+1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (s.charAt(i-1) == t.charAt(j-1)) {
          dp[i][j] = 1 + dp[i-1][j-1];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    
    System.out.println("Using recursive solution:");
    System.out.println("longestCommonSubsequence(\"ABCDGH\", \"AEDFHR\") = " + longestCommonSubsequence("ABCDGH", "AEDFHR")); // 3 -> "ADH"
    System.out.println("longestCommonSubsequence(\"AGGTAB\", \"GTAB\") = " + longestCommonSubsequence("AGGTAB", "GTAB")); // 4 -> "ADH"

    System.out.println("\nUsing Dynamic Programming solution:");
    System.out.println("longestCommonSubsequenceDP(\"ABCDGH\", \"AEDFHR\") = " + longestCommonSubsequenceDP("ABCDGH", "AEDFHR"));
    System.out.println("longestCommonSubsequenceDP(\"AGGTAB\", \"GTAB\") = " + longestCommonSubsequenceDP("AGGTAB", "GTAB"));
  }
}
