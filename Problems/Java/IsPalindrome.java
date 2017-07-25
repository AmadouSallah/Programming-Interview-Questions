public class IsPalindrome {

  public static boolean isPalindrome(String str) {

    if (str == null) return true;

    int len = str.length();

    if (len < 2) return true;

    int left = 0, right = len-1;
    while (left <= right) {
      if (str.charAt(left) != str.charAt(right))
        return false;
      left++;
      right--;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println("isPalindrome(\"null\") = " + isPalindrome(null));
    System.out.println("isPalindrome(\"\") = " + isPalindrome(""));
    System.out.println("isPalindrome(\"a\") = " + isPalindrome("a"));
    System.out.println("isPalindrome(\"aa\") = " + isPalindrome("aa"));
    System.out.println("isPalindrome(\"aba\") = " + isPalindrome("aba"));
    System.out.println("isPalindrome(\"abba\") = " + isPalindrome("aba"));
    System.out.println("isPalindrome(\"madam\") = " + isPalindrome("madam"));
    System.out.println("isPalindrome(\"ab\") = " + isPalindrome("ab"));
    System.out.println("isPalindrome(\"abc\") = " + isPalindrome("abc"));
  }
}