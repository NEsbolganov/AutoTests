package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LeetCodeTests {

    @BeforeAll
    public static void beforeAll(){
//        String chromeDriver = "/Users/esbolganovnartai/Desktop/chromedriver";
//        System.setProperty("webdriver.chrome.driver", chromeDriver);
//
//        ChromeOptions options = new ChromeOptions();
//        String dir= "/Users/esbolganovnartai/Library/Application Support/Google/Chrome";
//        options.setBinary(dir);
//        options.addArguments("user-data-dir="+dir);
//        ChromeDriver driver = new ChromeDriver(options);
//        driver.get("https://www.google.com/");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-web-security");
//        WebDriver driver = new ChromeDriver(options);
    }

    @Test
    void problemAcceptanceRateTest(){
        open("https://leetcode.com/");
        $(".nav-menu").$(byText("Sign in")).click();
        $("[data-icon=google-c]").click();
        $("[type=email]").setValue("nartai393@gmail.com").pressEnter();
    }

    @Test
    @Disabled
    void dailyProblemAcceptanceRateTest(){
        open("https://leetcode.com/problemset/");
        $("").$(byText("2")).click();
    }

    @Test
    @Disabled
    void leetcodeRedeemElementCost(){
        open("https://leetcode.com/problemset/");
        $(byClassName("truncate")).$(byText("1. Two Sum")).click();
    }

    @Test
    void difficultyProblemsCount(){
        open("https://leetcode.com/problemset/");
        List<WebElement> elements = webdriver().object().findElements(By.id("headlessui-menu-button-:r2:"));
        WebElement innerElement = null;
        for(WebElement element : elements){
            innerElement = element.findElement((By) $(byText("Difficulty")));
        }
        innerElement.click();
//        $("[type=button]").$(byText("Difficulty")).click();
    }

}
