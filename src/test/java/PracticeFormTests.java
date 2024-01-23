import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObjects.RegistrationForm;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class PracticeFormTests {
//    https://demoqa.com/automation-practice-form

    RegistrationForm registrationForm = new RegistrationForm();
    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void TestInputValues(){
        registrationForm.openPage("https://demoqa.com/automation-practice-form");
        //Спросить у Рустама что оно делает
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        registrationForm.setValue("[id=firstName]","Nartay");

        registrationForm.setValue("[id=lastName]","Esbolganov");

        registrationForm.setValue("[id = userEmail]", "nyesbolganov@jmart.kz");

        registrationForm.setGender("#genterWrapper", "Female");

        registrationForm.setValue("[id=userNumber]", "8707250760");

        registrationForm.setDate("November", "7", "2003");

        registrationForm.setSubject("[id=subjectsInput]", "Biol");

        registrationForm.setHobby("#hobbiesWrapper","Reading");

        registrationForm.setFile("#uploadPicture", "pictures/picture.JPG");

        registrationForm.setValue("#currentAddress", "address");

        registrationForm.setStateAndCity("#state", "#stateCity-wrapper", "Uttar Pradesh");

        registrationForm.setStateAndCity("#city","#stateCity-wrapper", "Lucknow");

        $("#submit").click();

        $(".modal-body").shouldHave(
                text("Nartay Esbolganov"),
                text("nyesbolganov@jmart.kz"),
                text("Female"),
                text("8707250760"),
                text("07 November,2003"),
                text("Biology"),
                text("Reading"),
                text("picture.JPG"),
                text("address"),
                text("Uttar Pradesh Lucknow"));
    }
}
