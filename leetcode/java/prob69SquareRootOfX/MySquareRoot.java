/*
Leetcode Problem 69. Sqrt(x)

https://leetcode.com/problems/sqrtx/description/

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and
only the integer part of the result is returned.

Example 1:
Input: 4
Output: 2

Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
*/

public class MySquareRoot {
  // O(square root of x) runtiime and O(1) space complexities
  public static int mySqrt(int x) {
    if (x == 0 || x == 1) return x;
    long i = 2;
    while (i * i <= x) i++;
    return (int) i-1;
  }

  public static void main(String[] args) {
    System.out.println("mySqrt(2) = " + mySqrt(2)); // 2
    System.out.println("mySqrt(8) = " + mySqrt(8)); // 2
    System.out.println("mySqrt(2147395600) = " + mySqrt(2147395600)); // 46340
  }
}
