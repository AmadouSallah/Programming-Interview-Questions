/*
Leetcode Problem 347: Top K Frequent Elements

https://leetcode.com/problems/top-k-frequent-elements/description/

Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;

public class TopKFrequentElements {

  // O(n log(k)) runtime and O(n) space (to store hash map)
  public static List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums)
      map.put(num, map.getOrDefault(num, 0)+1);

    // initialize minHeap where the less frequent element comes first
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

    // keep k top frequent elements in the min heap
    for (int key : map.keySet()) {
      minHeap.add(key);
      if (minHeap.size() > k) // minHeap now has k+1 elements
        minHeap.poll(); // remove the less frequent one out of the k+1 elements
    }

    while (!minHeap.isEmpty())
      result.add(minHeap.poll());

    // reverse the order of result to decreasing (high to low)
    Collections.reverse(result);

    return result;
  }

  public static void main(String[] args) {
    int[] nums1 = {1,1,1,2,2,3}, nums2 = {1};
    System.out.println("topKFrequent([1,1,1,2,2,3], 2) = " + topKFrequent(nums1, 2));
    System.out.println("topKFrequent([1], 1) = " + topKFrequent(nums2, 1));
  }
}
// Resources: https://leetcode.com/problems/top-k-frequent-elements/solution/
