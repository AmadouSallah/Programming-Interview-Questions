/*
Resources: https://leetcode.com/problems/sparse-matrix-multiplication/#/description

Problem 311. Sparse Matrix Multiplication

Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/

public class SparseMatrixMultiplication {
  public int[][] multiply(int[][] A, int[][] B) {
    int rowsA = A.length, colsB = B[0].length, n = A[0].length; // n is also B.length
    int[][] result = new int[rowsA][colsB];

    for (int row = 0; row < rowsA; row++) {
      for (int i = 0; i < n; i++) {
        if (A[row][i] != 0) {
          for (int col = 0; col < colsB; col++) {
            if (B[i][col] != 0) {
              result[row][col] += A[row][i] * B[i][col];
            }
          }
        }
      }
    }
    return result;
  }
}
