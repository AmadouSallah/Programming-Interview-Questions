/*
Problem 137: Single Number II

Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/


public class SingleNumberII {

  public static int singleNumber(int[] nums) {
    return singleNumber(nums, 3);
  }

  /* singleNumber: The method takes an input array of integers nums and an integer k. In nums, every number
  appears k times except for one. The method will return that single one.

  PSEUDOCODE:
  We initialize countBits to an array of 32 elements. An integer has 32 bits, and countBits[i] will
  represent the count of the ith set bit of all elements in nums. (All elements of countBits are initially 0.)

  We start an outer loop from (i go from 0 to 32). The inner loop will go through the elements of nums.
      For each array element, if its bit position at i is set, we increment countBits[i] by 1.
    We take (countBits[i] % k), which is either 0 or 1, and we shift it to the left by i. We then add it to the result

  */
  public static int singleNumber(int[] nums, int k) {
    int len = nums.length, result = 0;
    int[] countBits = new int[32];

    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < len; j++) {
        // if the bit position at i is set, we increment countBits[i] by 1.
        if (((nums[j] >> i) & 1) == 1)
          countBits[i]++;
      }

      result |= ((countBits[i] % k) << i);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("singleNumber(new int[] {1}) = " + singleNumber(new int[] {1}));
    System.out.println("singleNumber(new int[] {1,2,1,1,3,2,2}) = " + singleNumber(new int[] {1,2,1,1,3,2,2}));
    System.out.println("singleNumber(new int[] {4,4,1,2,1,1,3,2,2,4,7,3,3}) = " + singleNumber(new int[] {4,4,1,2,1,1,3,2,2,4,7,3,3}));
  }
}

