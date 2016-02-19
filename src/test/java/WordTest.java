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
}
