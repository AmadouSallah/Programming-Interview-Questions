/*
Number of 1 Bits
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/

public class HammingWeight {
  public static int hammingWeight(int n) {
    int k = 0; // represents the number of bits set to 1
    while (n != 0) {
      // n & (n-1) removes the lowest set bit (replaces it by 0)
      // Example: n = 5 (101), 5 & 4 (101 & 100) = 100
      n &= n-1;
      k++;
    }
    return k;
  }

  public static void main(String[] args) {
    System.out.println("For x = 0, the numebr of set bits is " + hammingWeight(0));
    System.out.println("For x = 1, the numebr of set bits is " + hammingWeight(1));
    System.out.println("For x = 2, the numebr of set bits is " + hammingWeight(2));
    System.out.println("For x = 3, the numebr of set bits is " + hammingWeight(3));
    System.out.println("For x = 8, the numebr of set bits is " + hammingWeight(8));
    System.out.println("For x = 7, the numebr of set bits is " + hammingWeight(7));
    System.out.println("For x = 11, the numebr of set bits is " + hammingWeight(11));
  }
}