import java.util.*;
import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> words = new ArrayList<Word>();
  private ArrayList<Definition> mDefinitions;
  private String mWord;
  private int mId;

  public Word(String word){
    mWord = word;
    words.add(this);
    mId = words.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getWord(){
    return mWord;
  }

  public static ArrayList<Word> all(){
    return words;
  }

  public int getId(){
    return mId;
  }

  public ArrayList<Definition> getAllDefinitions(){
    return mDefinitions;
  }

  public void addDefinition(Definition definition){
    mDefinitions.add(definition);
  }

  public static Word find(int id){
    try {
      return words.get(id - 1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }

  public static void clear(){
    words.clear();
  }
}
