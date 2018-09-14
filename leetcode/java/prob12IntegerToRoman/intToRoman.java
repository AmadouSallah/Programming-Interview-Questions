/*
Leetcode Problem 12: Integer to Roman

https://leetcode.com/problems/integer-to-roman/description/

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:
Input: 3
Output: "III"

Example 2:
Input: 4
Output: "IV"

Example 3:
Input: 9
Output: "IX"

Example 4:
Input: 58
Output: "LVIII"
Explanation: C = 100, L = 50, XXX = 30 and III = 3.

Example 5:
Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/

public class IntToRoman {

  public static String intToRoman(int num) {
    int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder sb = new StringBuilder();
    int i = 0;

    while (num > 0) {
      if (num - values[i] >=0) {
        sb.append(romans[i]);
        num -= values[i];
      } else {
        i++;
      }
    }
    return sb.toString();
  }

  public static String printArray(int[] arr) {
    String s = "[";
    int n = arr.length;
    for (int i = 0; i < n-1; i++)

      s += arr[i] + ", ";
    s += (n > 0) ? (arr[n-1] + "]") : "]";
    return s;
  }

  public static void main(String[] args) {
    System.out.println("intToRoman(3) = " + intToRoman(3)); // "III"
    System.out.println("intToRoman(4) = " + intToRoman(4)); // "IV"
    System.out.println("intToRoman(9) = " + intToRoman(9)); // "IX"
    System.out.println("intToRoman(58) = " + intToRoman(58)); // "LVIII"
    System.out.println("intToRoman(1994) = " + intToRoman(1994)); // "MCMXCIV"
  }
}

// Resources: https://www.youtube.com/watch?v=LBsvAwQbVdw
