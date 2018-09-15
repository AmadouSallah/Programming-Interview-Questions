/*
Leetcode Problem 13: Roman to Integer

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

Roman numerals are usually written largest to smallest from left to right. However, the numeral for
four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making
four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

  I can be placed before V (5) and X (10) to make 4 and 9.
  X can be placed before L (50) and C (100) to make 40 and 90.
  C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:
Input: "III"
Output: 3

Example 2:
Input: "IV"
Output: 4

Example 3:
Input: "IX"
Output: 9

Example 4:
Input: "LVIII"
Output: 58
Explanation: C = 100, L = 50, XXX = 30 and III = 3.

Example 5:
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

import java.util.Map;
import java.util.HashMap;

public class RomanToInt {

  public static int romanToInt(String s) {
    if (s == null || s.length() == 0) return 0;

    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int n = s.length(), res = map.get(s.charAt(n-1));
    for (int i = n-2; i >=0; i--) {
      int curr = map.get(s.charAt(i)), next = map.get(s.charAt(i+1));
      if (curr >= next) {
        res += curr;
      } else {
        res -= curr;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("romanToInt(\"III\") = " + romanToInt("III")); // 3
    System.out.println("romanToInt(\"IV\") = " + romanToInt("IV")); // 4
    System.out.println("romanToInt(\"IX\") = " + romanToInt("IX")); // 9
    System.out.println("romanToInt(\"LVIII\") = " + romanToInt("LVIII")); // 58
    System.out.println("romanToInt(\"MCMXCIV\") = " + romanToInt("MCMXCIV")); // 1994
  }
}
