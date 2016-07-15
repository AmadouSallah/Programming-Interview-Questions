/*
Problem 154. Find Minimum in Rotated Sorted Array II

Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

public class FindMinII {

  public static int findMin(int nums[]) {

    int left = 0, right = nums.length - 1;

    while ( (left < right) && (nums[left] >= nums[right]) ) { // if nums[left] <= nums[right], then the array is sorted
      int mid = left + (right - left) / 2;

      if (nums[mid] > nums[right]) { // the middle element can't be the minimum element, so we look to its right
        left = mid + 1;

      } else if (nums[mid] < nums[right]) { // No duplicates allowed, therefore nums[mid] cannot equals to nums[right]
        right = mid;  // the middle element could be the minimum element, so we include it. Example, if
        // nums = [4,5,6,0,1,2,3], nums[mid] = 0, nums[right] = 3 => nums[mid] <= nums[right] and 0 is the minimum element

      } else { // nums[mid] = nums[right]. Example nums = [1,1,0,1]
        left += 1;
      }
    }

  return nums[left]; // and we just return nums[left], the smallest element
  }

  public static void main(String[] args) {

    System.out.println("findMin(new int[] {1}) = " + findMin(new int[] {1}));
    System.out.println("findMin(new int[] {1,2}) = " + findMin(new int[] {1,2}));
    System.out.println("findMin(new int[] {2,1}) = " + findMin(new int[] {2,1}));
    System.out.println("findMin(new int[] {4, 5, 6, 7, 0, 1, 2}) = " + findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
    System.out.println("findMin(new int[] {1,1}) = " + findMin(new int[] {1,1}));
    System.out.println("findMin(new int[] {1,1,0,1}) = " + findMin(new int[] {1,1,0,1}));
    System.out.println("findMin(new int[] {1,1,0}) = " + findMin(new int[] {1,1,0}));
  }
}
