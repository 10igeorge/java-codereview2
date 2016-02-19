import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest{

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void getDefinition_returnsADefinition_true(){
    Definition newDefinition = new Definition("A super cute and unique nocturnal burrowing mammal with long ears, a tubular snout, and extensible tounge used for eating small insects such as ants and termites.");
  }
}
