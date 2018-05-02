/*
Leetcode Problem 344: Reverse String

https://leetcode.com/problems/reverse-string/description/

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/

public class ReverseString {
  public static String reverseString(String s) {
    char[] charArray = s.toCharArray();
    int left = 0, right = s.length()-1;

    while (left < right) {
      char temp = charArray[left];
      charArray[left] = charArray[right];
      charArray[right] = temp;

      left++;
      right--;
    }

    return new String(charArray);
  }

  public static void main(String[] args) {
    System.out.println("reverseString(\"hello\") = " + reverseString("hello"));
  }
}
