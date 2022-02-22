package opencirclesolutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * calculate sum of name scores of names in file
 * name score = alphabetical value * alphabetical position in file
 */
public class NameScore {

  public static void main(String[] args) {
    System.out.println("total sum of name scores = " + nameScore());
  }

  private static int nameScore() {
    List<String> list = new ArrayList<>();

    try {
      // initialise scanner
      Scanner scanner = new Scanner(new File("names.txt"));
      scanner.useDelimiter(",");
      // iterate over names
      while (scanner.hasNext()) {
        // add name to list
        list.add(scanner.next());
      }
    } catch (FileNotFoundException error) {
      System.out.println("file not found");
      error.printStackTrace();
    }

    // sort list -> sortedList
    List<String> sortedList = list.stream()
      .sorted()
      .collect(Collectors.toList());

    return sumNameScores(sortedList);
  }

  // give sum of name scores
  private static int sumNameScores(List<String> sortedList) {
    int sumNameScores = 0;

    // calculate sum of name score
    for (int i = 0; i < sortedList.size(); i++) {
      // add name score to sum of name scores
      sumNameScores += nameScore(sortedList.get(i), i);
    }

    return sumNameScores;
  }

  // give alphabetic value of name
  private static int nameScore(String name, int id) {
    int nameValue = 0;

    // iterate over name characters
    for (char ch : name.toCharArray()) {
      // give alphabetical value of character
      nameValue += 1 + ch - 'A';
    }
    // calculate name score
    return nameValue * id;
  }
}
