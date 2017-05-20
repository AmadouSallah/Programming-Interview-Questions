/*
Problem 269: Alien Dictionary

There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules
of this new language. Derive the order of letters in this language.

Example 1:
Given the following words in dictionary,

["wrt", "wrf", "er", "ett", "rftt"]
The correct order is: "wertf".

Example 2:
Given the following words in dictionary,

["z", "x"]
The correct order is: "zx".

Example 3:
Given the following words in dictionary,

["z", "x", "z"]
The order is invalid, so return "".

Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/

import java.util.*;

public class AlienOrder {

  public static String alienOrder(String[] words) {

    String result = "";
    if (words == null || words.length == 0) return result;

    Map<Character, Integer> indegreeMap = new HashMap<>();
    Map<Character, Set<Character>> map = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();

    // Let's put each character in indegreeMap with value of 0
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        indegreeMap.put(c, 0);
      }
    }

    /*
    We compare 2 adjacent words at a time. We look for the 1st 2 characters that differ in these 2 words,
    say c1 in the first word and c2 in the 2nd.
    Then for key c1 in map, we add c2 (if not already present) to the set that correspond to the value of c1
    We then do the same for the next 2 adjacent words until the end of the input array. 
    */
    for (int i = 0; i < words.length-1; i++) {
      String currentWord = words[i], nextWord = words[i+1];
      int minLen = Math.min(currentWord.length(), nextWord.length());
      for (int j = 0; j < minLen; j++) {
        char c1 = currentWord.charAt(j), c2 = nextWord.charAt(j);
        if (c1 != c2) { // then c1 comes before c2 in the dictionary
          Set<Character> set = new HashSet<>();
          if (map.containsKey(c1)) set = map.get(c1);
          if (!set.contains(c2)) {
            set.add(c2);
            map.put(c1, set);
            indegreeMap.put(c2, indegreeMap.get(c2)+1);
          }
          break; // we break so that we can skip to the next consecutive 2 words
        }
      }
    }

    // Now we use Kahn's algorithm for topologica sorting
    for (char c : indegreeMap.keySet()) {
      if (indegreeMap.get(c) == 0) queue.add(c);
    }

    while (!queue.isEmpty()) {
      char c = queue.poll();
      result += c;
      if (map.containsKey(c)) {
        for (char c2 : map.get(c)) {
          int updatedIndegree = indegreeMap.get(c2) - 1;
          indegreeMap.put(c2, updatedIndegree);
          if (updatedIndegree == 0) queue.add(c2);

        }
      }
    }
    // if there is a cycle, we return the empty string
    if (result.length() != indegreeMap.size()) return "";

    return result;
  }

  public static void main(String[] args) {
    String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
    String[] words2 = {"z", "x"};
    String[] words3 = {"z", "x", "z"};

    System.out.println("alienOrder([\"wrt\", \"wrf\", \"er\", \"ett\", \"rftt\"]) = " + alienOrder(words1));
    System.out.println("alienOrder([\"z\", \"x\"]) = " + alienOrder(words2));
    System.out.println("alienOrder([\"z\", \"x\", \"z\"]) = " + alienOrder(words3));
  }
}
