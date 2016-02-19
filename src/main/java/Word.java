import java.util.*;
import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> words = new ArrayList<Word>();
  private String mWord;
  private int mId;

  public Word(String word){
    mWord = word;
    words.add(this);
    mId = words.size();
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

  public static Word find(int id){
    try {
      return words.get(id - 1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }
  
}
