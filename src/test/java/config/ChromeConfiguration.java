package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeConfiguration {
    public static void main(String[] args) {
        // Укажите путь к исполняемому файлу Chrome
        String chromePath = "путь/к/вашему/chrome.exe";

        // Укажите путь к исполняемому файлу chromedriver.exe
        String chromedriverPath = "путь/к/chromedriver.exe";

        // Настройте путь к исполняемому файлу Chrome
        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        // Настройте опции для Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(chromePath);

        // Инициализируйте экземпляр ChromeDriver с настроенными опциями
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Теперь вы можете использовать объект 'driver' для открытия веб-страниц и выполнения других действий.

        // Пример: открытие страницы Google
        driver.get("https://www.google.com");

        // Пример: закрытие браузера
        driver.quit();
    }
}
