import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {


    @Test
    void successfulSearchTest(){
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org/"));
    }


//    @Test
//    void shouldFindSelenideRepositoryAtFirstPlace(){
//
//        //Open github
//        open("https://github.com/");
//
//        $("search-input").click();
//
//        $("query-builder.styledInputContent").setValue("selenide").pressEnter();
//
//        sleep(5000);
//
//    }
}
