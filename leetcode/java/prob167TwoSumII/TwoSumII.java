/*
Leetcode Problem 167: Two Sum II - Input array is sorted

https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

Given an array of integers that is already sorted in ascending order,
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that
they add up to the target, where index1 must be less than index2.

Note:
Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]

Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/

public class TwoSumII {
  public static int[] twoSumII(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2) return new int[0];
    int n = numbers.length, left = 0, right = n-1, sum = 0;
    while (left < right) {
      sum = numbers[left] + numbers[right];
      if (sum == target) {
        return new int[] {left+1, right+1};
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return new int[0];
  }

  public static String printArray(int[] arr) {
    String s = "[";
    int n = arr.length;
    for (int i = 0; i < n-1; i++)

      s += arr[i] + ", ";
    s += (n > 0) ? (arr[n-1] + "]") : "]";
    return s;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {2,7,11,15};
    System.out.println("twoSumII([2,7,11,15], 9) = " + printArray(twoSumII(arr, 9)));
  }
}
