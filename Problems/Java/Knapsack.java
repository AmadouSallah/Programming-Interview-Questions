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
