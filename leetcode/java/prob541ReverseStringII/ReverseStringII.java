/*
Leetcode Problem 541. Reverse String II
https://leetcode.com/problems/reverse-string-ii/description/

Given a string and an integer k, you need to reverse the first k characters for
every 2k characters counting from the start of the string. If there are less than k
characters left, reverse all of them. If there are less than 2k but greater than or
equal to k characters, then reverse the first k characters and left the other as original.

Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

*/

/*
   0            k           2k          3k
   |-----------|-----------|-----------|---
   +--reverse--+           +--reverse--+
*/

public class ReverseStringII {
  public static String reverseString(String s, int k) {
    char[] arr = s.toCharArray();
    int n = arr.length;
    for (int i = 0; i < n; i += 2*k) {
      int left = i, right = Math.min(i+k-1, n-1);
      while (left < right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }
    return new String(arr);
  }

  public static void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println("reverseString(\"abcdefg\", 2) = "+ reverseString("abcdefg", 2));
  }
}
