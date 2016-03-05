/*
Given an unsorted array of integers, find the length of the longest
consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

import java.util.HashSet;

public class LongestConsecutiveSequence {

  public static int longestConsecutive(int[] nums) {

    if (nums == null || nums.length == 0) {
      return 0;
    }

    int n = nums.length;
    HashSet<Integer> hashSet = new HashSet<Integer>();

    /* Put the elements of nums into hashSet, no duplicate elements allowed for HashSet */
    for (int i = 0; i < n; i++) {
      hashSet.add(nums[i]);
    }

    int maximumLenght = 0;

    /* For each element of nums, we check to see if it is a starting
    point of a subsequence; i.e. nums doesn't contain nums[i]-1.
    We do so by checking if hashSet doesn't contain nums[i]-1.
    If it is the 1st element, we count the number of elements  consecutive starting with currentElement */
    for (int i = 0; i < n; i++) {
      int currentElement = nums[i];
      int previousElement = currentElement - 1;

      /* If previous element is not in the hashSet */
      if (!hashSet.contains(previousElement)) {
        int count = 1; /* We start counting with currentElement */
        int next = currentElement + 1;

        /* We increment count as long as next is in hashSet */
        while (hashSet.contains(next)) {
          count++;
          next++;
        }

        maximumLenght = Math.max(maximumLenght, count);
      }
    }
    return maximumLenght;
  }

  /* Testing the code above */
  public static void main(String[] args) {
    int[] nums1 = {};
    int[] nums2 = {1};
    int[] nums3 = {100, 4, 200, 1, 3, 2};
    int[] nums4 = null;

    System.out.println(longestConsecutive(nums1));
    System.out.println(longestConsecutive(nums2));
    System.out.println(longestConsecutive(nums3));
    System.out.println(longestConsecutive(nums4));
  }
}