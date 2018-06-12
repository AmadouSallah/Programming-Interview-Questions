/*
Leetcode Problem 72. Edit Distance
https://leetcode.com/problems/edit-distance/description/

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/

// Using recursion: O(3^m), where m = word1.length() =>  Time Limit Exceeded
public class MinDistance {

  public static int minDistance(String word1, String word2) {
    return minDistance(word1, word2, word1.length(), word2.length());
  }

  public static int minDistance(String s1, String s2, int n1, int n2) {
    // if 1st string s1 is empty, the only option is to insert all characters of s2 into s1
    if (n1 == 0) return n2;

    // if s2 is empty, the only option is to remove all characters of s1
    if (n2 == 0) return n1;

    // if the last 2 chars are the same, we skip last chars and recurse for remaining strings
    if (s1.charAt(n1-1) == s2.charAt(n2-1)) {
      return minDistance(s1, s2, n1-1, n2-1);
    }

    // if last 2 chars are not the same, we consider all 3 possibilities
    // (insert, delete, and replace) and take the min of all 3
    int insert = minDistance(s1, s2, n1, n2-1); // recurse for n1 and n2-1
    int delete = minDistance(s1, s2, n1-1, n2); // recurse for n1-1 and n2
    int replace = minDistance(s1, s2, n1-1, n2-1); // recurse for n1-1 and n2-1
    return 1 + min(insert, delete, replace);
  }

  public static int min(int a, int b, int c) {
    return Math.min(a, Math.min(b, c));
  }

  public static void main(String[] args) {
    System.out.println("Using recursion:");
    System.out.println("minDistance(\"sunday\", \"saturday\") = " + minDistance("sunday", "saturday"));
    System.out.println("minDistance(\"horse\", \"ros\") = " + minDistance("horse", "ros"));
    System.out.println("minDistance(\"intention\", \"execution\") = " + minDistance("intention", "execution"));
  }
}
