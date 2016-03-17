/*
Longest Increasing Subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
Note that there may be more than one LIS combination, it is only necessary for
you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

import java.util.Arrays;

public class LengthOfLIS {

  public static int lengthOfLIS(int[] nums) {

    if (nums == null || nums.length == 0) return 0;

    int len = nums.length;

    if (len == 1) return 1;

    int[] tempArray = new int[len];
    Arrays.fill(tempArray, 1);

    for (int i = 1; i < len; i++) {
      for(int j = 0; j < i; j++) {
        if (nums[i] > nums[j])
          tempArray[i] = Math.max(tempArray[i], tempArray[j]+1);
      }
    }

    int max = 1;
    for (int i = 0; i < len; i++) {
      max = Math.max(max, tempArray[i]);
    }
    return max;
  }

  public static void printArray(int[] arr) {
    String result = "[";
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      result += arr[i];
      if (i < len-1)
        result += ", ";
    }
    result += "]";
    System.out.println(result);
    }

  public static void main(String[] args) {
    int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
    printArray(arr);
    System.out.println(lengthOfLIS(arr));

    int[] arr1 = {-2, -1};
    printArray(arr1);
    System.out.println(lengthOfLIS(arr1));
  }
}