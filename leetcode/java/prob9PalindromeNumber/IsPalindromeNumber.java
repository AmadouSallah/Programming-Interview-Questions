/* Determine whether an integer is a palindrome. Do this without extra space. */

/*
Runtime is log base 10 of n, where n is the length of input x
Edge cases: x is not a palindrome if (1) x < 0, (2) x ends with 0 but x!=0
Example, if x = 110 is not a palindrome but x=0 is a palindrome.

We initially set xReversed to 0.
In each iteration, we take the last digit of x and append it to xReversed by
setting xReversed = xReversed + <last_digit_of_x>. We also set x to x/10.
We go from right of input x and stop at the middle. How do we know we have
reached the middle?
Since in each iteration we divide x by 10 and multiply xReversed by 10,
when x <= xReversed means we've processed half of the digits in x.

Example 1: x = 1221,
  1st iteration: xReversed = 1, x = 122
  2nd iteration: xReversed = 12, x = 12
  We stop the iteration here since (x <= xReversed)
At the end of the iteration, x = xReversed

Example 2: x = 12321,
  1st iteration: xReversed = 1, x = 1232
  2nd iteration: xReversed = 12, x = 123
  3rd iteration: xReversed = 123, x = 12
  We stop the iteration here since (x <= xReversed)
  At the end of the iteration, x = xReversed/10 (remove last digit)

So if the number of digits in x is even, at the end x = xReversed.
Otherwise, x = xReversed/10.

Resources: https://leetcode.com/problems/palindrome-number/solution/
*/

public class IsPalindromeNumber {
  // Runtime: O(log(n)), log base 10 of n where n is the length of input x
  //  Space: O(1)
  public static boolean isPalindrome(int x) {    
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;

    int xReversed = 0;
    while (x > xReversed) {
      xReversed = xReversed * 10 + x % 10;
      x /= 10;
    }

    return (x == xReversed) || (x == xReversed / 10);
  }

  public static boolean isPalindrome2(int x) {
    if (x < 0) return false;
    if (x < 10) return true; // 0 <= x <= 9

    int xRev = 0; // x reversed
    for (int y = x; y > 0; y /= 10) {
      xRev = xRev * 10 + y % 10;
    }
    return x == xRev;
  }

  public static void main(String[] args) {
    System.out.println("isPalindrome(-1): " + isPalindrome(-1));
    System.out.println("isPalindrome(1): " + isPalindrome(1));
    System.out.println("isPalindrome(12): " + isPalindrome(12));
    System.out.println("isPalindrome(123): " + isPalindrome(123));
    System.out.println("isPalindrome(12321): " + isPalindrome(12321));
    System.out.println("isPalindrome(11): " + isPalindrome(11));
    System.out.println("isPalindrome(121): " + isPalindrome(121));
  }
}
