import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("User Dictionary");
  }

  @Test
  public void wordIsCreated() {
    goTo("http://localhost:4567/");
    fill("#word").with("Internet");
    submit("#create");
    assertThat(pageSource()).contains("Success!");
  }

  @Test
  public void wordIsDisplayed(){
    goTo("http://localhost:4567/");
    fill("#word").with("Internet");
    submit("#create");
    click("a", withText("Go back"));
    fill("#word").with("Aardvark");
    submit("#create");
    click("a", withText("Go back"));
    assertThat(pageSource()).contains("Internet");
    assertThat(pageSource()).contains("Aardvark");
  }
}
