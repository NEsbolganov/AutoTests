package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YouToubeTests {

    @Test
    void setantaSportsAssertCommentsCount(){
        open("https://www.youtube.com/");
        $("#search-form").click();
        $("#search-form").setValue("Setanta Sports Football");
        $(".ytd-channel-name").$(byText("Setanta Sports Football")).click();
    }
}
