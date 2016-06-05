/*

Find the Duplicate Number

Given an array nums containing n + 1 integers where each integer is between
1 and n (inclusive), prove that at least one duplicate number must exist.
Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be
repeated more than once.

*/

// Resources: http://keithschwarz.com/interesting/code/find-duplicate/FindDuplicate.python.html

public class FindDuplicate {

  public static int findDuplicate(int[] nums) {

    if (nums == null || nums.length < 2) {
      return -1;
    }

    int len = nums.length, slow = nums[0], fast = nums[nums[0]];

    // each time, fast moves twice the speed of slow until they meet
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }

    // At this point, slow = fast.

    slow = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;
  }

  public static void main(String[] args) {
    System.out.println("findDuplicate(new int[] {1, 1}) = " +findDuplicate(new int[] {1, 1}));
    System.out.println("findDuplicate(new int[] {2, 5, 3, 1, 4, 3}) = " + findDuplicate(new int[] {2, 5, 3, 1, 4, 3}));
    System.out.println("findDuplicate(new int[] {2, 5, 2, 1, 4, 3}) = " + findDuplicate(new int[] {2, 5, 2, 1, 4, 3}));

  }

}