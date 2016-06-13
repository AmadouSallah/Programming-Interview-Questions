/*

Remove Element

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Hints

Try two pointers.
Did you use the property of "the order of elements can be changed"?
What happens when the elements to remove are rare?

*/



public class RemoveElement {

  // Solution 1
  public static int removeElement(int[] nums, int val) {

    if (nums == null || nums.length == 0) return 0;

    int i = 0, len = nums.length;
    for (int j = 0; j < len; j++) {
      if (nums[j] != val)
        nums[i++] = nums[j];
    }
    return i;
  }

  // Solution 2: when elements to be removed are rare
  public static int removeElement2(int[] nums, int val) {

    if (nums == null || nums.length == 0) return 0;

    int left = 0, right = nums.length;
    while (left < right) {
      if (nums[left] == val) {
        nums[left] = nums[right-1];
        right--; // reduce array size by 1
      } else
        left++;
    }

    return right;
  }

  public static void main(String[] args) {
    System.out.println("removeElement(null, 0) = " + removeElement(null, 0));
    System.out.println("removeElement(new int[]{}, 1) = " + removeElement(new int[]{}, 1));
    System.out.println("removeElement(new int[]{1}, 1) = " + removeElement(new int[]{1}, 1));
    System.out.println("removeElement(new int[]{1}, 3) = " + removeElement(new int[]{1}, 3));
    System.out.println("removeElement(new int[]{3,2,2,3}, 3) = " + removeElement(new int[]{3,2,2,3}, 3));
    System.out.println("removeElement(new int[]{0,1,2,3,4,5}, 5) = " + removeElement(new int[]{0,1,2,3,4,5}, 5));

    System.out.println("\nUsing Solution 2:");
    System.out.println("removeElement2(null, 0) = " + removeElement2(null, 0));
    System.out.println("removeElement2(new int[]{}, 1) = " + removeElement2(new int[]{}, 1));
    System.out.println("removeElement2(new int[]{1}, 1) = " + removeElement2(new int[]{1}, 1));
    System.out.println("removeElement2(new int[]{1}, 3) = " + removeElement2(new int[]{1}, 3));
    System.out.println("removeElement2(new int[]{3,2,2,3}, 3) = " + removeElement2(new int[]{3,2,2,3}, 3));
    System.out.println("removeElement2(new int[]{0,1,2,3,4,5}, 5) = " + removeElement2(new int[]{0,1,2,3,4,5}, 5));

  }
}