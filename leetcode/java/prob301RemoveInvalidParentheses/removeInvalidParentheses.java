/*
https://leetcode.com/problems/remove-invalid-parentheses/#/description

Problem 301. Remove Invalid Parentheses

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

*/

/*
Resources: https://discuss.leetcode.com/topic/28827/share-my-java-bfs-solution

Using BFS
Generate all possible states by removing '(' or ')'
For each state, check if valid
    If valid, add to the result.
    Otherwise, add to queue and move on

Runtime: n*2^n
    There are n characters and for each, we decide whether to keep it or remove it => O(2^n)
    For each string, we check whether it is valid or not: O(n)
    Thus, O(n * 2^n)
*/
import java.util.*;

public class RemoveInvalidParentheses {

  public static List<String> removeInvalidParentheses(String s) {
    List<String> result = new ArrayList<>();

    if (s == null) return result;

    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    boolean found = false;

    queue.add(s);
    visited.add(s);

    while (!queue.isEmpty()) {
      String currentString = queue.poll();

      // currentString is valid, add to result and set found to true
      if (isValid(currentString)) {
          result.add(currentString);
          found = true;
      }

      if (found) continue;

      // Generate all possible states by removing '(' or ')'
      for (int i = 0; i < currentString.length(); i++) {
        char c = currentString.charAt(i);

        // skip if c is neither '(' or ')'
        if (c != '(' && c != ')') continue;

        // let str be the substring by removing c
        String str = currentString.substring(0, i) + currentString.substring(i+1);
        // if str has not been seen before, we add it to queue and visited
        if (!visited.contains(str)) {
          queue.add(str);
          visited.add(str);
        }
      }
    }

    return result;
  }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        int count = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false; // more ')' than '('
        }
        return count == 0;
    }

    public static void main(String[] args) {
      System.out.println("removeInvalidParentheses(\"()())()\") = " + removeInvalidParentheses("()())()")); // -> ["()()()", "(())()"]
      System.out.println("removeInvalidParentheses(\"(a)())()\") = " + removeInvalidParentheses("(a)())()")); // -> ["(a)()()", "(a())()"]
      System.out.println("removeInvalidParentheses(\")(\") = " + removeInvalidParentheses(")(")); // -> [""]
    }  
}
