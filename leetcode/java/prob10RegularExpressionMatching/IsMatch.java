/*
Leetcode Problem 10: Regular Expression Matching
https://leetcode.com/problems/regular-expression-matching/description/

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
boolean isMatch(String s, String p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

/*
DYNAMIC PROGRAMMING: O(nm) runtime and O(nm) space complexities, where m is the
length of s, and n that of p.

Let dp = new boolean[n+1][m+1]
dp[0][0] = true (s empty and p empty)

FIRST ROW:
In the 1st row, row 0, s is empty; Therefore, the only pattern that will
match s will be something like a*, a*b*, a*b*c* etc... The * here
represents 0 matching of previous character.

In the examples below, we assume that we are dealing with the last
characters of both s and p (i = s.length() -1, j = p.length() - 1)
For simplification, I'll note s[i] as s.charAt(i), p[j] as p.charAt(j)

1) Case for (s[i] = p[j]) or if (p[j] = '.')
Example s = "abc", p = "dec" or p = "de."
The solution for this case will be the same as s1 = "ab"and p1 = "de"
Thus, dp[i][j] = dp[i-1][j-1]

2) Case for p[j] = '*'
We consider 2 subcases:

2-1) Case s[i] != p[j-1] and p[j-1] != '.'
Example s = "abc", p = "cd*"
In this case, '*' counts as 0 (0 match of preceding character d).
Thus, the solution is the same as that of s = "abc", p1 = "c"
Therefore, dp[i][j] = dp[i][j-2]

2-2) Else of 2-1, i.e.  s[i] == p[j-1] or p[j-1] == '.'
Example, s = "abc", p = "dbc*" or p = "db.*"
We then get 3 subcases depending if * counts for 0 match, 1 match, or
multiple (more than 1) matches of the preceding element

2-2-a) * counts for 0 match of the preceding element:
s = "abc", p = "dbc*" or p = "db.*"
0 match means it is the same as having s1 = "abc", p1 = "db"
Therefore, dp[i][j] = dp[i][j-2]

2-2-b) * counts for 1 match of the preceding element:
s = "abc", p = "dbc*" or p = "db.*"
1 match means it is the same as having s1 = "abc", p1 = "dbc" or "db."
Therefore, dp[i][j] = dp[i][j-1]

2-2-c) * counts for more than 1 matches. For simplicity, let's assume
* counts for 2 matches of the preceding character.
s = "abc", p = "dbc*" or p = "db.*"
2 matches means it is the same as s1 = "abc", p1 = "dbcc" or p1 = "db.."
The soulution would be the same as s2 = "ab", p2 = "dbcc" or p2 = "db.."
Therefore, dp[i][j] = dp[i-1][j]

NOTE: For s[i] ,p[j], the corresponding element of dp in our code will
be dp[i+1][j+1]. This is because we don't want to go to negative indices
when we go backward.
Example, in Case 1, where dp[i][j] = dp[i-1][j-1]. What if i or j is 0, then
dp[i-1][j-1] would be undefined. So in our code, we would instead write
the above as: dp[i+1][j+1] = dp[i][j]
*/

public class IsMatch {
  // Dynamic Programming
  public static boolean isMatch(String s, String p) {
    if (s == null || p == null) return false;
    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m+1][n+1];
    dp[0][0] = true; // both s and p are empty

    // 1st row (s empty). True only for patterns p = a*, a*b*, a*b*c*
    for (int j = 0; j < n; j++) {
      if (p.charAt(j) == '*' && dp[0][j-1])
        dp[0][j+1] = true;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ( (s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.') ) {
          dp[i+1][j+1] = dp[i][j];
        } else if (p.charAt(j) == '*') {
          if ( (s.charAt(i) != p.charAt(j-1)) && p.charAt(j-1) != '.' ) {
            dp[i+1][j+1] = dp[i+1][j-1];
          } else {
            dp[i+1][j+1] = dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1];
          }
        } else {
          dp[i+1][j+1] = false;
        }
      }
    }
    return dp[m][n];
  }

  // RECURSION
  public static boolean isMatch1(String s, String p) {
    if (p.isEmpty()) return s.isEmpty();

    int pLen = p.length(), sLen = s.length();

    if (p.charAt(pLen-1) == '*') {
      if ( (sLen > 0) && ( (s.charAt(sLen-1) == p.charAt(pLen-2)) || (p.charAt(pLen-2) == '.') ) ) {
        return isMatch1(s.substring(0, sLen-1), p) || isMatch1(s, p.substring(0, pLen-2));
      } else {
        return isMatch1(s, p.substring(0, pLen-2));
      }
    } else {
        if ( (sLen > 0) && ( (s.charAt(sLen-1) == p.charAt(pLen-1)) || (p.charAt(pLen-1) == '.') ) ) {
          return isMatch1(s.substring(0, sLen-1), p.substring(0, pLen-1));
        } else {
          return false;
        }
    }
  }

  public static void main(String[] args) {
    System.out.println("isMatch(\"\", \"\") = " + isMatch("", ""));
    System.out.println("isMatch(\"abc\", \"\") = " + isMatch("abc", ""));
    System.out.println("isMatch(\"\", \"abc*\") = " + isMatch("", "abc*"));
    System.out.println("isMatch(\"\", \"a*\") = " + isMatch("", "a*"));
    System.out.println("isMatch(\"aa\", \"a\")  = " + isMatch("aa", "a"));
    System.out.println("isMatch(\"aa\", \"aa\")  = " + isMatch("aa", "aa"));
    System.out.println("isMatch(\"aaa\", \"aa\")  = " + isMatch("aaa", "aa"));
    System.out.println("isMatch(\"aa\", \"a*\")  = " + isMatch("aa", "a*"));
    System.out.println("isMatch(\"aa\", \".*\")  = " + isMatch("aa", ".*"));
    System.out.println("isMatch(\"ab\", \".*\")  = " + isMatch("ab", ".*"));
    System.out.println("isMatch(\"aab\", \"c*a*b\")  = " + isMatch("aab", "c*a*b"));
  }
}

/*
RECURSION PSEUDOCODE:

Case 1: If the last character in p is '*'
We need to consider 2 sub cases

Case 1-1:
if
(s is not empty AND The last character in s is the same as the second to last character in p)
            OR
(s is not empty AND the second to last character in p is '.')

Case 1-1-a: s is not empty AND The last character in s is the same as
            the second to last character in p
Examples:
s="abc", p="abccc*" ('*' matches 1 or more of preceding character)
s="abc", p="abc*" ('*' matches 1 or more of preceding character)
For this case, we return a recursive call where p is unchanged and
the new s will be without the last character.

Case 1-1-b: s is not empty AND the second to last character in p is '.'
Example: s = "abc", p = "ab.*"
In this case, we return a recursive call where s is unchanged and p
is without the last 2 characters

Case 1-2: If case 1-1 is not valid:
This means that
s is empty OR
s is not empty but the last character in s is not the same as the
second to last character in p OR
s is not empty but the second to last character in p is not '.'
Example: s = "ab", p = "abc*" ('*' matches 0 of the preceding character)
In this case, we return a recursive call where s is unchanged and p is
without the last 2 characters

Case 2:
The last character in p is not '*'
If the last characters of p and s are the same or if the
last character of p is '.', we make a recurisve call with p and s without
their last characters.
Example: s = "abc"and p = adc or s = "abc" and p = "ab."

Otherwise, we return false.
Example: s = "abc" and p = "abd"
*/
