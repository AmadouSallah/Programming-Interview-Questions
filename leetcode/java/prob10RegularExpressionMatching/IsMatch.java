/*
Regular Expression Matching

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
PSEUDOCODE:

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

public class IsMatch {

  public static boolean isMatch(String s, String p) {
    if (p.isEmpty()) return s.isEmpty();

    int pLen = p.length(), sLen = s.length();

    if (p.charAt(pLen-1) == '*') {
      if ( (sLen > 0) && ( (s.charAt(sLen-1) == p.charAt(pLen-2)) || (p.charAt(pLen-2) == '.') ) ) {
        return isMatch(s.substring(0, sLen-1), p) || isMatch(s, p.substring(0, pLen-2));
      } else {
        return isMatch(s, p.substring(0, pLen-2));
      }
    } else {
        if ( (sLen > 0) && ( (s.charAt(sLen-1) == p.charAt(pLen-1)) || (p.charAt(pLen-1) == '.') ) ) {
          return isMatch(s.substring(0, sLen-1), p.substring(0, pLen-1));
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