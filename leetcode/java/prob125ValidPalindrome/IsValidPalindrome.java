/*
Problem 125: Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class IsValidPalindrome {
  public static boolean isValidPalindrome(String s) {

    int l = 0, r = s.length()-1;

    while (l < r) {

      while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
        l++;

      while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
        r--;

      if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
        return false;

        l++;
        r--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("isValidPalindrome(\"\"): " + isValidPalindrome(""));
    System.out.println("isValidPalindrome(\"A man, a plan, a canal: Panama\"): " + isValidPalindrome("A man, a plan, a canal: Panama"));
    System.out.println("isValidPalindrome(\"race a car\"): " + isValidPalindrome("race a car"));
  }
}