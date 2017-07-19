/*
Resources: https://leetcode.com/problems/number-of-islands/#/description

Problem 200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class NumberOfIslands {
  public static int numberOfIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int rows = grid.length, cols = grid[0].length, count = 0;
    for(int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1') {
          count++;
          dfs(grid, i, j);
        }
      }
    }
    return count;
  }

  public static void dfs(char[][] grid, int i, int j) {
    int rows = grid.length, cols = grid[0].length;
    if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0';
    dfs(grid, i-1, j);
    dfs(grid, i+1, j);
    dfs(grid, i, j-1);
    dfs(grid, i, j+1);
  }

  public static void main(String[] args) {
    char[][] grid1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
    char[][] grid2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
    System.out.println(numberOfIslands(grid1));
    System.out.println(numberOfIslands(grid2));
  }
}
