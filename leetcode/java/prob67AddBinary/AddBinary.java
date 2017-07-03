/*
https://leetcode.com/problems/add-binary/#/description

Problem 67: Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class AddBinary {

  public static String addBinary(String a, String b) {

    int n1 = a.length() - 1, n2 = b.length() - 1, sum, carry = 0;
    StringBuilder sb = new StringBuilder();

    while (carry > 0 || n1 >=0 || n2 >= 0) {
      sum = carry; // reset sum to the value of carry
      if (n1 >= 0) sum += a.charAt(n1--) - '0';
      if (n2 >= 0) sum += b.charAt(n2--) - '0';

      carry = sum / 2;
      sb.append(sum % 2);
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println("addBinary(\"0\", \"0\") = " + addBinary("0", "0"));
    System.out.println("addBinary(\"0\", \"1\") = " + addBinary("0", "1"));
    System.out.println("addBinary(\"10\", \"0\") = " + addBinary("10", "0"));
    System.out.println("addBinary(\"01\", \"0\") = " + addBinary("01", "0"));
    System.out.println("addBinary(\"01\", \"10\") = " + addBinary("01", "10"));
    System.out.println("addBinary(\"11\", \"1\") = " + addBinary("11", "1"));
  }

}
