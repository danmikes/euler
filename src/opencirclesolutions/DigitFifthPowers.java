package opencirclesolutions;

/**
 * find sum of all numbers equal to sum of fifth powers of their digits
 */
public class DigitFifthPowers {

  public static void main(String[] args) {
    System.out.println("sum of all numbers equal to sum of fifth powers of their digits = " + digitFifthPowers());
  }

  private static int digitFifthPowers() {
    // initialise result
    int result = 0;

    // iterate over numbers from 1_000_000_000
    for (int i = 1_000_000; i > 1; i--) {
      if (i == sumOfFifthPowers(i)) {
        result += i;
      }
    }

    return result;
  }

  private static int sumOfFifthPowers(int number) {
    // initialise value
    int value = number;

    // iterate over digits
    for (int i = number; i > 1; i/=10) {
      // add digit to power 5 to value
      value += Math.pow(i % 10, 5);
    }

    return value;
  }
}
