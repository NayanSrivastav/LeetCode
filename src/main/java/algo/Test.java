package algo;

import java.util.ArrayList;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    System.out.println(printVertically("CONTEST IS COMING"));
  }

  public static List<String> printVertically(String s) {
    String[] words = s.split(" ");
    List<String> res = new ArrayList<>();
    int columnSize = 0;
    for (String word : words) {
      columnSize = Math.max(columnSize, word.length());
    }
    for (int j = 0; j < columnSize; j++) {
      StringBuilder word = new StringBuilder();
      for (int i = 0; i < words.length; i++) {
        if (words[i].length() > j) {
          word.append(words[i].charAt(j));
        } else {
          word = word.append(" ");
        }
      }
      String w = word.toString().stripTrailing();
      if (!w.equals("")) {
        res.add(w);
      } else {
        break;
      }
    }

    return res;
  }
}
