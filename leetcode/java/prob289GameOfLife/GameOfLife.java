/*
Problem 289: Game of Life

According to the Wikipedia's article: "The Game of Life, also known simply as Life,
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following
four rules (taken from the above Wikipedia article):

  1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
  2. Any live cell with two or three live neighbors lives on to the next generation.
  3. Any live cell with more than three live neighbors dies, as if by over-population..
  4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.

Follow up:
Could you solve it in-place? Remember that the board needs to be updated at the same time:
You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite,
which would cause problems when the active area encroaches the border of the array.
How would you address these problems?
*/

/*
Death: the cell dies in the next state when its state changes from 1 to 0 (1 -> 0)
Birth: a new cell is born when its state changes from 0 to 1 (0 -> 1)
Statis: the state of the cell is unchanged when we go to the next state, i.e 0 -> 0 or 1 -> 1

    PSEUDOCODE:
For each cell, we count the number of its alive neigbors and apply the rule for game of live:
    Case 1: Death caused by Under-Population - Any alive cell, whose number of alive neigbors < 2, dies in the next state
    Case 2: Any live cell with two or three live neighbors stays alive in the next state.
    Case 3: Death caused by Over-Population - Any alive cell, whose number of alive neigbors > 3, dies in the next state
    Case 4: Birth - Any dead cell with exactly 3 alive neigbors becomes alive in the next state
    case 5: For all other cases, the state remains unchanged
*/

public class GameOfLife {
  public static void gameOfLife(int[][] board) {
    if (board == null || board.length == 0) return;

    int m = board.length, n = board[0].length;
    int[][] nextBoard = new int[m][n];

    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        int currentCell = board[row][col];

        // Find the number of all alive neighbors for currentCell (note for edge cases)
        int numberOfAliveNeighbors = 0;
        for (int i = Math.max(0, row-1); i <= Math.min(m-1, row+1); i++) {
          for (int j = Math.max(0, col-1); j <= Math.min(n-1, col+1); j++) {
            numberOfAliveNeighbors += board[i][j];
          }
        }
        // currentCell was included in the numberOfAliveNeighbors, so we substract it
        numberOfAliveNeighbors -= currentCell;

        // Implementing the rules for game of life

        // Case 1: Death by Under-population: Any alive cell, whose number of alive neigbors < 2, becomes dead
        if (currentCell == 1 && numberOfAliveNeighbors < 2) nextBoard[row][col] = 0;

        // Case 2: No changes: Any alive cell with two or three live neighbors stays alive in the next state.
        else if (currentCell == 1 && ((numberOfAliveNeighbors == 2) || (numberOfAliveNeighbors == 3)) ) {
          nextBoard[row][col] = board[row][col];
        }
        // Case 3: Death by Over-Population - Any alive cell, whose number of alive neigbors > 3, becomes dead
        else if (currentCell == 1 && numberOfAliveNeighbors > 3) nextBoard[row][col] = 0;

        // Case 4: Birth - Any dead cell with exactly 3 alive neigbors becomes alive in the next state
        else if (currentCell == 0 && numberOfAliveNeighbors == 3) nextBoard[row][col] = 1;

        // Case 5: Statis (no changes). The state of the cell stays the same
        else nextBoard[row][col] = board[row][col];
      }
    }
    // Update board (board = nextBoard)
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = nextBoard[i][j];
      }
    }
  }
}
