/*
Leetcode Problem 692: Top K Frequent words
https://leetcode.com/problems/top-k-frequent-words/description/

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.

*/

import java.util.*;

public class TopKFrequentWords {
    // Using sorting: O(n log n) runtime and O(n) space complexities
    public static List<String> topKFrequent(String[] words, int k) {

        List<String> result;
        Map<String, Integer> map = new HashMap<>();

        // Add all the words to map with frequency
        for (String word : words) {
            // if (map.containsKey(word)) {
            //     map.put(word, map.get(word)+1);
            // } else {
            //     map.put(word, 1);
            // }
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        result = new ArrayList(map.keySet());

        // if 2 words have the same frequency, then we compare based on their keys using string comparison;
        // otherwise, we compare based on the values of their keys (frequency)
        Collections.sort(result, (s1, s2) -> map.get(s1).equals(map.get(s2)) ? s1.compareTo(s2) : map.get(s2)-map.get(s1));

        // System.out.println(map);
        // System.out.println(result);
        return result.subList(0, k); // return the 1st k elements
    }

    /*
    Solution 2: Using a Heap (min heap)

    We count the frequency of each word, and then add it to the heap that stores the best k
    candidates (i.e. we store the worst candidates at the top of heap).
    We then pop the heap k and put the items to the result list.
    Finally, we reverse result and then return it

    Runtime complexity: O(n log k)  where n = length of words. We count the frequency of each word in O(n) times,
    we add n words to the heap in (O(log k)) time. We then pop from heap k times. Thus runtime = O(n log k)
    Space complexity: O(k) (we only store the best k words - those in the heap.
    */

    public static List<String> topKFrequent2(String[] words, int k) {
      List<String> result = new ArrayList<>();
      Map<String, Integer> map = new HashMap<>();

      for (String word : words)
        map.put(word, map.getOrDefault(word, 0)+1);

      PriorityQueue<String> heap = new PriorityQueue<String>( (w1, w2) ->  map.get(w1) == map.get(w2) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));

      for (String word : map.keySet()) {
        heap.add(word); // same as heap.offer()
        if (heap.size() > k) {
            heap.poll();
        }
      }

      // At this point, the heap contais the top k candidates. We now add these candidates to result and reverse it
      while(!heap.isEmpty()) {
          result.add(heap.poll());
      }

      Collections.reverse(result);

      return result;
  }

  public static void main(String[] args) {
    String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
    System.out.println("Solution using sorting:");
    System.out.println("topKFrequent([\"i\", \"love\", \"leetcode\", \"i\", \"love\", \"coding\"], 2) = " + topKFrequent(words, 2));

    System.out.println("\nSolution using a heap:");
    System.out.println("topKFrequent2([\"i\", \"love\", \"leetcode\", \"i\", \"love\", \"coding\"], 2) = " + topKFrequent2(words, 2));
  }
}
