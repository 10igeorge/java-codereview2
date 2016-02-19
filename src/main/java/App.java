import java.util.ArrayList;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", request.session().attribute("words"));

      model.put("template", "templates/index.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      ArrayList<Word> words = request.session().attribute("words");

      if (words == null){
        words = new ArrayList<Word>();
        request.session().attribute("words", words);
      }

      String word = request.queryParams("word");
      Word newWord = new Word(word);

      words.add(newWord);

      model.put("word", word);
      model.put("template", "templates/success.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());
  }
}
