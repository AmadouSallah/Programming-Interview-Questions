/*
https://leetcode.com/problems/sort-colors/description/

Leetcode Problem 75: Sort Colors

Given an array with n objects colored red, white or blue, sort them so that objects of the same color
are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.
*/

public class SortColors {
  public static void sortColors(int[] nums) {
    int n = nums.length, min = 0, max = 2;
    // min = smallest value in nums, and max = largest value in nums
    int[] countArray = new int[3]; // int[max-min+1]

    for (int i = 0; i < n; i++) {
      int index = nums[i]-min;
      countArray[index]++;
    }

    int j = 0;
    for (int i = min; i <= max; i++) {
      int index = i-min;
      while (countArray[index] > 0) {
        nums[j++] = i;
        countArray[index]--;
      }
    }
  }


// Resources: https://www.udemy.com/data-structures-and-algorithms-deep-dive-using-java/learn/v4/t/lecture/8435800?start=0
