/*
Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}',
'[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}"
are all valid but "(]" and "([)]" are not.

*/

/*
PSEUDOCODE

If the input string is null or if its length is 0, we return true.

We initialize a hashmap whose keys will be the openings - (, [, and {,
and whose values will be the corresponding closings - ), [, or }.
We also initialize 2 HashSets, openings and closings; openings will contain
the keys of the hashmap-(, [, and {- whereas closings will contain its values-), [, and }.
Finally, we initialize a stack.

We iterate through the input string s.
  For each character of s:
    If it is in the openings set, that is, it is either (, [, or {, we then push it to the stack.
    If it is in the closings set, that is, it is either ), [, or },
    we return false if any of the followings 2 is valid:
      1) If the stack is empty, meaning that the current closing has no corresponding opening.
      2) If the hashmap value of the last element of the stack is not the same as the current value:

Once we are done iterating through the input string s, we check if the stack is empty or not.
If it is empty (meaning all openings has been matched), we return true; otherwise we return false.
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public class IsValid {

  public static boolean isValid(String s) {

    if (s == null || s.length() == 0) return true;

    Map<Character, Character> openingsClosings = new HashMap<Character, Character>();
    openingsClosings.put('(', ')');
    openingsClosings.put('[', ']');
    openingsClosings.put('{', '}');

    Set<Character> openings = new HashSet<Character>(openingsClosings.keySet());
    Set<Character> closings = new HashSet<Character>(openingsClosings.values());

    Stack<Character> stack = new Stack<Character>();

    int len = s.length();

    for (int i = 0; i < len; i++) {
      char currentCharacter = s.charAt(i);
      if (openings.contains(currentCharacter)) {
        stack.push(currentCharacter);
      } else if (closings.contains(currentCharacter)) {
        if (stack.isEmpty() || currentCharacter != openingsClosings.get(stack.pop())) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println("isValid(null) = " + isValid(null));
    System.out.println("isValid(\"\") = " + isValid(""));
    System.out.println("isValid(\"()\") = " + isValid("()"));
    System.out.println("isValid(\"()[]{}\") = " + isValid("()[]{}"));
    System.out.println("isValid(\"a(b)cd[e]f{g}hij\") = " + isValid("a(b)cd[e]f{g}hij"));
    System.out.println("isValid(\"(]\") = " + isValid("(]"));
    System.out.println("isValid(\"([)]\") = " + isValid("([)]"));
    }
}