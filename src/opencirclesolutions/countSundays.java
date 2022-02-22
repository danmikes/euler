package opencirclesolutions;

/**
 * count Sundays on first of month : 1 Jan 1901 - 31 Dec 2000
 */
public class countSundays {

  public static void main(String[] args) {
    System.out.println("number of Sundays on first of month : " + countSundays());
  }

  private static int countSundays() {
    // initialise count
    int count = 0;

    // iterate over years
    for (int y = 1901; y < 2000; y++) {
      // iterate over months
      for (int m = 1; m <= 12; m++) {
        // count Sundays
        if (dayOfWeek(y,m,1) == 0) {
          count ++;
        }
      }
    }

    return count;
  }

  private static int dayOfWeek(int year, int month, int day) {
    long m = mod((long) month - 3, 4800);
    long y = mod(year + m / 12, 400);
    m %= 12;

    return (int) ((y + y/4 - y/100 + (13 * m + 2) / 5 + day + 2) % 7);
  }

  private static long mod (long x, long y) {
    x %= y;
    if (y > 0 && x < 0 || y < 0 && x > 0) {
      x += y;
    }

    return x;
  }
}
