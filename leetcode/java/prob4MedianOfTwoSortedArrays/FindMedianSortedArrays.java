/*
Median of Two Sorted Arrays
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity
should be O(log (m+n)).

Solution 1 - BRUTE FORCE: O(n+m) runtime and O(n+m) space complexities
We merge the 2 arrays in a single array of length n+m, and return the
middle element element (if n+m is odd) or the average of the middle 2
elements (if n+m is even)

//////////////

Solution 2 - O(log(min(m, n))) runtime and O(1) space

Let's assume that the first array A has a smaller length than the second
array B. We'll use binary search on A.
Assume A.length = m and B.length = n

1) Partitioning input arrays A and B
Let's partition  the first input array A at a random position i. Let
left_A be the left partition of A and right_A its right partition.

      left_A             |        right_A
A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]

Similarly, let's partition  the second input array B at a random position j.
Let left_B be it's left partition and right_B it's right partition.

      left_B             |        right_B
B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]

2) Combine the parts
Now let's combine left_A and left_B into one part called left_part.
Similarly, we combine right_A and right_B into right_part.

      left_part          |        right_part
A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]

3) Total number of elements in left_part

3-a) left_A has i elements (from A[0] to A[i-1]) and left_B has j
elements (from B[0] to B[j-1]). Therefore left_part has i+j elements.

3-b) If the total number of elements in both arrays (m+n) is even, there will
be the same number of elements in left_part and right_part, i.e (m+n)/2.
But if m+n is odd, we want the extra element to be on the left side.
Therefore, in order to satisfy both even and odd cases of m+n, we say that
the total number of elements in left_part is (m+n+1)/2. This formula
satisfies both the even and odd cases.

Example 1: if m+n=6, then (m+n+1)/2 = 3, thus 3 elements on left_part
and 3 on right_part.
Example 2: if m+n=7, then (m+n+1)/2 = 4, thus 4 elements on left_part
and 3 on right_part.
Therefore length of left_part = (m+n+1)/2.

Combining (3a) and (3b) gives us the formula:

          *****************************************
          *                                       *
          *  length(left_part) = i+j = (m+n+1)/2  *
          *                                       *
          *****************************************

4) Finding i, the partition point for array A.
Binary search will be performed on A to find i.
Initially, we set iMin = 0, iMax = m. As long as iMin <= iMax, we set
i = (iMin + iMax)/2. If we have not found the right partition, then we
move either to the right (iMin = i+1) or to the left (iMax = i-1).
We'll describe later on when to move left or right.

5) Finding j, the partition point for array B.
From the formula in (3), we have:
i+j = (m+n+1)/2, therefore j = (m+n+1)/2 - i

              ************************
              *                      *
              *  j = (m+n+1)/2 - i   *
              *                      *
              ************************
This means that, if i increases then j will decrease and vice versa;
this is because i+j is constant (i+j = (m+n+1)/2).

6) Finding the perfect partitions.
The perfect partitions are found when:
  every element on left_part <= every element on right_part

Since A and B are both sorted, we have:
  every element in left_A <= every element in right_A, and
  every element in left_B <= every element in right_B.

So for the perfect partition, all we need to check is:
  every element in left_A <= every element in right_B, and
  every element in left_B <= every element in right_A

Therefore for i, 0 <= i <= m, the perfect partition is found when
A[i-1] <= B[j] and B[j-1] <= A[i] where j = (m+n+1)/2 - i.

              ***************************
              *  A[i-1] <= B[j] and     *
              *  B[j-1] <= A[i]         *
              *  where j=(m+n+1)/2 - i  *
              *                         *
              ***************************

See (8c) for a more accurate formula where edge cases are taken
into consideration.

7) Edge cases:
If i=0, A[i-1] is undefined. Similarly if i=m, A[i] is undefined.
If j=0, B[j-1] is undefined. Similarly if j=n, B[j] is undefined.

i=0 means left_A is empty; i=m means right_A is empty.
j=0 means left_B is empty; j=n means right_B is empty.

So if i=0 or j=n, no need to check the condition: A[i-1] <= B[j]
Similarly, if j=0 or i=m, no need to check condition: B[j-1] <= A[i]
See (8c) on how to deal with these cases.

8) Finding the median
From (6), we know that the right partition i is found when
A[i-1] <= B[j] and B[j-1] <= A[i], where j = (m+n+1)/2 - i.

8-a) If m+n is odd, then median = max(left_part) = max(A[i-1], B[j-1]).
This is because the extra element is always on left_part.

8-b) If m+n is even, median = ( max(left_part) + min(right_part) )/2
                           = ( max(A[i-1], B[j-1]) + min(A[i], B[j]) )/2

8-c) Taking edge cases into consideration.
From (7), we know that the edge cases are i=0, i=m, j=0, and j=n

Case 1: i == 0 or j == n
In this case, we don't need to check A[i-1] <= B[j] since either A[i-1]
is undefined (when i=0) or B[j] is undefinied (when j=n).
Therefore, we only need to check if B[j-1] <= A[i].
So in (6), instead of only checking for A[i-1] <= B[j], we should
include the edge cases to have the below condition:
   (i == 0 or j == n or A[i-1] <= B[j])

Case 2: j == 0 or i == m
In this case, we don't need to check B[j-1] <= A[i] since either B[j-1]
is undefined (when j=0) or A[i] is undefinied (when i=m).
Therefore, we only need to check if A[i-1] <= B[j].
So in (6), instead of only checking for B[j-1] <= A[i], we should
include the edge cases to have the below condition:
    ( j == 0 or i == m or B[j-1] <= A[i] )

From Case 1 and Case 2 above, we know that we have found the perfect
partition with the condition below is satisfied:

      ************************************************
      *                                              *
      *  ( i == 0 or j == n or A[i-1] <= B[j] ) and  *
      *  ( j == 0 or i == m or B[j-1] <= A[i] )      *
      *                                              *
      ************************************************

If the above condition is found, then we are at the perfect i and
we stop searching.

But if we haven't found the perfect i, that means i is either too big
or too small. Then we need to either increase i (when i is too small)
or decrease i (when i is too big)

8-d) i is too big

!(i == 0 or j == n or A[i-1] <= B[j]), i.e
(i > 0 and j < n and A[i-1] > B[j]) where j = (m+n+1)/2 - i
A[i-1] > B[j] means that A[i-1] is too big and therefore it should be
part of the right partition of A (right_A). For this to happen, we need
to decrease i. Since A[i-1] is too big, all the elements to its right
(i.e. elements on right_A) are also to big and none of them can be
part of the solution (the median). So we focus to the left of i. But
what does this mean? To explain, let iMin and iMax be the respective
elements in A that are the boundary elements that we focus on.
Initially iMin = 0 and iMax = m. We always set i = (iMin + iMax)/2.
So to focus to the left of i means setting iMax = i-1 (and to
focus to the right would mean iMin = i+1).

Before we go to the next case, let's prove that if i > 0 then that
means j < n.
Assume i > 0. Since m <= n, and j = (m+n+1)/2 - i, we have:
Since i > 0, then j = (m+n+1)/2 - i < (m+n+1)/2
Since m <= n, then (m+n+1)/2 <= (2n+1)/2, i.e j < (2n+1)/2
But since we are dealing with integer division, (2n+1)/2 is the same
as 2n/2 = n.
Example, if n = 3, (2n+1)/2 = 7/2 = 3. If n=4, (2n+1)/2=9/2 = 4.
So (2n+1)/2 = 2n/2 = n
Therefore j < (2n+1)/2 = n.
So if i > 0, then automatically j < n

So our condition (i > 0 and j < n and A[i-1] > B[j]) becomes
(i > 0 and A[i-1] > B[j])
Thus if i > 0 and A[i-1] > B[j], we set iMax = i-1

        ****************************************************
        *                                                  *
        *  if (i > 0 and A[i-1] > B[j]), then iMax = i-1   *
        *                                                  *
        ****************************************************

8-e) i is too small

!( j == 0 or i == m or B[j-1] <= A[i] ) i.e.
(j > 0 and i < m and B[j-1] > A[i]) where j = (m+n+1)/2 - i
B[j-1] > A[i] means that B[j-1] is too big and therefore it should be
part of the right partition of B. For this to happen, we need to decrease j.
But remeber i+j is constant, i.e i+j = (m+n+1)/2. So if j decreases,
then i must increase and vice versa. Therefore since j should
decrease, i is too small and should be increased. That is we set i
to iMin = i+1;

Let's prove that if i < m, then that automatically means j > 0
Assume i < m. Since m <= n, we have:
    m > i
    n >= m
Adding both sides gives: m+n > i+m ==> (m+n+1)/2 > (i+m+1)/2
==> (m+n+1)/2 - i > (i+m+1)/2 - i = (m+1-i)/2
Since j = (m+n+1)/2 - i then j > (m+1-i)/2 ==> j > (m-i)/2 + 1/2
Since m > i, then (m-i) > 0 ==> (m-i)/2 > 0 ==> j > 0 (since 1/2 > 0)

We just proved that if if i < m, then j > 0
Therefore our condition: if (j > 0 and i < m and B[j-1] > A[i]) is
the same as (if i < m and B[j-1] > A[i]). In which case we set iMin = i+1.

        **************************************************
        *                                                *
        *  if (i < m and B[j-1] > A[i]), then iMin = i+1 *
        *                                                *
        **************************************************

Resources:
https://leetcode.com/articles/median-of-two-sorted-arrays/

https://www.youtube.com/watch?time_continue=9&v=LPFhl65R7ww&feature=emb_logo

/////////////////////////////////////////////////////////////////////////

SOLUTION 3: RECURSION
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
    // Make sure the first array's length is the smallest
    if (nums1.length > nums2.length)
      return findMedianSortedArrays(nums2, nums1);

    int m = nums1.length, n = nums2.length;
    int iMin = 0, iMax = m, halfLen = (m+n+1)/2;
    while (iMin <= iMax) {
      int i = (iMin + iMax)/2;
      int j = halfLen - i;

      // Case: i is too big
      if (i > 0 && nums1[i-1] > nums2[j])
        iMax = i-1;

      // Case: i is too small
      else if (i < m && nums2[j-1] > nums1[i])
        iMin = i+1;

      // Case: the perfect i is found
      else {
        int maxLeft = 0; // maxLeft = max(nums1[i-1], nums2[j-1])
        if (i == 0) // nums1[i-1] is undefined => it cannot be part of maxleft
          maxLeft = nums2[j-1];
        else if (j == 0) maxLeft = nums1[i-1]; //nums2[j-1] is undefined
        else maxLeft = Math.max(nums1[i-1], nums2[j-1]);
        // if (m+n) is odd, the median is on left side, i.e maxLeft
        if ( (m+n) % 2 == 1) return maxLeft;

        int minRight = 0; // minRight = min(nums1[i], nums2[j])
        if (i == m) minRight = nums2[j]; // nums1[i] is undefined
        else if (j == n) minRight = nums1[i]; //nums2[j] undefined
        else minRight = Math.min(nums1[i], nums2[j]);

        return (maxLeft + minRight) / 2.0;
      }

    }
    return 0.0;
  }

  // Recursive solution -
  public static double findMedianSortedArraysRecursive(int[] nums1, int[] nums2) {
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
    System.out.println(findMedianSortedArraysRecursive(a2, b2));

    int[] a3 = new int[]{1,1,3,4};
    int[] b3 = new int[]{2,4,6,10,11,12,13,14,17,19,20};
    System.out.print("For a3 = " + printArray(a3) + ", b3 = " + printArray(b3) + ": median = ");
    System.out.println(findMedianSortedArraysRecursive(a3, b3));

    int[] a4 = new int[]{};
    int[] b4 = new int[]{1};
    System.out.print("For a4 = " + printArray(a4) + ", b4 = " + printArray(b4) + ": median = ");
    System.out.println(findMedianSortedArraysRecursive(a4, b4));

    int[] a5 = new int[]{2};
    int[] b5 = new int[]{};
    System.out.print("For a5 = " + printArray(a5) + ", b5 = " + printArray(b5) + ": median = ");
    System.out.println(findMedianSortedArraysRecursive(a5, b5));
  }
}
