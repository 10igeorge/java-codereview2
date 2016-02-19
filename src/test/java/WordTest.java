import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_instantiatesCorrectly_true(){
    Word newWord = new Word("Internet");
    assertEquals(true, newWord instanceof Word);
  }

  @Test
  public void getWord_returnsWordCorrectly(){
    Word newWord = new Word("Internet");
    assertEquals("Internet", newWord.getWord());
  }

  @Test
  public void all_returnsAllInstancesOfWord(){
    Word firstWord = new Word("Internet");
    Word secondWord = new Word("Aardvark");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void getId_createsIdForEachWord(){
    Word newWord = new Word("Internet");
    assertEquals(Word.all().size(), newWord.getId());
  }
}
