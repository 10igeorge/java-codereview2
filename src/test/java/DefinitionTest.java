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
}
