import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class PracticeFormTests {
//    https://demoqa.com/automation-practice-form

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void TestInputValues(){
        open("https://demoqa.com/automation-practice-form");
        //Спросить у Рустама что оно делает
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("[id=firstName]").setValue("First Input");

        $("[id=lastName]").setValue("Last Input");

        $("[id = userEmail]").setValue("dev@mail.ru");

        $("#genterWrapper").$(byText("Female")).click();

        $("[id=userNumber]").setValue("1234567890");

        $(".react-datepicker__input-container").click();

        $(".react-datepicker__year-select").$(byText("2003")).click();

        $(".react-datepicker__month-select").$(byText("November")).click();

        $(".react-datepicker__month").$(byText("7")).click();

        $("[id=subjectsInput]").setValue("Biol").pressEnter();

        $("#hobbiesWrapper").parent().$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("pictures/picture.JPG");

        $("#currentAddress").setValue("address");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();

        $("[id=submit]").click();

        $(".modal-body").shouldHave(
                text("First Input"),
                text("Last Input"),
                text("dev@mail.ru"),
                text("Female"),
                text("1234567890"),
                text("07 November,2003"),
                text("Biology"),
                text("Reading"),
                text("picture.JPG"),
                text("address"),
                text("Uttar Pradesh Lucknow"));
    }
}
