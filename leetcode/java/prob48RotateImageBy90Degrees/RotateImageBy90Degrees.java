/*
Resources: https://leetcode.com/problems/rotate-image/#/description

Problem 48. Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

/*
PSEUDOCODE
We move the top elements to the right, the right elements to the bottom, the bottom elements to left,
and the left elements to the top.
For this, we do 2 iterations i from 0 to n/2 and j from i to n-1-i. n is the length of the matrix
and n-1-i will be the last element, i.e the element that is diagonally opposite to the current element.

For each (i,j), will have 4 elements to swap: topElement, leftElement, bottomElement, and rightElement.
For each i, as j increases, we have:
    1) topElement = matrix[i][j]
    2) leftElement: the row goes from bottom left to top left, thus row = n-1-j.
    However, the column stays constant, same as i. Therefore, topElement = matrix[n-1-j][i]
    3) bottomElement: this element moves from bottom right to bottom left on the same row opposite to i,
    thus row = n-1-i; the column moves from right to left as j increases, thus col = n-j-1.
    Therefore bottomElement = matrix[n-1-i][n-1-j]
    4) rightElement: the row moves from top right to top bottom as j increases, thus row = j.
    The column, on the other hand, stays the same, n-i-i.
    Therefore, rightElement = matrix[j][n-i-1]

    In Summary:
    topElement = matrix[i][j];
    leftElement = matrix[n-j-1][i];
    bottomElement = matrix[n-i-1][n-j-1];
    rightElement = matrix[j][n-i-1];
*/

public class RotateImageBy90Degrees {
  public void rotate(int[][] matrix) {
   if (matrix == null) return;
    int n = matrix.length;
    for (int i = 0; i < n/2; i++) {
      for (int j = i; j < n-1-i; j++) {
        int temp = matrix[i][j]; // saving topElement
        matrix[i][j] = matrix[n-j-1][i]; // leftElement -> topElement
        matrix[n-j-1][i] = matrix[n-i-1][n-j-1]; // bottomElement -> leftElement
        matrix[n-i-1][n-j-1] = matrix[j][n-i-1]; // rightElement -> bottomElement
        matrix[j][n-i-1] = temp; // topElement -> rightElement
      }
    }
  }
}
