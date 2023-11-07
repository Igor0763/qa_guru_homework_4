import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import com.codeborne.selenide.selector.WithText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://github.com";

    }

    @Test
    void selenidGithubTest() {
//     Откройте страницу Selenide в Github
        open("/selenide/selenide");

//     Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

//     Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $(".gh-header-title").shouldHave(text("SoftAssertions"));


//     Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5*/
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }

}
