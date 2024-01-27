package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.restassured.specification.Argument;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Enums.Locale;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JmartMainPageTests {

    public static void main(String[] args) {
        Locale locale = Locale.KK;
        System.out.println(locale.getValue());
    }
    
    @BeforeAll
    static void beforeAll() {
//        Configuration.baseUrl = "https://jmart.kz/";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    static Stream<Arguments>changeLocaleOnJmart(){
        return Stream.of(
                Arguments.of(Locale.RU, List.of("Язык","Избранное","Заказы", "Корзина") ),
                Arguments.of(Locale.KK, List.of("Язык","Таңдаулы","Тапсырыстар", "Себет") )
        );
    }

    @Disabled
    @MethodSource
    @ParameterizedTest(name = "Для локали {0} на сайте https://jmart.kz/ должны отображаться список кнопок {1}")
    @DisplayName("Тест на смену локали на главной странице Jmart")
    @Test
    public void changeLocaleOnJmart(Locale locale, List<String> values){
        open("https://jmart.kz/");
//        Короче при первом заходе оно выбирает город Алматы, но уже во второй итерации ее нет из-за кеша
        $("#styleScroll").$(byText("Алматы")).click();
        $("[data-testid=innerDiv]").click();
        $(".StyledBox--1sqduml").$(byText(locale.getValue())).click();
        $$(".eltZek").filter(visible).shouldHave(texts(values));
    }

    @Test
    public void changeLocaleOnJmartDebug(){
        open("https://jmart.kz/");
        $("#styleScroll").$(byText("Алматы")).click();
        $("[data-testid=innerDiv]").click();
        $(".StyledBox--1sqduml").$(byText("Қазақша")).click();
        $$(".eltZek").filter(visible).shouldHave(texts("Язык","Таңдаулы","Тапсырыстар", "Себет"));
    }
    @Test
    public void changeLocaleOnKk(){
        open("https://jmart.kz/");
        $("#styleScroll").$(byText("Алматы")).click();
        $("[data-testid=innerDiv]").click();
        $(".StyledBox--1sqduml").$(byText("Қазақша")).click();
        $$(".eltZek").shouldHave(texts("Язык","Таңдаулы","Тапсырыстар", "Себет"));
    }
}
