/*
Power Of Two

Given an integer, write a function to determine if it is a power of two.
*/

/*
  PSEUDOCODE:

  If a number is a power of 2, its binary representation has only
  1 set digit in it; all the other remaining digits are 0. So if
  we removed this set digit, the number becomes 0.
  For a given number n, to remove the 1st set digit (from the right),
  we just do: n & (n-1).

  Example:
  5 & 4 = 101 & 100 = 100
  4 & 3 = 100 & 011 = 0
  1 & 0 == 01 & 00 = 0
  etc...

  Our algorithm for isPowerOfTwo is as follows:
    If the input n is less than 1, we return false.
    Otherwise, we check the value of n & (n-1); if this value is 0,
    we return true, else we return false.
*/
public class IsPowerOfTwo {
  public static boolean isPowerOfTwo(int n) {
    if (n < 1) return false;
    else return ( (n & (n - 1) ) == 0);
  }

  public static void main(String[] args) {

    System.out.println("isPowerOfTwo(-1): " + isPowerOfTwo(-1));
    System.out.println("isPowerOfTwo(0): " + isPowerOfTwo(0));
    System.out.println("isPowerOfTwo(1): " + isPowerOfTwo(1));
    System.out.println("isPowerOfTwo(2): " + isPowerOfTwo(2));
    System.out.println("isPowerOfTwo(3): " + isPowerOfTwo(3));
    System.out.println("isPowerOfTwo(256): " + isPowerOfTwo(256));
    System.out.println("isPowerOfTwo(568): " + isPowerOfTwo(568));
    }
}