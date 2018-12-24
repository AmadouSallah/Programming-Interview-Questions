/* Determine whether an integer is a palindrome. Do this without extra space. */

public class IsPalindromeNumber {

  public static boolean isPalindrome(int x) {
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
