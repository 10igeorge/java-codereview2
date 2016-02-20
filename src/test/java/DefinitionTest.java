import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest{

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void definition_initializesCorrectly() {
    Definition newDefinition = new Definition("A definition of an aardvark");
    assertEquals(true, newDefinition instanceof Definition);
  }

  @Test
  public void getDefinition_returnsADefinition_true(){
    Definition newDefinition = new Definition("A definition of an aardvark");
    assertEquals("A definition of an aardvark", newDefinition.getDefinition());
  }

  @Test
  public void all_returnsAllDefinitionEntries() {
    Definition firstDefinition = new Definition("A definition 1");
    Definition secondDefinition = new Definition("A definition 2");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }
}
