package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    public WebDriver createDriver(){
        switch (config.getBrowser()){
            case Chrome -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case Firefox -> {
                WebDriverManager.firefoxdriver().setup();
                return new ChromeDriver();
            }
            default -> {
                throw new RuntimeException("No such driver");
            }
        }
    }
}
