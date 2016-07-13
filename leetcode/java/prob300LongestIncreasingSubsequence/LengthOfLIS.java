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

  // 0(n^2) time complexity
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

  // 0(nlogn) time complexity
  // Resources: http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
  public static int lengthOfLIS2(int[] nums) {

    if (nums == null || nums.length == 0) return 0;

    int n = nums.length;
    int[] result = new int[n];
    result[0] = nums[0];
    int len = 1;

    for (int i = 1; i < n; i++) {
      int currentElement = nums[i];

      if (currentElement <= result[0]) {
        result[0] = currentElement;
      } else if (currentElement > result[len-1]) {
        result[len++] = currentElement;
      } else {
        int position = binarySearch(result, currentElement, 0, len-1);
        result[position] = currentElement;
      }
    }

    printArray(result, 0, len-1);

    return len;
  }

  public static int binarySearch(int[] arr, int target, int start, int end) {

    int leftIndex = start, rightIndex = end;

    while (rightIndex - leftIndex > 1 ) {
      int middleIndex = (leftIndex + rightIndex) / 2;
      int middleElement = arr[middleIndex];

      if (middleElement == target) {
        return middleIndex;
      } else if (middleElement < target) {
        leftIndex = middleIndex;
      } else {
        rightIndex = middleIndex;
      }
    }
    return rightIndex;
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

  // Prints part of an array, from index 'from' to index 'to'
  public static void printArray(int[] arr, int from, int to) {
    String result = "[";
    int len = arr.length;
    for (int i = from; i <= to; i++) {
      result += arr[i];
      if (i < to)
        result += ", ";
    }
    result += "]";
    System.out.println(result);
  }

  public static void main(String[] args) {
    int[] arr1 = {10, 9, 2, 5, 3, 7, 101, 18};
    int[] arr2 = {-2, -1};

    //Testing lengthOfLIS
    System.out.println("#####Testing the first solution with 0(n^2) running time.#####\n");
    System.out.print("Array1 = ");
    printArray(arr1);
    System.out.print("The lenght of the Longest Increasing Subsequence for Array1 is: ");
    System.out.println(lengthOfLIS(arr1));
    System.out.print("The actual Longest Increasing Subsequence for Array1 is: ");
    lengthOfLIS2(arr1);

    System.out.print("\nArray2 = ");
    printArray(arr2);
    System.out.print("The lenght of the Longest Increasing Subsequence for Array2 is: ");
    System.out.println(lengthOfLIS(arr2));
    System.out.print("The actual Longest Increasing Subsequence for Array2 is: ");
    lengthOfLIS2(arr2);

  }
}