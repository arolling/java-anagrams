import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class Anagram {
  public static void main(String[] args) {}

  public static Boolean isAnagram(String wordOne, String wordTwo) {
    char[] wordOneChars = wordOne.toCharArray();
    char[] wordTwoChars = wordTwo.toCharArray();
    Arrays.sort(wordOneChars);
    Arrays.sort(wordTwoChars);
    if (Arrays.equals(wordOneChars, wordTwoChars)) {
      return true;
    } else {
      return false;
    }
  }

  public static ArrayList<Object> anyAnagrams(String enteredWords) {
    ArrayList<Object> wordList = new ArrayList<Object>();
    return wordList;
  }
}
