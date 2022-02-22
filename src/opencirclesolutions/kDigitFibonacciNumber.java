package opencirclesolutions;

import java.math.BigInteger;

/**
 * give index of first term in Fibonacci sequence with 1000 digits
 */
public class kDigitFibonacciNumber {

  public static void main(String[] args) {
    System.out.println("index of first term in Fibonacci sequence with 1000 digits : " + kDigitFibonacciNumber());
  }

  private static int kDigitFibonacciNumber() {
    // set values
    int i = 0;
    int cnt = 2;
    // set upper limit -> 10^999
    BigInteger limit = (new BigInteger("10")).pow(999);
    // initialise fib as BigInteger array with length = 3
    BigInteger[] fib = new BigInteger[3];

    // set fib[0,2] -> 1
    fib[0] = BigInteger.ONE;
    fib[2] = BigInteger.ONE;

    // iterate over fibonacci terms until term > limit
    while ((fib[i]).compareTo(limit) < 0) {
      i = (i + 1) % 3;
      cnt++;
      fib[i] = fib[(i + 1) % 3].add(fib[(i + 2) % 3]);
    }

    return cnt;
  }
}
