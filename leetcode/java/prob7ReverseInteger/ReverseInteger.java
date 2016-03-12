public class ReverseInteger {

  public static int reverse(int x) {

    long xReversed = 0;

    for (int y = x; y != 0; y /= 10)
      xReversed = xReversed * 10 + y % 10;

    if (xReversed > Integer.MAX_VALUE || xReversed < Integer.MIN_VALUE) {
      return 0;
    } else {
      return (int) xReversed;
    }

  }

  public static void main(String[] args) {
    System.out.println("reverse(-123) = " + reverse(-123));
    System.out.println("reverse(123) = " + reverse(123));
    System.out.println("reverse(-1534236469) = " + reverse(-1534236469));
    System.out.println("reverse(1534236469) = " + reverse(1534236469));
  }
}