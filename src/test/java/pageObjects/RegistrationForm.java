package pageObjects;

import components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    private static final CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationForm() {
    }

    public void openPage(String URL){
        open(URL);
    }

    public void setValue(String field, String value){
        $(field).setValue(value);
    }

    public void setGender(String field, String genderText){
        $(field).$(byText(genderText)).click();
    }

    public void setSubject(String field, String subjectShortcut){
        $(field).setValue(subjectShortcut).pressEnter();
    }

    public void setFile(String field, String filePATH){
        $(field).uploadFromClasspath(filePATH);
    }

    public void setStateAndCity(String type, String field, String value){
        $(type).click();
        $(field).$(byText(value)).click();
    }

    public void setHobby(String field, String hobby){
        $(field).parent().$(byText(hobby)).click();
    }

    public void setDate(String month, String date, String year){
        calendarComponent.setDate(month, date, year);
    }
}
