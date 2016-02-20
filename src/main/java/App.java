import java.util.ArrayList;
import java.util.Map;
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
      model.put("words", Word.all());

      model.put("template", "templates/index.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    post("/update", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("word");
      Word newWord = new Word(word);
      model.put("words", Word.all());
      model.put("words", Word.all());
      model.put("template", "templates/success.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    get("/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/word-info.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/:id/new-def", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      ArrayList<Definition> definitions = word.getAllDefinitions();
      model.put("word", word);
      model.put("definitions", definitions);
      model.put("template", "templates/new-def.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/updated", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      ArrayList<Definition> definitions = request.session().attribute("definitions");
//Create if null
      if (definitions == null){
        definitions = new ArrayList<Definition>();
        request.session().attribute("definitions", definitions);
      }
//Put into array
      String definition = request.queryParams("definition");
      Definition newDef = new Definition(definition);
      definitions.add(newDef);
//Put on page
      model.put("word", word);
      model.put("definitions", definitions);
      model.put("template", "templates/success.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

  }
}
