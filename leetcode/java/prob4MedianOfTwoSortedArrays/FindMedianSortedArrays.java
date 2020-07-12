/*
Median of Two Sorted Arrays
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity
should be O(log (m+n)).
*/

/*
PSEUDOCODE:

FindMedianSortedArrays takes 2 sorted arrays, nums1 and nums2, of lengths
n and m respectively. Let nums be the sorted combined array of nums1 and
nums2 and len=n+m be the length of nums.
We have 2 cases depending on whether len is odd or even:

Case 1) If len is odd, then the median is nums[len/2]
Example: if nums1 = [10, 30, 50], and nums2 = [20, 40]; then nums = [10, 20, 30, 40, 50]
Since len = 5 is odd, the median is nums[len/2] = nums[5/2] = nums[2] = 30.

Case 2) If len is even, then the median is the average of the 2 middle elements,
i.e. nums[n/2-1] and nums[n/2].
Example: if nums1 = [10, 30], nums2 = [20, 40]; then nums = [10, 20, 30, 40].
len = 4 is even, thus median = (nums[len/2-1] + nums[len/2]) / 2.0 =
(nums[1] + nums[2]) / 2.0 = (20 + 30) / 2.0 = 25.0

Now, to find the elements nums[len/2] and nums[len/2-1], we will be using the
method findKthElement.

      PSEUDOCODE for findKthElement:

findKthElement(nums1, nums2, k)
finkdKthElement takes 2 sorted arrays, nums1 and nums2, and an integer k.
It returns nums[k], where nums is the sorted combined array of nums1 and nums2.
Let n1 be the length of nums1, and n2 be that of nums2.
If nums1 is empty (i.e. n1 is 0), we return nums2[k] since the kth element in
nums is just the kth element in nums2.
Likewise if nums2 is empty (i.e n2 is 0), we return nums1[k].
If k is 0, meaning that we are looking for nums[0], we just return
the smallest element between nums1[0] and nums2[0].

Let mid1 be n1/2 and mid2 be n2/2. We then compare mid1 + mid2 to k.

Case 1: mid1 + mid2 < k

Then we consider 2 cases from Case 1:

Case 1a: nums1[mid1] < nums2[mid2]
Then this means that there could be elements in nums1, to the right of mid1,
that are less than nums2[mid2]. In other words, nums1[mid1] cannot be the kth
element we are looking for and since nums1 is sorted,
none of the elements to the left of mid1 in nums1 can be the kth element.
We therefore make a recursive call by updating nums1 to elements from mid1+1
to the end. Therefore our new nums1 array no longer contain the first mid1+1 elements
(from 0 to mid1).
This also means that nums has mid1+1 fewer elements in it. Therefore
k also becomes k-(mid1+1) = k - mid1 - 1. Our recursive call will be:
findKthElement(Arrays.copyOfRange(nums1, mid1+1, n1), nums2, k-mid1-1)

Case 1b: nums1[mid1] >= nums2[mid2]
For the same argument as in Case 1a, we just make a recursive call:
findKthElement(nums1, Arrays.copyOfRange(nums2, mid2+1, n2), k-mid2-1);

Example:
nums1 = [10, 30, 50, 70, 90], nums2 = [20, 40, 60, 80, 100]. Therefore
nums = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100], mid1 = mid2 = 2.
Assume that k is 5, that is we are looking for the 5th element (0 based indexing)
in nums, nums[5], which is 60. In other words, we want to find:
findKthElement(nums1, nums2, 5):
First, we compare mid1+mid2 to k (Case 1):
mid1 + mid2 = 2 + 2 = 4; k = 5. therefore mid1+mid2 < k.

Next, we compare nums1[mid1] to nums2[mid2] (Case 1a):
nums1[mid1] = nums1[2] = 50
nums2[mid2] = nums2[2] = 60.
Since nums1[mid1] < nums2[mid2], nums[k] cannot be between indexes 0 and mid1
in nums1, so our new nums1 in the recursive call will only contain elements to
the right of mid1, that is from index 3 (mid1+1) to the end. nums2 stays the same:
new_nums1 = [70, 90], nums2 = [20, 40, 60, 80, 100], therefore new_nums
also changes to: new_nums = [20, 40, 60, 70, 80, 90, 100]

Remember k was 5 and we were looking for nums[k] = 60 before the changes. Now as
we can see, k also has to change to k' = k-mid1-1 = 5-2-1 = 2. So
new_nums[k'] = new_nums[2] = 60, which is exactly what we wanted (nums[5] = 60) :). If we
left k unchanged to 5, then new_nums[k] = new_nums[5] = 90 which is not what we want :(.


Case 2: mid1 + mid2 >= k
Then nums[k] must be either in nums1 between 0 and mid1, or in nums2 between
0 and mid2 depending on the larger element between nums1[mid1] and nums2[mid2].

Case 2a: nums1[mid1] < nums2[mid2]
Then any element to the right of mid2 in nums2 is bigger than nums[k] since
nums2 is sorted; we can then ignore all of these elements. Therefore, we
make a recursive call by only considering elements in nums2 to the left of mid2:
findKthElement(nums1, Arrays.copyOfRange(nums2, 0, mid2), k);

Note that k is the same since the kth element is less than any of the
elements to the right of mid2, so k is not affected by ignoring these elements.

Case 2b: nums1[mid1] >= nums2[mid2]
For a similar argument as that in Case 2a, we only consider the elements
between 0 and mid1 in nums1.
findKthElement(Arrays.copyOfRange(nums1, 0, mid1), nums2, k)

*/

