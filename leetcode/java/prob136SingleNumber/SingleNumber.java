/*
Single Number
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
*/

public class SingleNumber {

  public static int singleNumber(int[] nums) {
    int n = nums.length, result = 0;
    for (int i = 0; i < n; i++) {
      result ^= nums[i];
    }
    return result;
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
    int[] arr1 = {3};
    int[] arr2 = {1, 2, -4, 1, 2};
    int[] arr3 = {7, 0, 7};

    System.out.print("For arr1 = ");
    printArray(arr1);
    System.out.println(", the single number is " + singleNumber(arr1));

    System.out.print("For arr2 = ");
    printArray(arr2);
    System.out.println(", the single number is " + singleNumber(arr2));

    System.out.print("For arr3 = ");
    printArray(arr3);
    System.out.println(", the single number is " + singleNumber(arr3));

  }

}
