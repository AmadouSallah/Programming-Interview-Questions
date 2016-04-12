/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

*/

public class CountBits {
  public static int[] countBits(int n) {
    int[] result = new int[n+1];
    for (int i = 0; i <= n; i++)
      result[i] = numberOfOnes(i);
    return result;
  }

  public static int numberOfOnes(int n) {
    int k = 0;
    while (n != 0) {
      n &= n-1;
      k++;
    }
    return k;
  }

  public static String printArray(int[] arr) {
    String result = "[";
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      result += arr[i];
      if (i < len-1)
        result += ", ";
    }
    result += "]";
    return result;
 }

  public static void main(String[] args) {
    System.out.println("countBits(0) = " + printArray(countBits(0)));
    System.out.println("countBits(1) = " + printArray(countBits(1)));
    System.out.println("countBits(2) = " + printArray(countBits(2)));
    System.out.println("countBits(5) = " + printArray(countBits(5)));
    System.out.println("countBits(11) = " + printArray(countBits(11)));
  }
}