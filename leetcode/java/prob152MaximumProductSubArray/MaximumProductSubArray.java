/*
Problem 152: Maximum Product

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

*/

public class MaximumProductSubArray {

  public static int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;

    int len = nums.length;

    int[] positiveProducts = new int[len];
    int[] negativeProducts = new int[len];
    int[] maxProducts = new int[len];

    positiveProducts[0] = nums[0];
    negativeProducts[0] = nums[0];
    maxProducts[0] = nums[0];

    int x, y;

    for (int i = 1; i < len; i++) {
      x = positiveProducts[i-1] * nums[i];
      y = negativeProducts[i-1] * nums[i];

      positiveProducts[i] = Math.max(Math.max(x, y), nums[i]);
      negativeProducts[i] = Math.min(Math.min(x, y), nums[i]);
      maxProducts[i] = Math.max(maxProducts[i-1], positiveProducts[i]);
    }

    return maxProducts[len-1];
}

    public static void main(String[] args) {
      System.out.println("maxProduct(new int[] {-2}) = " +maxProduct(new int[] {-2}));
      System.out.println("maxProduct(new int[] {2}) = " +maxProduct(new int[] {2}));
      System.out.println("maxProduct(new int[] {2,3,-2,4}) = " +maxProduct(new int[] {2,3,-2,4}));
      System.out.println("maxProduct(new int[] {2,0,3,-2,4}) = " +maxProduct(new int[] {2,0,3,-2,4}));
    }
}