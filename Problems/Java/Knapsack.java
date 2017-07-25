/*

Resources:
http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
https://en.wikipedia.org/wiki/Knapsack_problem

Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of
this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

Input: An integer array of weights
           An integer array of values
           The ith item is weights[i] and values[i].
Output: Integer of maximum total value

Example
Input: value =  [60, 100, 120],
       weight = [10, 20, 30],
       knapsack capacity W = 50
OUtput: 220 (100 + 120), i.e. 1 item of weight 20kg (value of 100) + 1 item of weight 30kg (value = 120)

*/

/*
PSUEDOCODE

A brute force solution is to consider all subsets of items and calculate the total weight and value of all subsets.
Consider the only subsets whose total weight is smaller than W. From all such subsets, pick the maximum value subset.

Solution 1: Recursive (Overlapping sub problems)
To consider all subsets of items, there can be two cases for every item:
  (1) the item is included in the optimal subset,
  (2) the item is not included in the optimal subset.
Therefore, the maximum value that can be obtained from n items is max of following two values.
  1) Maximum value obtained by n-1 items and W weight (excluding nth item).
  2) Value of nth item plus maximum value obtained by n-1 items and W minus weight of the nth item (including nth item).

If weight of nth item is greater than W, then the nth item cannot be included and case 1 is the only possibility.
*/

public class Knapsack {
  // Solution 1: Recursive
  public static int knapSack1(int[] value, int[] weight, int capacity) {
    // Base case:
    if (value == null ||  weight == null || value.length == 0 || weight.length == 0) {
      return 0;
    }
    // n is the number of items to put in the knpaSack
    int n = value.length; // same as weight.length;

    return knapSackHelper(value, weight, capacity, n);
  }

  public static int knapSackHelper(int[] value, int[] weight, int capacity, int n) {
    // Base calse:
    if (n == 0 || capacity == 0) { // n =number of items to put in knapSack. n = 0 means no item to put in knapSack
      return 0;
    }

    // if the weight of the nth item is greater than the capacity, then this last nth item
    // cannot be part of the solution. So we make a recursive call on the first n-1 items
    if (weight[n-1] > capacity) {
      return knapSackHelper(value, weight, capacity, n-1);
    }

    // Otherwise, we return the maximum of 2 cases:
    // 1) the nth item is included
    // 2) the nth item is not included
    int nthItemIncluded = value[n-1] + knapSackHelper(value, weight, capacity-weight[n-1], n-1);
    int nthItemNotIncluded = knapSackHelper(value, weight, capacity, n-1);
    return Math.max(nthItemIncluded, nthItemNotIncluded);
  }

  public static void main(String[] args) {
    int[] value = {60, 100, 120}, weight = {10, 20, 30};
    int capacity = 50;
    System.out.println("For value = [60, 100, 120], weight = [10, 20, 30], and capacity = 50, the maximum the knapsack can hold is: " + knapSack1(value, weight, capacity));
  }
}
