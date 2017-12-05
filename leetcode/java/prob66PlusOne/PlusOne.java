/*

From https://leetcode.com/problems/plus-one/description/

Leetcode Problem 66: Plus one

Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class PlusOne {

  public int[] plusOne(int[] digits) {
    int n = digits.length;
    for (int i = n-1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    int[] result = new int[n+1];
    result[0] = 1;
    return result;
  }

}
