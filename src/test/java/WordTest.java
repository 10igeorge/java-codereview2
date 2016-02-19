import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

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

  @Test
   public void getAllDefinitions_initiallyReturnsEmptyArrayList() {
     Word newWord = new Word("Aardvark");
     assertEquals(true, newWord.getAllDefinitions() instanceof ArrayList);
   }

  @Test
  public void addDefinition_addsNewDefinitionToWord(){
    Word newWord = new Word("Internet");
    Definition newDef = new Definition("An addiction");
    newWord.addDefinition(newDef);
    assertEquals(true, newWord.getAllDefinitions().contains(newDef));
  }


  @Test
  public void find_returnsNullWhenNoWordFound_null(){
    assertTrue(Word.find(999) == null);
  }

  @Test
  public void clear_emptiesWordsFromArrayList(){
    Word newWord = new Word("Internet");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }
}
