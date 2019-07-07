/*
Problem 557: Reverse Words in a String III
https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

Given a string, you need to reverse the order of characters in each word within
a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be
any extra space in the string.
*/

public class ReverseWordsIII {

  public static String reverseWords(String s) {
    StringBuilder result = new StringBuilder();
    StringBuilder word = new StringBuilder();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c != ' ') {
        word.append(c);
      } else { // end of a word, so reverse it then add it to result
        result.append(word.reverse());
        result.append(' ');
        word.setLength(0); // reset word to empty
      }
    }
    result.append(word.reverse()); // add the last word reversed
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("Let's take LeetCode contest"));
  }
}
