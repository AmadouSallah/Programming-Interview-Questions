/*
Container With Most Water

GGiven n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

 */

public class MaxArea {
  public static int maxArea(int[] height) {
    int left = 0, right = height.length-1, maxArea = 0;
    while (left < right) {
      int leftHeight = height[left], rightHeight = height[right];
      int currentArea = (Math.min(leftHeight, rightHeight)) * (right - left);
      maxArea = Math.max(maxArea, currentArea);

      if (leftHeight < rightHeight) { // we might find a height to the right of left that is greater than it.
        left++;                     // so we increment left
      } else {                        // right <= left, so we decrement right since there might be a height
        right--;                     // to its left that is larger.
      }
    }
    return maxArea;
  }

  public static void main(String[] args) {
    System.out.println(maxArea(new int[] {1,1}));
  }
}