package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step
    public void openMainPage(){
        open("https://github.com/");
    }
}
