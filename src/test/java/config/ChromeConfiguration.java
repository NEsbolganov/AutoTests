package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeConfiguration {
    static {
        ChromeOptions opt = new ChromeOptions();
        opt.setPageLoadStrategy(PageLoadStrategy.EAGER);
        opt.setPageLoadTimeout(Duration.ofSeconds(60));
        Configuration.browserSize = "1920x1080";
    }
}
