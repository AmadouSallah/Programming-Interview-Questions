/*
Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, and there
exists one unique longest palindromic substring.

*/

public class LongestPalindrome {

  // 0(n^2) running time and 0(n) space complexities
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

  // 0(n^3) running time and 0(1) space complexities
  public static String longestPalindrome2(String s) {
    if (s == null || s.length() == 0) return "";

    String result = s.substring(0, 1);
    int n = s.length();

    if (n == 1) return result;

    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        String currentSubstring = s.substring(i, j+1);
        if (isPalindrome(currentSubstring) && currentSubstring.length() > result.length())
          result = currentSubstring;
      }
    }

    return result;
  }

  public static boolean isPalindrome(String s) {
    int left = 0, right = s.length()-1;
    while (left <= right) {
      if (s.charAt(left) != s.charAt(right))
        return false;
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("Using longestPalindrome method: 0(n^2) running time and 0(n) space complexities.");
    System.out.println("longestPalindrome(null) = " + longestPalindrome(null));
    System.out.println("longestPalindrome(\"\") = " + longestPalindrome(""));
    System.out.println("longestPalindrome(\"a\") = " + longestPalindrome("a"));
    System.out.println("longestPalindrome(\"ab\") = " + longestPalindrome("ab"));
    System.out.println("longestPalindrome(\"abcba\") = " + longestPalindrome("abcba"));
    System.out.println("longestPalindrome(\"abccba\") = " + longestPalindrome("abccba"));
    System.out.println("longestPalindrome(\"abccbad\") = " + longestPalindrome("abccbad"));
    System.out.println("longestPalindrome(\"banana\") = " + longestPalindrome("banana"));
    System.out.println("longestPalindrome(\"bananas\") = " + longestPalindrome("bananas"));

    System.out.println("\nUsing longestPalindrome2 method: 0(n^3) running time and 0(1) space complexities.");
    System.out.println("longestPalindrome2(null) = " + longestPalindrome2(null));
    System.out.println("longestPalindrome2(\"\") = " + longestPalindrome2(""));
    System.out.println("longestPalindrome2(\"a\") = " + longestPalindrome2("a"));
    System.out.println("longestPalindrome2(\"ab\") = " + longestPalindrome2("ab"));
    System.out.println("longestPalindrome2(\"abcba\") = " + longestPalindrome2("abcba"));
    System.out.println("longestPalindrome2(\"abccba\") = " + longestPalindrome2("abccba"));
    System.out.println("longestPalindrome2(\"abccbad\") = " + longestPalindrome2("abccbad"));
    System.out.println("longestPalindrome2(\"banana\") = " + longestPalindrome2("banana"));
    System.out.println("longestPalindrome2(\"bananas\") = " + longestPalindrome2("bananas"));
  }
}