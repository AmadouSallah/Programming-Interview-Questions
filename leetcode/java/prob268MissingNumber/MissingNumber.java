/*
Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it
using only constant extra space complexity?
*/

public class MissingNumber {

  public static int missingNumber(int[] nums) {
    int n = nums.length, result = 0;
    for (int i = 0; i < n; i++)
      result = result ^ nums[i] ^ i;

    return result ^ n;
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
    System.out.print(result);
  }

  public static void main(String[] args) {
    int[] arr1 = {0};
    int[] arr2 = {1};
    int[] arr3 = {0, 1, 3};
    int[] arr4 = {4, 2, 1, 3};

    System.out.print("For arr1 = ");
    printArray(arr1);
    System.out.println(", the missing number is " + missingNumber(arr1));

    System.out.print("For arr2 = ");
    printArray(arr2);
    System.out.println(", the missing number is " + missingNumber(arr2));

    System.out.print("For arr3 = ");
    printArray(arr3);
    System.out.println(", the missing number is " + missingNumber(arr3));

    System.out.print("For arr4 = ");
    printArray(arr4);
    System.out.println(", the missing number is " + missingNumber(arr4));

  }
}