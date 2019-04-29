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
  // O(square root of x) runtime and O(1) space complexities
  public static int mySqrt(int x) {
    if (x == 0 || x == 1) return x;
    long i = 2;
    while (i * i <= x) i++;
    return (int) i-1;
  }

  // O(log x) runtime and O(1) space complexities
  public static int mySqrt2(int x) {
    if (x == 0 || x == 1) return x;
    long left = 0, right = x;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      long square = mid * mid;
      if (square == x) return (int) mid;
      else if (square < x) left = mid + 1;
      else right = mid - 1;
    }
    return (int) left - 1; // for cases where the decimal part is truncated, no perfect square
  }

  public static void main(String[] args) {
    System.out.println("Solution with O(square root of x) runtime and O(1) space complexities");
    System.out.println("mySqrt(2) = " + mySqrt(2)); // 2
    System.out.println("mySqrt(8) = " + mySqrt(8)); // 2
    System.out.println("mySqrt(2147395600) = " + mySqrt(2147395600)); // 46340

    System.out.println("\nSolution with O(log x) runtime and O(1) space complexities");
    System.out.println("mySqrt2(2) = " + mySqrt2(2)); // 2
    System.out.println("mySqrt2(8) = " + mySqrt2(8)); // 2
    System.out.println("mySqrt2(2147395600) = " + mySqrt2(2147395600)); // 46340
  }
}
