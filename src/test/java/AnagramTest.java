import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class AnagramTest {
  @Test
  public void isAnagram_compareCharacters_returnFalse() {
    assertEquals(false, Anagram.isAnagram("a","b"));
  }

  @Test
  public void isAnagram_compareCharacters_returnTrue() {
    assertEquals(true, Anagram.isAnagram("a","a"));
  }

  @Test
  public void isAnagram_compareAnagramWords_returnTrue() {
    assertEquals(true, Anagram.isAnagram("resistance","ancestries"));
  }

  @Test
  public void isAnagram_compareNonAnagramWords_returnFalse() {
    assertEquals(false, Anagram.isAnagram("married","ancestries"));
  }

  @Test
  public void anyAnagrams_splitsListOfTwoWordsAndChecksForAnagrams_returnAnagramArray() {
    ArrayList<String> testList = new ArrayList<String>();
    String[] wordArray = {"resistance","ancestries"};
    testList.add(wordArray[1]);
    testList.add(wordArray[0]);
    assertEquals(testList, Anagram.anyAnagrams("resistance ancestries"));
  }

  @Test
  public void anyAnagrams_splitsListOfSeveralWordsAndChecksForAnagrams_returnAnagramArray() {
    ArrayList<String> testList = new ArrayList<String>();
    String[] wordArray = {"resistance", "return", "meteor", "ancestries"};
    testList.add(wordArray[3]);
    testList.add(wordArray[0]);
    assertEquals(testList, Anagram.anyAnagrams("resistance return meteor ancestries"));
  }

  @Test
  public void anyAnagrams_ChecksForDuplicateAnagrams_returnAnagramArray() {
    ArrayList<String> testList = new ArrayList<String>();
    String[] wordArray = {"cat", "tac", "meteor", "act", "etemor"};
    testList.add(wordArray[3]);
    testList.add(wordArray[0]);
    testList.add(wordArray[4]);
    testList.add(wordArray[2]);
    testList.add(wordArray[1]);
    assertEquals(testList, Anagram.anyAnagrams("cat tac meteor act etemor"));
  }
}
