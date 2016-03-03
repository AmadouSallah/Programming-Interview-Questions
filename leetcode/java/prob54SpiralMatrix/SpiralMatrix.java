import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public static List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> result = new ArrayList<Integer>();

    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }

    int topRow = 0;
    int bottomRow = matrix.length - 1;
    int leftColumn = 0;
    int rightColumn = matrix[0].length - 1;
    int direction = 0;

    /*
    if direction is 0 (respectively 1), we add the elements of topRow (respectively rightColumn) to result;
    if direction is 2 (respectively 3), we add the elements of bottomRow (respectively leftColumn) to result;
    */

    while ( (topRow <= bottomRow) && (leftColumn <= rightColumn) ) {

      if (direction == 0) {
          for (int col = leftColumn; col <= rightColumn; col++) {
            result.add(matrix[topRow][col]);
          }
          topRow++; // increment it so that that elements of the row will not be added to result again.

      } else if (direction == 1) {
        for (int row = topRow; row <= bottomRow; row++) {
          result.add(matrix[row][rightColumn]);
        }
        rightColumn--; // decrement it so that that elements of this column will not be added to result again.

      } else if (direction == 2) {
        for (int col = rightColumn; col >= leftColumn; col--) {
          result.add(matrix[bottomRow][col]);
        }
        bottomRow--; // decrement it so that elements of this row will not be added to result again.

      } else {
        for (int row = bottomRow; row >= topRow; row--) {
          result.add(matrix[row][leftColumn]);
        }
        leftColumn++; // increment it so that elements of this column will not be added to result again.
      }

      direction = (direction + 1) % 4; // Makins sure direction is between 0 and 3
    }

    return result;

  }

  public static void printArray(List<Integer> arr) {
    int n = arr.size();
    for (int i = 0; i < n; i++)
      System.out.print(arr.get(i) + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    int[][] matrix1 = {{1,2,3}, {4,5,6},{7,8,9}};
    int[][] matrix2 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
    int[][] matrix3 = {{1,2,3,4,5}};
    int[][] matrix4 = {{1}, {2}, {3}};
    int[][] matrix5 = {{}};

    List<Integer> r1 = spiralOrder(matrix1);
    List<Integer> r2 = spiralOrder(matrix2);
    List<Integer> r3 = spiralOrder(matrix3);
    List<Integer> r4 = spiralOrder(matrix4);
    List<Integer> r5 = spiralOrder(matrix5);
    printArray(r1);
    printArray(r2);
    printArray(r3);
    printArray(r4);
    printArray(r5);
  }

}