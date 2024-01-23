package components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String month, String day, String year){
        $(".react-datepicker__input-container").click();

        $(".react-datepicker__year-select").$(byText(year)).click();

        $(".react-datepicker__month-select").$(byText(month)).click();

        $(".react-datepicker__month").$(byText(day)).click();

    }
}
