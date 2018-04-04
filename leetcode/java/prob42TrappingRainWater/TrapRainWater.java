/*
Problem 42. Trapping Rain Water

https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

/*
Solution 1, Brute force: O(n2) runtime and O(1) space complexities
An array element can store water if there are higher bars on its left and/or right sides.
We find the total amount of water that each array element can store, add them all up.
To find the total amount of water that each array element can trap, we do the followings:
a) For each element, we find the highest bar on both its left side (maxLeft) and right side (maxRight)
b) We take the smaller of maxLeft and maxRight and subtract the current element
*/

public class TrapRainWater {

  // Solution 1, Brute force: O(n2) runtime and O(1) space complexities
  public static int trap(int[] height) {
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

  public static void main(String[] args) {
    int[] heights = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println("trap([0,1,0,2,1,0,1,3,2,1,2,1]) = " + trap(heights));    
  }
}
