/*
Writhe a program that takes an input string and returns the most frequently occuring character in the string
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class MostOccuringCharacterInString {

  public static Character mostOccuringChar(String str) {

    if (str == null || str.length() == 0) return '\0';

    String lowerCaseString = str.toLowerCase();
    char mostFrequentChar = lowerCaseString.charAt(0);
    Map<Character, Integer> hmap = new HashMap<Character, Integer>();
    Set<Character> set = new HashSet<Character>();
    int n = str.length();

    for (int i = 0;i < n; i++) {
      char currentChar = lowerCaseString.charAt(i);
      if (hmap.containsKey(currentChar)) {
        hmap.put(currentChar, hmap.get(currentChar)+1);
      } else {
        hmap.put(currentChar, 1);
      }
    }

    set = hmap.keySet();
    // System.out.println(set);
    for (Character c : set) {
      if (hmap.get(c) > hmap.get(mostFrequentChar)) {
        mostFrequentChar = c;
      }
    }

    return mostFrequentChar;
  }

  public static void main(String[] args) {
    System.out.println("input = \"\", most frequent character = " + mostOccuringChar(""));
    System.out.println("input = \"a\", most frequent character = " + mostOccuringChar("a"));
    System.out.println("input = \"aba\", most frequent character = " + mostOccuringChar("aba"));
    System.out.println("input = \"hello world!\", most frequent character = " + mostOccuringChar("hello world!"));
  }
}
