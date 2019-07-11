/*
Problem 172. Factorial Trailing Zeroes
https://leetcode.com/problems/factorial-trailing-zeroes/description/

Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
*/

public class FactorialTrailingZeroes {
  public static int trailingZeroes(int n) {
    long count = 0, i = 5;
    while (n / i > 0) {
      count += n / i;
      i *= 5;
    }
    return (int) count;
  }

  public static void main(String[] args) {
    System.out.println("trailingZeroes(3) = " + trailingZeroes(3));
    System.out.println("trailingZeroes(5) = " + trailingZeroes(5));
    System.out.println("trailingZeroes(25) = " + trailingZeroes(26));
    System.out.println("trailingZeroes(125) = " + trailingZeroes(125));
    System.out.println("trailingZeroes(1808548329) = " + trailingZeroes(1808548329));
  }
}
