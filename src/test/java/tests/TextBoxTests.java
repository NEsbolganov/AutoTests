package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void fillFormTest(){


//        https://demoqa.com/text-box

//        String[] inputValues = inputter();

        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue("Nartay");

        $("[id=userEmail]").setValue("nyesbolganov@jmart.kz");

        $("[id=currentAddress]").setValue("Maykopskaya 13");

        $("[id=permanentAddress]").setValue("Al-farabi 36");

        $(".btn-primary").click();

        $("#output").shouldHave(text("Nartay"), text("nyesbolganov@jmart.kz"),
                text("Maykopskaya 13"), text("Al-farabi 36"));

    }


}
