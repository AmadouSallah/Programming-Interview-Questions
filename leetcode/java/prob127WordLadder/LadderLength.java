/*
Leetcode Problem 127: Word Ladder
https://leetcode.com/problems/word-ladder/description/

Given two words (beginWord and endWord), and a dictionary's word list, find the length
of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
  Return 0 if there is no such transformation sequence.
  All words have the same length.
  All words contain only lowercase alphabetic characters.
  You may assume no duplicates in the word list.
  You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

import java.util.*;

public class LadderLength {

  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) return 0;
    wordList.add(beginWord);

    Map<String, List<String>> graph = new HashMap<>();
    // initialize graph hash map with every word in wordList as key and value of empty array list
    for (String word : wordList)
      graph.put(word, new ArrayList<>());

    // For every key word, another word is an edge if they differ by only 1 character
    int n = wordList.size();
    for (int i = 0; i < n; i++) {
      String word1 = wordList.get(i);
      for (int j = i+1; j < n; j++) {
        String word2 = wordList.get(j);
        // if the 2 words differ by 1 char, each gets added to the other's edges
        if (differByOneChar(word1, word2)) {
          graph.get(word1).add(word2);
          graph.get(word2).add(word1);
        }
      }
    }

    Queue<Tuple> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.add(new Tuple(beginWord, 1));
    visited.add(beginWord);

    Tuple currentTuple;

    while(!queue.isEmpty()) {
      currentTuple = queue.remove();
      String currentWord = currentTuple.key;
      int level = currentTuple.value; // represents the distance between beginWord and currentWord

      // if the currentWord is endWord, we are done and return level (distance between the 2)
      if (currentWord.equals(endWord)) return level;

      /* We go through all the neighbors of currentWord. If any of them has not been seen,
      we add it to the visited set and to the queue as a Tuple (value = level+1 since
      distace from beginWord will increment by 1) */
      List<String> neighbors = graph.get(currentWord);
      for (String neighbor : neighbors) {
        if (!visited.contains(neighbor)) {
          queue.add(new Tuple(neighbor, level+1));
          visited.add(neighbor);
        }
      }
    }
    // if we go through all the words and can't get to endWord, we return 0
    return 0;
  }

  public static boolean differByOneChar(String word1, String word2) {
    if (word1.length() != word2.length()) return false;
    int diff = 0, n = word1.length();
    for (int i = 0; i < n; i++) {
      if (word1.charAt(i) != word2.charAt(i)) diff++;
      if (diff > 1) return false;
    }
    return diff == 1;
  }

  public static class Tuple {
    String key;
    int value;

    public Tuple (String key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));

    System.out.println("ladderLength(\"hit\", \"cog\", [\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]) = " + ladderLength("hit", "cog", list));
    System.out.println("ladderLength(\"hit\", \"pen\", [\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]) = " + ladderLength("hit", "pen", list));
    System.out.println("ladderLength(\"hit\", \"hit\", [\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]) = " + ladderLength("hit", "hit", list));
    System.out.println("ladderLength(\"hit\", \"hot\", [\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]) = " + ladderLength("hit", "hot", list));

  }
}
