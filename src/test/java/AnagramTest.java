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
  public void anyAnagrams_splitsListOfTwoWordsAndChecksForAnagrams_returnAnagramArray() {
    ArrayList<Object> testList = new ArrayList<Object>();
    testList.add(["resistance","ancestries"]);
    assertEquals(testList, Anagram.isAnagram("resistance ancestries"));
  }
}
