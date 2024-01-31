package parsing;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import dto.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FileParsingTests {

//    static {
//        Configuration.proxyEnabled = true;
//        Configuration.fileDownload = FileDownloadMode.PROXY;
//    }

    private ClassLoader classLoader = FileParsingTests.class.getClassLoader();

    @BeforeAll()
    static void beforeAll(){
        ChromeOptions opt = new ChromeOptions();
        opt.setPageLoadStrategy(PageLoadStrategy.EAGER);
        opt.setPageLoadTimeout(Duration.ofSeconds(60));
    }

    @Test
    void pdfParsingTest() throws IOException {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File download = $("a[href*='junit-user-guide-5.10.1.pdf']").download();
        PDF pdf = new PDF(download);
        Assertions.assertEquals("Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein",pdf.author);
    }

    @Test
    void xlsParsingTest() throws IOException {
        open("https://excelvba.ru/programmes/Teachers");
        File download = $("a[href*='https://ExcelVBA.ru/sites/default/files/teachers.xls']").download();
        XLS xls = new XLS(download);
        Assertions.assertTrue(xls.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue().
                startsWith("1. Суммарное количество часов планируемое на штатную по всем разделам плана  должно"));
        System.out.println("");
    }

    @Test
    void csvParseTest() throws Exception{
        try(InputStream is = classLoader.getResourceAsStream("expectedFiles/data.csv");
            InputStreamReader isr = new InputStreamReader(is)){
            CSVReader csvReader = new CSVReader(isr);
            List<String[]> content = csvReader.readAll();
            Assertions.assertArrayEquals(new String[]{"tuchs","Junit"},content.get(1));
        }
    }

    @Test
    void fileEqualsTest() throws Exception{
        open("https://wsform.com/knowledgebase/sample-csv-files/");
        File csvToDownload = $("a[href*='https://cdn.wsform.com/wp-content/uploads/2020/06/industry.csv']").download();
        try (InputStream isExpected = classLoader.getResourceAsStream("expectedFiles/data.csv");
        InputStream downloaded = new FileInputStream(csvToDownload)){
            Assertions.assertEquals(new String(isExpected.readAllBytes()) ,new String(downloaded.readAllBytes()));
        }
    }

    @Test
    void zipTest() throws Exception{
        try(InputStream is = classLoader.getResourceAsStream("expectedFiles/industry.csv.zip");
            ZipInputStream zs = new ZipInputStream(is) ){
            ZipEntry entry;
            while((entry = zs.getNextEntry()) != null){
                Assertions.assertTrue(entry.getName().contains("industry.csv"));
            }
        }
    }

    @Test
    void jsonTest() throws Exception{
        Gson gson = new Gson();
        try(InputStream is = classLoader.getResourceAsStream("expectedFiles/data.json");
        InputStreamReader isr = new InputStreamReader(is)){
            Human humanFromJson = gson.fromJson(isr,Human.class);
//            JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);
            Assertions.assertTrue(humanFromJson.isClever);
            Assertions.assertEquals(20,humanFromJson.age);
        }
    }
}
