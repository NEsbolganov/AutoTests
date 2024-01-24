package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.RegistrationForm;
import utils.RandomUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;
import static pageObjects.RegistrationForm.*;

public class PracticeFormTests extends TestBase{
//    https://demoqa.com/automation-practice-form

    RegistrationForm registrationForm = new RegistrationForm();
    RandomUtils randomUtils = new RandomUtils();
    @BeforeEach
    void prepareTestData(){
        userName = randomUtils.getRandomString(9);
        lastName = randomUtils.getRandomString(9);
        userEmail = randomUtils.getRandomEmail(12);
    }

    @Test
    void TestInputValues(){
        registrationForm.openPage("https://demoqa.com/automation-practice-form");
        //Спросить у Рустама что оно делает
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        registrationForm.setValue("[id=firstName]",userName);

        registrationForm.setValue("[id=lastName]",lastName);

        registrationForm.setValue("[id = userEmail]", userEmail);

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
                text(userName + " " + lastName),
                text(userEmail),
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
