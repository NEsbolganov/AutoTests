import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
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

    @Test
    void findElementByHoverMethod(){
        open("https://github.com/");

//        $(".list-style-none").$(byText("Solutions")).click();
        $(".list-style-none").$(byText("Solutions")).hover();

        $("[aria-labelledby=solutions-for-heading]").$(byText("Enterprise")).click();

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
    }

    @Test
    void testDragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        sleep(5000);

        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        $("#column-a").shouldHave(text("B"));

        $("#column-b").shouldHave(text("A"));
    }
}
