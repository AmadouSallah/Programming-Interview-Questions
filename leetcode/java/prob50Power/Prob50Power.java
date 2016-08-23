/*
Prob 50: Pow(x, n)

Implement pow(x, n).
*/

/*
        PSEUDOCODE:
myPow(x, n):

If n is 0, we return 1 since any number to the power of 0 is 1
if n is 1, we return x since any number to the power of 1 is itself
if n < 0, we return (1/x) * myPow(1/x, -(n+1))
   We could have just return myPow(1/x, -n), but we want to avoid overflow for the case where n is at the borderline
   of integers (i.e, n = -2147483648).
    Example, x^(-3) = (1/x)^3 = (1/x) * (1/x)^2 = (1/x) * (1/x)^(-(-2)) = (1/x) * [(1/x)^(-(-3+1)] = 1/x * [(1/x)^2]

For all other cases, we do the followings:

We know that, for any integers n and k, we can rewrite n as: n = k * (n/k) + (n % k).
For k = 2, n = 2 * (n/2) + (n % 2).

Example:
7 = 2*(7 / 2) + 7 % 2 = 2*(3) + 1
6 = 2*(6 / 2) + 6 % 2 = 2*(3) + 0
4 = 3*(4 / 3) + 4 % 3 = 3*(1) + 1

We will be using the formulas below to simplify:

pow(x, a*b) = pow(x, b*a)
pow(x, a+b) = pow(x, b+a)
pow(x, a*b) = pow(pow(x, a), b), i.e. x^(a*b) = (x^(a))^b
pow(x, a+b) = pow(x, a) * pow(x, b), i.e x^(a+b) = (x^a) * (x^b)

Since n = 2 * (n/2) + (n % 2), we have:
pow(x, n) = pow(x, [ 2*(n/2) + (n%2) ] ) = pow(x, 2*(n/2) ) * pow(x, (n%2)) =
          = pow(x, (n/2)*2 ) * pow(x, (n%2)) = pow( pow(x, n/2), 2) * pow(x, (n%2))

Using the ^ sign, we can rewrite the above formula as:
x^n = x^[ 2*(n/2) + (n % 2) ] = x^( 2*(n/2) ) * x^(n % 2) =
    = [ x^( (n/2)*2 ) ] * x^(n % 2) = [ (x^(n/2)) ^ 2 ] * x^(n % 2)

Let y = pow(x, n/2), i.e y = x^(n/2)
Also, let r = n % 2 and z = pow(x, n%2) = pow(x, r).

Therefore,
result = pow(x, n) = pow( pow(x, n/2), 2) * pow(x, (n%2)) =
       = pow(y, 2) * pow(x, r) = (y^2) * (x^r) = (y*y) * (x^r)

But, since r = n%2 is either 0 or 1, x^r is therefore either 1 (if r=0) or x (if r=1)
Thus, our result will be:
if r = n%2 = 0, result = (y*y). Otherwise, result = (y*y) * x
( Remember y = pow(x, n/2) = x^(n/2) )
*/

public class Prob50Power {
  public static double myPow(double x, int n) {
    if (n == 0) return 1;
    if (n == 1) return x;
    if (n < 0) return ( (1/x) * myPow(1/x, -(n+1)) );

    double y = myPow(x, n/2);
    double z = y*y;
    int r = n % 2;

    return (r == 0) ? z : z*x;
  }

  public static void main(String[] args) {

    System.out.println(myPow(3, 0)); // 1.0
    System.out.println(myPow(2, 1)); // 2.0
    System.out.println(myPow(4, -1)); // 0.25
    System.out.println(myPow(2, 2)); // 4.0
    System.out.println(myPow(2, 5)); // 32.0
    System.out.println(myPow(3, 4)); // 81.0
    System.out.println(myPow(5, 3)); // 125.0
    System.out.println(myPow(2, 2147483647)); // Infinity
    System.out.println(myPow(2, -2147483648)); // 0.0
  }
}