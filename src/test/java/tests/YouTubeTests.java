package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YouTubeTests {

    @Test
    void setantaSportsAssertCommentsCount(){
        Configuration.holdBrowserOpen =true;
        open("https://www.youtube.com/");
        $("#search-form").click();
        $("[name=search_query]").setValue("Setanta Sports Football").pressEnter();
        $("#channel-title").$(byText("Setanta Sports Football")).click();
        $("#tabsContainer").$(byText("Videos")).click();
        $("#video-title-link").$(byText("Бавария VS Унион Берлин - Обзор")).hover();
    }
}
