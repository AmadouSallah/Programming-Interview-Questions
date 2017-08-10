/*
Problem 325: Maximum Size Subarray Sum Equals k

Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?

*/

/*
    PSEUDOCODE
We initialize sum, max, and diff to 0.
We also initialize a hashmap, hmap, whose keys are the sum of array elements from index 0 to the current index and
whose corresponding values will be the current index.

We loop through the input array nums. For each index i:
    1) We add nums[i] to sum and we set diff to sum-k
    2) If sum == k, then max is set to i+1 since the elements from index 0 to i add up to k,
        and it will be the largest subarray so far;
    3) If hmap contains diff, then that means the current sum has already been seen. In order words, at some index j before
        this current index i, sum at j is same as diff (sum - k).
        Let prevSumIndex be the index where the sum was seen, i.e. prevSumIndex = j. Then prevSumIndex = map.get(diff).
        This means that the elements from prevSumIndex + 1 to i add up to k.

        Proof:
            Assume there is a method, sum, that takes 2 integers i and j and returns the sum of array elements
            from i to j. Then we have:

            diff = sum - k = sum(0, i) - k
            Since the current sum (sum) has already been seen at index prevIndex, we have
            sum(0, i) - k = sum(0, prevIndex). But sum(0, i) = sum(0, prevIndex) + sum(prevIndex+1, i), thus we get:
            sum(0, prevIndex) + sum(prevIndex+1, i) - k = sum(0, prevIndex) => sum(prevIndex+1, i) - k = 0 =>
            sum(prevIndex+1, i) = k
            Therefore the elements from prevIndex+1 to i add up to k

        Thus max becomes the maximum between max and (i-prevSumIndex)
    4) If hmap doesn't contain sum, we add it with corresponding value the current index, i

At the end of the iteration, we return max
*/

import java.util.Map;
import java.util.HashMap;

public class MaximumSubarrayLen {
  public static int maxSubArrayLen(int[] nums, int k) {

    if (nums == null || nums.length == 0) return 0;

    int sum = 0, max = 0, n = nums.length, diff;
    Map<Integer, Integer> hmap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      sum += nums[i];
      diff = sum - k;

      if (sum == k) {
        max = i+1;
      } else if (hmap.containsKey(diff)) { // then sum has already been seen at index hmap.get(diff)
        int prevSumIndex = hmap.get(diff);
        max = Math.max(max, i - prevSumIndex); // elements from (prevSumIndex + 1) to i add up to k, so update max
      }

      if (!hmap.containsKey(sum)) {
        hmap.put(sum, i);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr1 = {1, -1, 5, -2, 3};
    int[] arr2 = {-2, -1, 2, 1};

    System.out.println("maxSubArrayLen([1, -1, 5, -2, 3], 3) = " + maxSubArrayLen(arr1, 3)); // returns 4
    System.out.println("maxSubArrayLen([-2, -1, 2, 1], 1) = " + maxSubArrayLen(arr2, 1)); // returns 2
  }
}
