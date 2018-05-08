/*
Leetcode Problem 42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class TrapRainWater {

  /*
  Solution 1, Brute force: O(n2) runtime and O(1) space complexities
  An array element can store water if there are higher bars on its left and/or right sides.
  We find the total amount of water that each array element can store, add them all up.
  To find the total amount of water that each array element can trap, we do the followings:
  a) For each element, we find the highest bar on both its left side (maxLeft) and right side (maxRight)
  b) We take the smaller of maxLeft and maxRight and subtract the current element
  */
  public static int trap(int[] height) {

    if (height == null || height.length == 0) return 0;

    int n = height.length, ans = 0, maxLeft, maxRight;
    for (int i = 1; i < n-1; i++) { // we don't include the 1st and last elements
      maxLeft = 0;
      maxRight = 0;
      for (int j = i; j >=0; j--) { // find the highest bar to the left
        maxLeft = Math.max(maxLeft, height[j]);
      }
      for (int j = i; j < n; j++) { // find the highest bar to the right
        maxRight = Math.max(maxRight, height[j]);
      }
      int smallestBar = Math.min(maxLeft, maxRight);
      ans += smallestBar - height[i];
    }
    return ans;
  }

  /*
  Solution 2, Dynamic Programming: O(n) runtime and O(n) space complexities
  Instate of iterating over and over both the left and right sides of each array element to
  find the highest bar size up to that element, we store them in leftMax and rightMax arrays.
  For each array element at index i, leftMax[i] (respectively, rightMax[i]) is the largest bar to its
  left (respectively, right)
  */
  public static int trap2(int[] height) {
    if (height == null || height.length == 0) return 0;

    int n = height.length, ans = 0;
    // leftMax[i] (respectively, rightMax[i]) is the largest bar to the left (respectively, right) of height[i]
    int[] leftMax = new int[n], rightMax = new int[n];
    leftMax[0] = height[0];
    rightMax[n-1] = height[n-1];

    // fill leftMax array
    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i-1]);
    }
    // fill rightMax array
    for (int i = n-2; i >= 0; i--) {
      rightMax[i] = Math.max(height[i], rightMax[i+1]);
    }

    // Find the accumulated water on each bar and add it to answer
    for (int i = 0; i < n; i++) {
      int smallestBar = Math.min(leftMax[i], rightMax[i]);
      ans += smallestBar - height[i];
    }
    return ans;
  }

  /*
  Solution 3, Using 2 pointers: O(n) runtime and O(1) space complexities
  Instead of using 2 arrays as in the Dynamic Programming solution to store the left and right maximums,
  we can just use 2 pointers leftMax and rightMax to store the maximum until that point.
  We initialize left to 0 and right to height.length-1 and iterate as long as left < right.
  Since water trapped at any bar depends on the smaller between maxLeft and maxRight
  (min(maxLeft, maxRight)-height[i]), we can say that if there is a larger bar at one end, say to
  the right (rightMax), then water trapped depends on the other end, leftMax for this case.
  */
  public static int trap3(int[] height) {
    int leftMax = 0, rightMax = 0, left = 0, right = height.length-1, result = 0;

    while(left <= right) {
        if (height[left] < height[right]) {
          if (height[left] > leftMax) {
            leftMax = height[left];
          } else {
            result += leftMax - height[left];
            left++;
          }
        } else { // height[right] <= height[left]
          if (height[right] > rightMax) {
            rightMax = height[right];
          } else {
            result += rightMax - height[right];
            right--;
          }
        }
    }
    return result;
}

  public static void main(String[] args) {
    int[] heights = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println("trap([0,1,0,2,1,0,1,3,2,1,2,1]) = " + trap(heights));
    System.out.println("trap2([0,1,0,2,1,0,1,3,2,1,2,1]) = " + trap2(heights));
    System.out.println("trap3([0,1,0,2,1,0,1,3,2,1,2,1]) = " + trap3(heights));
  }
}
