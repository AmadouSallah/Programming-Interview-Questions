/*
Problem 36. Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules. (http://sudoku.com.au/TheRules.aspx)

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

/*
Pseudocode for the indexes of the box (rowIndex, colIndex)
Source: https://discuss.leetcode.com/topic/9748/shared-my-concise-java-code/6

For each block traversal, we can use j since j iterates from 0 to 9:
    - For horizontal traversal, we use (j % 3) since % increments by 1 for  0 <= j < 3 and then resets.
    Therefore this will cover a horizontal traversal for each block by 3 steps
    - For vertical traversal, we use (j / 3) since % increments by 1 for  0 <= j < 3 and then resets.
    Therefore this will cover a vertical traversal for each block by 3 steps

This will take care of only the first block since j goes from 0 to 9. Thus it stays on 1st block. Inorder to go to the
next block, we need to use i.
    - To move horizontally to the next block, we use 3*(i % 3) - we multiply by 3 to make sure that the next block
    is after 3 colums. i.e 1st block starts at (0, 0), 2nd block at (0, 3) not (0, 1), and 3rd block at (0, 6).
    - Similarly, to move vertically, we use 3*(i/3) for same reasons as above

Thus, rowIndex = 3*(i/3) + j/3, and colIndex = 3*(i%3) + j%3
*/

import java.util.Set;
import java.util.HashSet;

public class IsValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      Set<Character> rows = new HashSet<>();
      Set<Character> colums = new HashSet<>();
      Set<Character> box = new HashSet<>();

      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.' && !rows.add(board[i][j])) {
          return false;
        }
        if (board[j][i] != '.' && !colums.add(board[j][i])) {
          return false;
        }
        int rowIndex = 3*(i/3) + j/3, colIndex = 3*(i%3) + j%3;
        if (board[rowIndex][colIndex] != '.' && !box.add(board[rowIndex][colIndex])) {
          return false;
        }
      }
    }
    return true;
  }
}
