package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FileWorkTests {

    static {
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = FileDownloadMode.PROXY;
    }

    @Test
    void fileDownloadFromRepository() throws IOException {
        ChromeOptions opt = new ChromeOptions();
        opt.setPageLoadStrategy(PageLoadStrategy.EAGER);
        opt.setPageLoadTimeout(Duration.ofSeconds(60));
        //Configuration.holdBrowserOpen = true;
        open("https://github.com/qa-guru/niffler-st4/blob/master/README.md");
        File fileToDownload = $("[data-testid=download-raw-button]").download();
        try(InputStream is = new FileInputStream(fileToDownload)){
            byte[] bytes = is.readAllBytes();
            String fileAsString = new String(bytes, StandardCharsets.UTF_8);
            Assertions.assertTrue(fileAsString.contains("Технологии, использованные в Niffler"));
        }
        System.out.println("");
    }
}
