import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Point;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class SelenideActionTest {

    @BeforeAll
    static void beforeAll() {
        baseUrl = " https://the-internet.herokuapp.com";
        Configuration.browserSize = "1900x1080";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

    @Test()
    void moveElementsBySelenideByDragAndDropTo() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-b").dragAndDrop(to($("#column-a")));
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }

    @Test()
    void moveElementsBySelenideActions() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        Point B = $("#column-b").getLocation();
        int x = B.getX();
        int y = B.getY();

        actions().moveToElement($("#column-a")).clickAndHold().moveToLocation(x, y).release().perform();
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }
}

