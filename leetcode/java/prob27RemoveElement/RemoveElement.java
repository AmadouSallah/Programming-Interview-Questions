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

  public static void main(String[] args) {
    System.out.println("removeElement(null, 0) = " + removeElement(null, 0));
    System.out.println("removeElement(new int[]{}, 1) = " + removeElement(new int[]{}, 1));
    System.out.println("removeElement(new int[]{1}, 1) = " + removeElement(new int[]{1}, 1));
    System.out.println("removeElement(new int[]{1}, 3) = " + removeElement(new int[]{1}, 3));
    System.out.println("removeElement(new int[]{3,2,2,3}, 3) = " + removeElement(new int[]{3,2,2,3}, 3));
    System.out.println("removeElement(new int[]{0,1,2,3,4,5}, 5) = " + removeElement(new int[]{0,1,2,3,4,5}, 5));

  }
}