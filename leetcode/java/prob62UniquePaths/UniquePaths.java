/*
Problem 62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to
reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Note: m and n will be at most 100.
*/

/*
SOLUTION 1: DYNAMIC PROGRAMMING

We 1st initialize a 2-D array, dp
At any point on the 1st row (i = 0), there is only ONE way to reach that point, i.e coming left (horizontally
from the point behind it where row = 0, column = j-1 )
Similarly, when we are on the 1st column (j = 0), there is only ONE way to reach that point, i.e coming from
top (vertically from the point above it where row = i-1, column = 0)
Thus, if i = 0 or j = 0, dp[i][j] = 1

At any other point, we can reach that location by either coming from its top (where row = i-1, column = j)
or coming from its left (where row = i, column = j-1). Therefore dp[i][j] = dp[i-1][j] + dp[i][j-1]

We return the last value of dp, that is dp[m-1][n-1]
*/

public class UniquePaths {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
      }
    }
    return dp[m-1][n-1];
  }
}
