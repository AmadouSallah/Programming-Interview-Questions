/*
Find Minimum in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

// Resources: https://www.youtube.com/watch?v=lwvtvNIFvwA

public class FindMin {
  public static int findMin(int[] nums) {
    int left = 0, right = nums.length-1;
    while ( (left < right) && (nums[left] >= nums[right]) ) { // if nums[left] <= nums[right], then the array is sorted
      // and we just return nums[left], the smallest element
      int mid = left + (right - left) / 2; // same as (left + right)/2, but we want to avoid overflow

      if ( nums[mid] > nums[right]) // the min value has to be to the right of nums[mid], so we set left to mid+1
        // Example, nums =[4,5,6,7,0,1,2], left = 0, right = 6, nums[mid] = 7
        left = mid + 1;

      else // (nums[mid] < nums[right]) No duplicates allowed, therefore nums[mid] cannot equals to nums[right]
        // nums[mid] could be the min value, so we set right to mid. Example, nums = [6,7,0,1,2], left = 0,  right = 4;
        //  therefore nums[mid] <= nums[right] and 0 is the min; thus we include it in next iteration
        right = mid;
    }
    return nums[left];
  }

  public static void main(String[] args) {
    System.out.println("findMin(new int[] {1}) = " + findMin(new int[] {1}));
    System.out.println("findMin(new int[] {1,2}) = " + findMin(new int[] {1,2}));
    System.out.println("findMin(new int[] {2,1}) = " + findMin(new int[] {2,1}));
    System.out.println("findMin(new int[] {4, 5, 6, 7, 0, 1, 2}) = " + findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
  }
}
