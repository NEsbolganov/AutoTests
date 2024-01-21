import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositoryTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop(){
        //Авто тест для поиска и перехода по репозиторию
        open("https://github.com/");

        $(".search-input").click();

        $("[id=query-builder-test]").setValue("selenide").pressEnter();

        $$("[data-testid=results-list]").first().$(".search-match").click();

        $("[itemprop=name]").shouldHave(text("selenide"));
    }

    @Test
    void shouldHaveJunit5Assertions(){
        open("https://github.com/");

        $(".search-input").click();

        $("[id=query-builder-test]").setValue("selenide").pressEnter();

        $$("[data-testid=results-list]").first().$(".search-match").click();

        $("[itemprop=name]").shouldHave(text("selenide"));

        //Предыдущие 5 скриптов перешли в репозиторий
/*
- Перейдите в раздел Wiki проекта
- Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
- Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
 */
        $("[id=wiki-tab]").click();

        $("[id=wiki-content]").$(byText("Soft assertions")).click();

        $(".markdown-body").shouldHave(text("JUnit5"));
    }
}
