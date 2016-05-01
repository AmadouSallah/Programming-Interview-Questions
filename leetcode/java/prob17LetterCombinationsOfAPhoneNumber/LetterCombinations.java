/*
Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

import java.util.*;

public class LetterCombinations {

  public static List<String> letterCombinations(String digits) {

    List<String> result = new ArrayList<String>();

    if (digits == null || digits.length() == 0) {
      return result;
    }

    int len = digits.length();
    char[] charArray = new char[len];
    Map<Character, String> hmap = new HashMap<Character, String>();
    hmap.put('2', "abc");
    hmap.put('3', "def");
    hmap.put('4', "ghi");
    hmap.put('5', "jkl");
    hmap.put('6', "mno");
    hmap.put('7', "pqrs");
    hmap.put('8', "tuv");
    hmap.put('9', "wxyz");

    helper(digits, result, charArray, hmap, 0);

    return result;
  }

  private static void helper(String digits, List<String> result, char[] charArray, Map<Character, String> hmap, int index) {

    if ( index == digits.length() ) {
      result.add(new String(charArray));
      return;
    }

    char currentDigit = digits.charAt(index);
    String currentString = hmap.get(currentDigit);
    int len = currentString.length();

    for (int i = 0; i < len; i++) {
      charArray[index] = currentString.charAt(i);
      helper(digits, result, charArray, hmap, index+1);
    }
  }

  public static String display(List<String> arr) {
    String s = "[";
    int n = arr.size();
    for (int i = 0; i < n; i++) {
      s += arr.get(i);
      if (i < n - 1)
        s += ", ";
    }
    s += "]";
    return s;
  }

  public static void main(String[] args) {
    System.out.print("letterCombinations(null) = ");
    System.out.println(display(letterCombinations(null)));

    System.out.print("letterCombinations(\"\") = ");
    System.out.println(display(letterCombinations("")));

    System.out.print("letterCombinations(\"2\") = ");
    System.out.println(display(letterCombinations("2")));

    System.out.print("letterCombinations(\"23\") = ");
    System.out.println(display(letterCombinations("23")));

    System.out.print("letterCombinations(\"239\") = ");
    System.out.println(display(letterCombinations("239")));
  }

}