import java.util.Arrays;

public class FindMedianSortedArrays {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n1 = nums1.length, n2 = nums2.length, n = n1+n2;

    if (n % 2 == 1)
      return findKthElement(nums1, nums2, n/2);
    else {
      double leftElement = findKthElement(nums1, nums2, n/2 - 1);
      double rigthElement = findKthElement(nums1, nums2, n/2);
      return (leftElement + rigthElement) / 2.0;
    }
  }

  public static double findKthElement(int[] nums1, int[] nums2, int k) {
    int n1 = nums1.length, n2 = nums2.length;

    if (n1 == 0) return nums2[k];
    if (n2 == 0) return nums1[k];
    if (k == 0) return Math.min(nums1[0], nums2[0]);

    int mid1 = n1/2, mid2 = n2/2;

    if (mid1 + mid2 < k) {
      if (nums1[mid1] < nums2[mid2])
        return findKthElement(Arrays.copyOfRange(nums1, mid1+1, n1), nums2, k-mid1-1);
      else
        return findKthElement(nums1, Arrays.copyOfRange(nums2, mid2+1, n2), k-mid2-1);
    } else { // mid1 + mid2 >= k
      if (nums1[mid1] < nums2[mid2])
        return findKthElement(nums1, Arrays.copyOfRange(nums2, 0, mid2), k);
      else
        return findKthElement(Arrays.copyOfRange(nums1, 0, mid1), nums2, k);
    }
  }

  public static String printArray(int[] arr) {
    String result = "[";
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      result += arr[i];
      if (i < len-1)
        result += ", ";
    }
    result += "]";
    return result;
    }

  public static void main(String[] args) {
    int[] a0 = {1, 1};
    int[] b0 = {1, 1};
    System.out.print("For a0 = " + printArray(a0) + ", b0 = " + printArray(b0) + ": median = ");
    System.out.println(findMedianSortedArrays(a0, b0));

    int[] a1 = new int[] {5};
    int[] b1 = new int[] {2,6};
    System.out.print("For a1 = " + printArray(a1) + ", b1 = " + printArray(b1) + ": median = ");
    System.out.println(findMedianSortedArrays(a1, b1));

    int[] a2 = new int[]{2,9};
    int[] b2 = new int[]{1,5};
    System.out.print("For a2 = " + printArray(a2) + ", b2 = " + printArray(b2) + ": median = ");
    System.out.println(findMedianSortedArrays(a2, b2));

    int[] a3 = new int[]{1,1,3,4};
    int[] b3 = new int[]{2,4,6,10,11,12,13,14,17,19,20};
    System.out.print("For a3 = " + printArray(a3) + ", b3 = " + printArray(b3) + ": median = ");
    System.out.println(findMedianSortedArrays(a3, b3));

    int[] a4 = new int[]{};
    int[] b4 = new int[]{1};
    System.out.print("For a4 = " + printArray(a4) + ", b4 = " + printArray(b4) + ": median = ");
    System.out.println(findMedianSortedArrays(a4, b4));

    int[] a5 = new int[]{2};
    int[] b5 = new int[]{};
    System.out.print("For a5 = " + printArray(a5) + ", b5 = " + printArray(b5) + ": median = ");
    System.out.println(findMedianSortedArrays(a5, b5));
  }
}