import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class GithubEnterpriseTest {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://github.com/";
        Configuration.browserSize = "1900x1080";
    }

    @Test()
    void checkTitleEnterprisePage() {
        open(baseUrl);
        $(byTagAndText("button", "Solutions")).hover();
        $("#solutions-for-heading").parent().$("ul li").click();
        $("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered developer platform."));
        sleep(5000);
    }


}
