/*
String to Integer (atoi)

Implement atoi to convert a string to an integer.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

public class StringToInteger {
  public static int myAtoi(String str) {

    if (str == null || str.isEmpty()) return 0;

    str = str.trim();

    long result = 0;
    int i = 0, sign = 1, len = str.length();
    int smallestInteger = Integer.MIN_VALUE;
    int largestInteger = Integer.MAX_VALUE;

    if (str.charAt(i) == '+') {
      i++;
    } else if (str.charAt(i) == '-') {
      sign = -1;
      i++;
    }

    for (int j = i; j < len; j++) {

      char currentChar = str.charAt(j);

      /* if the current character is not a digit, return */
      if (!Character.isDigit(currentChar)) {
          return (int) result * sign;
      }

      int currentDigit = currentChar - '0';
      result = result * 10 + currentDigit;

      /* if result is outside of the range of int values, return 0 */
      if ( (result > largestInteger) && (sign == 1) ) {
        return largestInteger;
      }
      if (-1 * result < smallestInteger && sign == -1) {
        return sign * smallestInteger;
      }
    }

      return (int) result * sign;
    }

    public static void main(String[] args) {
        System.out.println("myAtoi(\"   h-12i \") is: " + myAtoi("   h-12i ") );
        System.out.println("myAtoi(\"--123\") is: " + myAtoi("--123") );
        System.out.println("myAtoi(\"+123hi \") is: " + myAtoi("+123hi "));
        System.out.println("myAtoi(\"+12345\") is: " + myAtoi("+12345"));
        System.out.println("myAtoi(\"-12345\") is: " + myAtoi("-12345"));
        System.out.println("myAtoi(\"+2147483648\") is: " + myAtoi("+2147483648"));
        System.out.println("myAtoi(\"-2147483649\") is: " + myAtoi("-2147483649"));
    }
}