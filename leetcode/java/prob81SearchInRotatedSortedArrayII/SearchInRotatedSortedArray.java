/*
Problem 81. Search in Rotated Sorted Array II

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

public class SearchInRotatedSortedArray {

  public static boolean search(int[] nums, int target) {

    if (nums == null || nums.length == 0) return false;

    int left = 0, right = nums.length-1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return true;
      }
      else if (nums[mid] > nums[left]) {
        // nums[left] <= target <= midElement
        if (nums[left] <= target && target <= nums[mid]) {
          right = mid - 1;
        } else { // nums[left] <= midElement <= target
          left = mid + 1;
        }
      }

      else if (nums[mid] < nums[left]) {
        // nums[mid] <= target <= nums[right]
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid + 1;
        } else { // target <= nums[mid] <= nums[right]
          right = mid - 1;
        }
      }

      else { // nums[mid] == nums[left]
        left += 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("search(null, 1 ) = " + search(null, 1));
    System.out.println("search([], 3 ) = " + search(new int[] {}, 3 ));
    System.out.println("search([1], 0 ) = " + search(new int[] {1}, 0 ));
    System.out.println("search([4, 5, 6, 7, 0, 1, 2], 4 ) = " + search(new int[] {4, 5, 6, 7, 0, 1, 2}, 4 ));
    System.out.println("search([4, 5, 6, 7, 0, 1, 2], 2 ) = " + search(new int[] {4, 5, 6, 7, 0, 1, 2}, 2 ));
    System.out.println("search([4, 5, 6, 7, 0, 1, 2], 7 ) = " + search(new int[] {4, 5, 6, 7, 0, 1, 2}, 7 ));
    System.out.println("search([4, 5, 6, 7, 0, 1, 2], 0 ) = " + search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0 ));
    System.out.println("search([4, 5, 6, 7, 0, 1, 2], 6 ) = " + search(new int[] {4, 5, 6, 7, 0, 1, 2}, 6 ));
    System.out.println("search([4, 5, 6, 7, 0, 1, 2], 1 ) = " + search(new int[] {4, 5, 6, 7, 0, 1, 2}, 1 ));
    System.out.println("search([4, 5, 6, 7, 0, 1, 2], 3 ) = " + search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3 ));
  }
}