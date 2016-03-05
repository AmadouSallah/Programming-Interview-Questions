import java.util.*;

/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class SpiralMatrix2 {

  public static int[][] generateMatrix(int n) {

    if (n < 1) {
      return new int[0][];
    }

    int[][] result = new int[n][n];

    int topRow = 0;
    int bottomRow = n-1;
    int leftColumn = 0;
    int rightColumn = n-1;
    int direction = 0;
    int lastValue = n*n;
    int i = 1;

    while (i <= lastValue) {

       /* Print top row */
      if (direction == 0) {

        for (int col = leftColumn; col <= rightColumn; col++) {
          result[topRow][col] = i++;
        }
        topRow++;

       /* Print right column */
      } else if (direction == 1) {

        for (int row = topRow; row <= bottomRow; row++) {
          result[row][rightColumn] = i++;
        }
        rightColumn--;

        /* Print bottow row */
      } else if (direction == 2) {

        for (int col = rightColumn; col >= leftColumn; col--) {
          result[bottomRow][col] = i++;
        }
        bottomRow--;

        /* Print left column */
      } else {

        for (int row = bottomRow; row >= topRow; row--) {
          result[row][leftColumn] = i++;
        }
        leftColumn++;

      }

      direction = (direction + 1) % 4; // Making sure direction is between 0 and 3 only;
    }
    return result;
  }

  public static void printMatrix(int[][] arr) {
    System.out.println("Printing Matrix:");
    int n = arr.length;
    int m = arr[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++)
        System.out.print(arr[i][j] + "\t");
      System.out.println();
    }
  }

  public static void main(String[] args) {

    int[][] m1 = generateMatrix(0);
    int[][] m2 = generateMatrix(1);
    int[][] m3 = generateMatrix(2);
    int[][] m4 = generateMatrix(3);
    int[][] m5 = generateMatrix(4);
    // printMatrix(m1);
    printMatrix(m2);
    printMatrix(m3);
    printMatrix(m4);
    printMatrix(m5);
  }
}