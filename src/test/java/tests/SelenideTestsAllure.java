package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ChromeConfiguration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideTestsAllure extends ChromeConfiguration{

    private static final String searchWord = "eroshenkoam/allure-example";
    private static final String issueTabText = "#80";

    @Test
    void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();

        step("Нажимаем на кнопку поиска и вводим в строку поиска текст "+searchWord, ()->{
            $("[data-target='qbsearch-input.inputButton']").click();
            $("#query-builder-test").sendKeys(searchWord);
            $("#query-builder-test").submit();
        });

        step("В результатах смотрим репозиторий в названии которого есть "+searchWord,()->{
            $(linkText("eroshenkoam/allure-example")).click();
        });

        step("Переходим по вкладке Issues и ищем запись содержащую текст "+issueTabText, ()->{
            $("#issues-tab").click();
            $(withText(issueTabText)).should(Condition.exist);
        });


    }

    @Test
    void mainPageTakeScreenshot(){
        AttachmentTests attachmentTests = new AttachmentTests();

        attachmentTests.openMainPage();
        attachmentTests.takeScreenshot();

    }
}
