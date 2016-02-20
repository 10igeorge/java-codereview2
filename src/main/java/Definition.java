import java.util.*;

public class Definition{
  private static ArrayList<Definition> instances = new ArrayList<Definition>();
  private String mDefinition;

  public Definition(String definition){
    mDefinition = definition;
    instances.add(this);
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public String getDefinition(){
    return mDefinition;
  }

}
