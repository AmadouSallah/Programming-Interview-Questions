/*
Leetcode Problem 17: Letter Combinations of a Phone Number

https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

Given a digit string, return all possible letter combinations that the number could represent.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

import java.util.*;

public class LetterCombinations {

  public static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();

    if (digits == null || digits.length() == 0) {
      return result;
    }

    Map<Character, String> map = new HashMap<Character, String>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    traverse(digits, result, map, "", 0);

    return result;
  }

  public static void traverse(String digits, List<String> result, Map<Character, String> map, String path, int level) {

    if (path.length() == digits.length()) {
      result.add(path);
      return;
    }

    String s = map.get(digits.charAt(level));

    for (int i = 0; i < s.length(); i++) {
      String nextPath = path + s.charAt(i);
      traverse(digits, result, map, nextPath, level+1);
    }
  }


  public static void main(String[] args) {
    System.out.println("letterCombinations(null) = " + letterCombinations(null));
    System.out.println("letterCombinations(\"\") = " + letterCombinations(""));
    System.out.println("letterCombinations(\"2\") = " + letterCombinations("2"));
    System.out.println("letterCombinations(\"23\") = " + letterCombinations("23") );
    System.out.println("letterCombinations(\"239\")  " + letterCombinations("239"));
  }

}
