/*
Find Minimum in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class FindMin {
  public static int findMin(int[] nums) {
    int left = 0, right = nums.length-1;
    while (left < right) {
      int mid = left + (right - left) / 2; // same as (left + right)/2, but we want to avoid overflow

      if (nums[mid] > nums[right]) // the min value has to be to the right of nums[mid], so we set left to mid+1
        left = mid + 1;            // Example, nums =[4,5,6,7,0,1,2], left = 0, right = 6, nums[mid] = 7
      else            // nums[mid] could be the min value, so we set right to mid.
        right = mid;  // Example, nums = [6,7,0,1,2], left = 0,  right = 4; therefore nums[mid] <= nums[right]
                      // and 0 is the min; thus we include it in next iteration
    }
    return nums[left];
  }

  public static void main(String[] args) {
    int[] arr1 = {1};
    int[] arr2 = {1,2};
    int[] arr3 = {2,1};
    int[] arr4 = {4, 5, 6, 7, 0, 1, 2};
    System.out.println("findMin({1} = " + findMin(arr1));
    System.out.println("findMin({1,2}) = " + findMin(arr2));
    System.out.println("findMin({2,1}) = " + findMin(arr3));
    System.out.println("findMin({4, 5, 6, 7, 0, 1, 2}) = " + findMin(arr4));
  }
}
