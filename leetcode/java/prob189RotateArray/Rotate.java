/*
Problem 189: Rotate Array

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II
*/


public class Rotate {
  /*
  Solution 1: O(n) runtime and O(n) space.
  We use an extra array whose element at index (i+k)%n will be nums[i].
  We then copy this array back to the original array nums.
  */
  public static void rotate(int[] nums, int k) {
    int n = nums.length;
    int[] tempArray = new int[n];

    for (int i = 0; i < n; i++) {
      int j = (i + k) % n;
      tempArray[j] = nums[i];
    }

    for (int i = 0; i < n; i++)
      nums[i] = tempArray[i];
  }

  /*
  Solution 2: O(n) runtime and O(1) space
  We first reverse all the array elements. We then reverse the first k elements;
  Finally we reverse the last n-k elements where n is the length of the array
  */
  public static void rotate2(int[] nums, int k) {
    int n = nums.length;
    reverse(nums, 0, n-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, n-1);
  }

  public static void reverse(int[] nums, int left, int right) {
    while (left < right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;

      left++;
      right--;
    }
  }

  public static String print(int[] arr) {
    String s = "[";
    int n = arr.length;
    for (int i = 0; i < n-1; i++)
      s += arr[i] + ", ";
    s += (n > 0) ? (arr[n-1] + "]") : "]";
    return s;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1,2,3,4,5,6,7};
    System.out.println("Initially, arr = " + print(arr));
    rotate(arr, 3);
    System.out.println("After rotating by 3, arr = " + print(arr));

    System.out.println("Using Solution 2:");
    int[] arr2 = new int[] {1,2,3,4,5,6};
    System.out.println("Initially, arr2 = " + print(arr2));
    rotate2(arr2, 2);
    System.out.println("After rotating by 2, arr2 = " + print(arr2));
  }
}