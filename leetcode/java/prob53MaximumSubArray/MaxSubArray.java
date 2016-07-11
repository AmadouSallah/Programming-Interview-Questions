/*
Maximum Subarray

Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

// We will solve it using Kadane's algorithm

public class MaxSubArray {
  public static int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0)
      throw new IllegalArgumentException("Null or Empty imput array is not allowed!");

    int n = nums.length, max = nums[0], currentMax = nums[0];
    for (int i = 1; i < n; i++) {
      int elt = nums[i];
      currentMax = Math.max(elt, currentMax + elt);
      max = Math.max(max, currentMax);
    }

    return max;
  }

  public static void main(String[] args) {
    // System.out.println("maxSubArray(null) = " + maxSubArray(null));
    // System.out.println("maxSubArray(new int[] {}) = " + maxSubArray(new int[] {}));
    System.out.println("maxSubArray(new int[] {1} = " + maxSubArray(new int[] {1}));
    System.out.println("maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4} = " + maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    System.out.println("maxSubArray(new int[] {-8,-2,-3,-10,-5} = " + maxSubArray(new int[] {-8,-2,-3,-10,-5}));
  }
}