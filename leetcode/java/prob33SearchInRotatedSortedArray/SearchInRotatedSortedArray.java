/*
Problem 33: Search in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

/*
We will be using the following array = [4, 5, 6, 7, 0, 1, 2] as example  in this pseudocode:

We set variable left to the index of the 1st array element (0 intially) and variable right to the
index of the right element (initially 6 for our above example).

Next, we go through a while loop as long as left <= right. In the loop, we do the followings:
    We first set midIndex to be the index of the middle element; We also set midElement to be the element
    at the middle of the array (initially 7 for our above array).

    We then explore 3 cases by comparing target to midElement.

    Case 1: midElement = target
        This means that we have found the element we are looking for, so we return the index of this midElement,
        that is, midIndex.

    Case 2: midElement >= nums[left] (we will call nums[left] 'leftElement')
        This means that midElement is greater than leftElement. We therefore explore 2
        sub cases depending on whether the value of target is:
            between leftElement and midElement (Case 2a)
            or greater than midElement (Case 2b).

        Case 2a: leftElement <= target <= midElement
            This means that if target is present in the input arrray, the only possible place it can be found
            will be to the left of midElement. Therefore we ignore everything to the right of midElement
            and only focus on elements to its left. We do so by setting right to mid-1 (right = mid - 1).

        Case 2b: If case 2a is not valid, i.e leftElement <= midElement <= target
            This means that if target is present in the array, the only possible place it can be found
            will be to the right of midElement. Therefore, we ignore everything to the left of midElement
            by setting the variable left to mid + 1 (left = mid + 1).

    Case 3: midElement <= nums[right]
        Similarly to case 2 above, we have 2 subcases here depending on whether the value of target is
            between midElement and nums[right] (Case 3a)
            or less than midElement (Case 3b).

        Case 3a: midElement <= target <= nums[right]
            This means that if target is present in the array, the only possible place it can be found will be
            to the right of midElement. Therefore we ignore everything to the left of midElement by setting the
            variable 'left' to mid+1.

        Case 3b: target <= midElement <= nums[right].
            This means that if target is present in the arrary, the only possible plce it can be found will be
            to the left of midElement. Thus, we ignore everything to the right of midElement by setting the
            variable 'right' to mid-1.

*/

public class SearchInRotatedSortedArray {

  public static int search(int[] nums, int target) {

    if (nums == null || nums.length == 0) return -1;

    int left = 0, right = nums.length -1;

    while (left <= right) {
      int midIndex = left + (right - left) / 2;
      int midElement = nums[midIndex];

      // Case 1: midElement == target
      if (midElement == target) {
        return midIndex;
      }

      // Case 2: midElement >= nums[left]
      else if (midElement >= nums[left]) {

          // Case 2a: nums[left] <= target <= midElement
        if ( (nums[left] <= target) && (target <= midElement) ) {
          right = midIndex - 1;
        }

        // Case 2b: nums[left] <= midElement <= target
        else {
          left = midIndex + 1;
        }
      }

      // Case 3: midElement <= nums[right]
      else {

        // Case 3a: midElement <= target <= nums[right]
        if ( (midElement <= target) && (target <= nums[right]) ) {
          left = midIndex + 1;
        }

        // Case 3b: target <= midElement <= nums[right]
        else {
          right = midIndex - 1;
        }
      }
    }

    return -1;
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