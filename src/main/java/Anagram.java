import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class Anagram {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/anagram", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/anagram.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/isitananagram", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String enteredWords = request.queryParams("wordEntry");
      enteredWords = enteredWords.toLowerCase();
      ArrayList<String> foundWords = new ArrayList<String>();
      foundWords = Anagram.anyAnagrams(enteredWords);
      String foundWordsString = Anagram.anagramPrintout(foundWords);
      model.put("originalWords", enteredWords);
      model.put("foundWords", foundWordsString);
      model.put("template", "templates/isitananagram.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }

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

  public static ArrayList<String> anyAnagrams(String enteredWords) {
    ArrayList<String> wordList = new ArrayList<String>();
    String[] splitWords = enteredWords.split(" ");

    for (Integer i = 0 ; i < splitWords.length - 1 ; i++) {
      for (Integer j = i + 1 ; j < splitWords.length ; j++) {
        if(isAnagram(splitWords[i], splitWords[j])) {
          if(!wordList.contains(splitWords[i])) {
            wordList.add(splitWords[i]);
          }
          if(!wordList.contains(splitWords[j])) {
            wordList.add(splitWords[j]);
          }
        }
      }
    }
    return wordList;
  }

  public static String anagramPrintout(ArrayList<String> anagramArray) {
    String prettyResult = "";
    for (Integer i = 0 ; i < anagramArray.size() ; i++) {
      prettyResult += "<li>" + anagramArray.get(i) + "</li>";
      if (i+1 < anagramArray.size() && !isAnagram(anagramArray.get(i), anagramArray.get(i+1))) {
        prettyResult += "</ul></div><div class='panel-body'><ul>";
      }
    }
    return prettyResult;
  }
}
