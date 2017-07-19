/*
Resources: https://leetcode.com/problems/rotate-image/#/description

Problem 48. Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

public class RotateImageBy90Degrees {
  public void rotate(int[][] matrix) {
   if (matrix == null) return;
    int n = matrix.length;
    for (int i = 0; i < n/2; i++) {
      for (int j = i; j < n-1-i; j++) {
        int temp = matrix[i][j]; // saving top
        matrix[i][j] = matrix[n-j-1][i]; // left -> top
        matrix[n-j-1][i] = matrix[n-i-1][n-j-1]; // bottom -> left
        matrix[n-i-1][n-j-1] = matrix[j][n-i-1]; // right -> bottom
        matrix[j][n-i-1] = temp; // top -> right
      }
    }
  }
}
