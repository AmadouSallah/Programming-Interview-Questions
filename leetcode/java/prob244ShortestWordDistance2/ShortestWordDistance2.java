/*
Problem 244. Shortest Word Distance II

This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words
and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes
two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/


/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ShortestWordDistance2 {

  Map<String, List<Integer>> hmap;

  public ShortestWordDistance2(String[] words) {
    hmap = new HashMap<>();
    int n = words.length;

    for (int i = 0; i < n; i++) {
      String word = words[i];
      if (hmap.containsKey(word)) {
        List<Integer> currentList = hmap.get(word);
        currentList.add(i);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        hmap.put(word, list);
      }
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> list1 = hmap.get(word1), list2 = hmap.get(word2);
    int minDistance = Integer.MAX_VALUE;
    int index1 = 0, index2 = 0, n1 = list1.size(), n2 = list2.size();

    while (index1 < n1 && index2 < n2) {
      int i1 = list1.get(index1), i2 = list2.get(index2), currentDistance = Math.abs(i1 - i2);
      minDistance = Math.min(minDistance, currentDistance);

      // Since we want the smallest distance, we increment the smallest between index1 and index2.
      // This would make currentDistance smaller
      if (i1 < i2) index1++;
      else index2++;
    }
    return minDistance;
  }
}
