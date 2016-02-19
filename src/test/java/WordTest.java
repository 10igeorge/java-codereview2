import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true(){
    Word newWord = new Word("Internet");
    assertEquals(true, newWord instanceof Word);
  }
}
