/* Determine whether an integer is a palindrome. Do this without extra space. */

public class IsPalindrome {

  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    } else if (x < 10) { // case for numbers between 0 and 9
      return true;
    } else {
      int xReversed = 0;
      int tempValue = x;
      while (tempValue > 0) {
        xReversed = xReversed * 10 + tempValue % 10;
        tempValue /= 10;
      }
      return (x == xReversed);
    }
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