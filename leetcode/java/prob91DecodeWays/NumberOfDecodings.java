/*
Problem 91. Decode Ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public class NumberOfDecodings {
  public static int numDecodings(String s) {
    if (s == null || s.length() == 0) return 0;
    int n = s.length();
    int[] dp = new int[n+1];
    dp[0] = 1; // there is only 1 way to decode empty string, which is the empty string: "" -> ""

    if (s.charAt(0) != '0')  // There is only 1 way to decode a nonempty string of length 1:
        dp[1] = 1;           // Example s = "3" -> "C", so only 1 way to decode "3"

    // i represents the index of dp, and i-1 will be the corresponding index of input s
    for (int i = 2; i <= n; i++) {

      if (s.charAt(i-1) != '0') {
          dp[i] += dp[i-1];
      }

      int twoDigits = Integer.parseInt(s.substring(i-2, i));
      if (twoDigits >= 10 && twoDigits <= 26) {
          dp[i] += dp[i-2];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println("numDecodings(\"\") = " + numDecodings("")); // -> ""
    System.out.println("numDecodings(\"1\") = " + numDecodings("1")); // -> "A"
    System.out.println("numDecodings(\"12\") = " + numDecodings("12")); // -> "AB", or "L"
    System.out.println("numDecodings(\"123\") = " + numDecodings("123")); // -> "ABC", or "LX", or "LC"
  }
}
