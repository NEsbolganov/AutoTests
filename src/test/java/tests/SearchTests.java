package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchTests {

    @Test
    void successfulSearchTest(){
        Configuration.holdBrowserOpen = true;

        // Open the Google main page
         Selenide.open("https://www.google.com/");

         // Input "Selenide" value in searching field
         $("[name=q]").setValue("Selenide").pressEnter();

         // Checking if selenide.org is in the result list
        $("[id=search]").shouldHave(text("selenide.org"));

    }

    @Test
    void successfulLoginTest(){
        Configuration.holdBrowserOpen = true;

        //Открыть форму авторизации
        Selenide.open("https://school.qa.guru/cms/system/login?required=true");

        $("[name=email]").setValue("ryolkin90@gmail.com");

        $("[name=password]").setValue("Ryolkin90!");

        $(".btn-success").click();

//        Selenide.open("https://qa.guru/");
//
//        $("[class=tn-atom]").click();

    }
}
