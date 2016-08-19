/*

Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous.
You should gather all requirements up front before implementing one.

*/

/*
      PSUEDOCODE:

From left to right, we could divide the string into the following categories:

  1) Optional leading whitespaces
  2) Optional (+) or (-) sign
  3) Number
  4) Optional trailing whitespaces

For (3), a number is either a whole number (123) or a decimal number (123.45).
A decimal number has 3 parts:
  Integer part
  Decimal point (.)
  Fractional part

  "12.3", "12" (same as "12.0"), ."12" (same as "0.12") are all valid numbers
  "." is not a valid number.

A number could also contain an optional exponent part marked by 'e'.
'e' is followed by (+) or (-) sign (optional) and a whole number.

  "12e+3", "12e-3", "12e3" are all valid
  "12e+", "12e-",, e12, and "12e" are all invalid

So to solve the problem, we do the following cases;

We initialize isNumeric to false
Case 1: skip potential leading spaces
Case 2: skip potential (+) or (-) sign
Case 3: Number part: we skip as long as we have digits
Case 4: Decimal part
  isNumeric is set to true whenever there is an integer or franctional part.
  Example "1.2", "1.", ".1"
  This will allow isNumeric to be false for cases with neither
  integer, nor fractional parts (such as '.')

Case 5: 'e'

  For an exponent number to be valid, there must be at least 1 digit before 'e' (isNumeric must be true)
  and at least 1 digit after 'e'.
  Skip e
  We also make sure that there is at lease 1 digit after 'e' by setting isNumeric to false.
  This will make sure that if there is no digit following the exponent, the number is not valid.
  Example, "12e" is not valid, so by setting isNumeric to false right after 'e' will ensure this.
  Once another digit is encountered after 'e', isNumeric will be reset to true.

  Case 5a: Skip potential '+' or '-' sign
  Case 5b: Skip number part after 'e' and potential '+/-' sign
    We skip as long as we have digits
    Each time we reset isNumeric to true. This is to make sure that if there is an 'e' in the number,
    it must be followed by at least 1 digit to be valid.

// Case 6: Skip potential trailing spaces

We return i == n and isNumeric is true
*/

public class IsValidNumber {

  public static boolean isValid(String s) {
    if (s == null) return false;
    if (s.isEmpty()) return true;

    int i = 0, n = s.length();
    boolean isNumeric = false;

    // Case 1: skip potential leading spaces
    while (i < n && (s.charAt(i) == ' ')) i++;

    // Case 2: skip potential (+) or (-) sign
    if ( i < n && ( (s.charAt(i) == '+') || (s.charAt(i) == '-') )) i++;

    // Case 3: Number part
    while (i < n && Character.isDigit(s.charAt(i))) {
      i++;
      isNumeric = true;
    }

    // Case 4: Decimal part
    if (i < n && s.charAt(i) == '.') { // Example 1.2, .1, 1., '.'
      i++; // skip the point

      // Case 4a: skip the fractional part
      while (i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isNumeric = true;
      }
    }

    // Case 5: 'e'
    if (isNumeric && i < n && (s.charAt(i) == 'e') ) {
      i++;
      isNumeric = false;// to make sure that e must be followed by at least 1 digit to be valid

      // Case 5a: skip potential '+'/'-' sign
      if (i < n && ( (s.charAt(i) == '+') || (s.charAt(i) == '-') )) i++;

      // Case 5b: Skip number part after 'e' and potential '+/-' sign
      while (i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isNumeric = true; // Only 'e's followed by at least 1 digit are valid
      }
    }

    // Case 6: Skip potential trailing spaces
    while (i < n && (s.charAt(i) == ' ')) i++;

    return isNumeric && i == n;

  }

  public static void main(String[] args) {
    System.out.println("isValid(null) = " + isValid(null));
    System.out.println("isValid(\"\") = " + isValid(""));
    System.out.println("isValid(\"0\") = " + isValid("0"));
    System.out.println("isValid(\"   +123   \") = " + isValid("   +123   "));
    System.out.println("isValid(\"0.1\") = " + isValid("0.1"));
    System.out.println("isValid(\".1\") = " + isValid(".1"));
    System.out.println("isValid(\"1.\") = " + isValid("1."));
    System.out.println("isValid(\".\") = " + isValid("."));
    System.out.println("isValid(\"abc\") = " + isValid("abc"));
    System.out.println("isValid(\"1 a\") = " + isValid("1 a"));
    System.out.println("isValid(\"2e10\") = " + isValid("2e10"));
    System.out.println("isValid(\" 12e+34  \") = " + isValid(" 12e+34  "));
    System.out.println("isValid(\"12e-34\") = " + isValid("12e-34"));
    System.out.println("isValid(\"12e\") = " + isValid("12e"));
    System.out.println("isValid(\"e12\") = " + isValid("e12"));
    System.out.println("isValid(\"12e+\") = " + isValid("12e+"));
    System.out.println("isValid(\"12e-\") = " + isValid("12e-"));
  }
}
