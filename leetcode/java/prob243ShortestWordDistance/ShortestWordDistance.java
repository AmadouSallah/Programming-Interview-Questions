/*
Problme 243. Shortest Word Distance

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

public class ShortestWordDistance {
  // Brute Force: O(n^2) runtime and O(1) space
  public static int shortestDistance(String[] words, String word1, String word2) {
    int n = words.length, minDistance = n;
    for (int i = 0; i < n; i++) {
      if (words[i].equals(word1)) {
        for (int j = 0; j < n; j++) {
          if (words[j].equals(word2)) {
              minDistance = Math.min(minDistance, Math.abs(i-j));
          }
        }
      }
    }
    return minDistance;
  }

  public static void main(String[] args) {
    String[] arr = {"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "coding", word2 = "practice", word3 = "makes";
    System.out.println("shortestDistance([\"practice\", \"makes\", \"perfect\", \"coding\", \"makes\"]), \"coding\", \"practice\") = " + shortestDistance(arr, word1, word2));
    System.out.println("shortestDistance([\"practice\", \"makes\", \"perfect\", \"coding\", \"makes\"]), \"makes\", \"coding\") = " + shortestDistance(arr, word3, word1));
  }

}
