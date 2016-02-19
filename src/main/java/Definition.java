import java.util.*;

public class Definition{
  private static ArrayList<Definition> definitions = new ArrayList<Definition>();
  private String mDefinition;
  private int mId;

  public Definition(String definition){
    mDefinition = definition;
  }

  public String getDefinition(){
    return mDefinition;
  }

  public static void clear(){
    definitions.clear();
  }

}
