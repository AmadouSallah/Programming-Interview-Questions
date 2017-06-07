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

////////////////////

/* IN PLACE SOLUTION: gameOfLife2
We use 2 bits to store the current and next state: the least significant bit will represent the current state
whereas the most significant bit will represent the next state. Example, 01 would mean that the current state of the cell
is 1 (alive) and its next state is 0 (dead). 11 means both current and next states are alive
Note: 00 => 0, 01 => 1, 10 => 2, and 11 => 3

To get the current state of a cell, we just use & with 1 (board[i][j] & 1). Example 00 & 1 = 0, 01 & 1 = 1, ...
To get the next state, we just right shift by 1 bit (board[i][j] >> 1). Example (01 >> 1) = 0, (10 >> 1) = 1, ...

Initially, all cells are either 00 or 01, since at the begining the next state is 0 for all cells
and the current state is either dead (0) or alive (1).

All the cases for rules for the game of live can be summarized into 2 main cases:
Case 1: the cell's current state is alive (cell = 01)
    Case 1a: the number of alive neighbors (numberOfAliveNeighbors) is either 2 or 3
        In this case, the cell will be alive in the next state. We then transition from 01 to 11, i.e. from 1 to 3
    Case 1b: numberOfAliveNeighbors is either 1, 4, 5, 6, 7, or 8 => No Changes
        In this case, the cell dies due to either under-population (numberOfAliveNeighbors < 2), or due to over-population (numberOfAliveNeighbors > 3).
        ** The cell transitions from 01 to 01, which is unchanged. Note, 1st bit stays the same to indicate current state
        is alive and 2nd bit is unchanged to 0 (dead) since it was not alive to begin with.
        Therefore, we will be ignoring case 1b since no changes
Case 2: the cell's current state is dead (00)
    In this case, the cell becomes alive only if numberOfAliveNeighbors = 3. For all other cases it is unchanged

No changes for all other cases: 00 -> 00 or 01 -> 10

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

  // IN PLACE SOLUTIONS
  public static void gameOfLife2(int[][] board) {

     if (board == null || board.length == 0) return;

     int m = board.length, n = board[0].length;

     for (int row = 0; row < m; row++) {
       for (int col = 0; col < n; col++) {
         int currentCell = board[row][col];

         // Finding the number of alive neighbors for currentCell
         int numberOfAliveNeighbors = 0;
         for (int i = Math.max(0, row-1); i <= Math.min(m-1, row+1); i++) {
           for (int j = Math.max(0, col-1); j <= Math.min(n-1, col+1); j++) {
             int neighbor = board[i][j] & 1; // to get the least significant bit (i.e current state)
             numberOfAliveNeighbors += neighbor;
           }
         }
         // currentCell was included in the numberOfAliveNeighbors, so we substract it
         numberOfAliveNeighbors -= currentCell;

         // Implementing the rules for game of life for currentCell

         // Case 1: the cell's current state is alive (cell = 01) and numberOfAliveNeighbors is 2 or 3
         if (currentCell == 1 && (numberOfAliveNeighbors == 2 || numberOfAliveNeighbors == 3)) {
            board[row][col] = 3; // transition from 01 to 11
         }

         // Case 2: the cell's current state is dead (00) and numberOfAliveNeighbors is 3
         else if (currentCell == 0 && numberOfAliveNeighbors ==3) {
            board[row][col] = 2; // transition from 00 to 10
         }
       }
     }

     // Now change the board so that the next state becomes the current state by right shifting every cell by 1
     for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
             board[i][j] = board[i][j] >> 1;
         }
     }
   }

}
