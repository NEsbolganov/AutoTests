package tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.RegistrationForm;
import utils.RandomUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static pageObjects.RegistrationForm.*;

public class PracticeFormTestsWithFaker extends TestBase{
//    https://demoqa.com/automation-practice-form

    RegistrationForm registrationForm = new RegistrationForm();
//    @BeforeEach
//    void prepareTestData(){
//        userName = faker.name().firstName();
//        lastName = faker.name().lastName();
//        userEmail = faker.internet().emailAddress();
//    }

    @Test
    void TestInputValues(){
        Faker faker = new Faker();

        userName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        currentAddress = faker.address().fullAddress();

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

        registrationForm.setValue("#currentAddress", currentAddress);

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
                text(currentAddress),
                text("Uttar Pradesh Lucknow"));
    }
}
