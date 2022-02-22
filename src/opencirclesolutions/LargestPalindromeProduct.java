package opencirclesolutions;

/**
 * Find largest palindrome made from product of two 3-digit numbers
 */
public class LargestPalindromeProduct {

  public static void main(String[] args) {
    System.out.println("largest palindrome product of two 3-digit numbers = " + reverseNumber(largestPalindromeProduct()));
  }

  private static int largestPalindromeProduct() {
    // return -1 in case no palindrome found
    int largestPalindrome = -1;
    // iterate over first 3-digit number
    for (int i = 999; i > 99; i --) {
      // iterate over second 3-digit number
      for (int j = 999; j > 99; j --) {
        // calculate product of both number
        int product = i * j;
        // product is palindrome and product > largestPalindrome
        if (reverseNumber(product) == product && product > largestPalindrome) {
          // print number reverse product
          System.out.println(i + " * " + j + " = " + product);
          // product -> largestPalindrome
          largestPalindrome = product;
        }
      }
    }

    return largestPalindrome;
  }

  private static int reverseNumber(int number) {
    // initialise reverse
    int reverse = 0;

    // iterate over digits
    while (number > 0) {
      // add last digit to reverse
      reverse = reverse * 10 + number % 10;
      // remove last digit
      number /= 10;
    }

    return reverse;
  }
}
