/*
Leetcode Problem 470: Implement Rand10() Using Rand7()
https://leetcode.com/problems/implement-rand10-using-rand7/description/

Given a function rand7 which generates a uniform random integer in the range 1 to 7,
write a function rand10 which generates a uniform random integer in the range 1 to 10.

Do NOT use system's Math.random().

Example 1:
Input: 1
Output: [7]

Example 2:
Input: 2
Output: [8,4]

Example 3:
Input: 3
Output: [8,1,10]

Note:
rand7 is predefined.
Each testcase has one argument: n, the number of times that rand10 is called.

Follow up:

What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?
*/

import java.util.Random;

class ImplementRand10UsingRand7 {

  // Returns an integer between 1 and 10 inclusives
  public static int rand10() {
    int cellValue = 41, row, col;
    while (cellValue > 40) {
      row = rand7();
      col = rand7();
      cellValue = 7 * (row - 1) + col;
    }
    return 1 + (cellValue - 1) % 10; // reverse engineer to get the corresponding probability value
  }

  // Returns an integer between 1 and 7 inclusives
  public static int rand7() {
    Random random = new Random();
    return random.nextInt(7) + 1;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(rand10());
    }
  }
}
