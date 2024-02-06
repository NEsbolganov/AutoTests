package qa.guru_owner;

import config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    WebDriver driver;


    @BeforeEach
    public void startDriver(){
        driver = new WebDriverProvider().get();
    }
    @Test
    public void testGitHub(){
        String title = driver.getTitle();
        assertEquals(title,"GitHub: Let’s build from here · GitHub");
    }

    @AfterEach
    public void stopDriver(){
        driver.quit();
    }

}
