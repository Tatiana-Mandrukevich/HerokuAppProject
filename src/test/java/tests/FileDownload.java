package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Test
public class FileDownload {
    //1. Open browser, site https://the-internet.herokuapp.com/download
    //2. Download file
    //3. Check that the file is on the file system

    public static final String PATH_TO_DOWNLOAD_DIRECTORY = "src/test/resources";
    public static final By FILE_LINK = By.linkText("logo.png");
    public static final String FILE_NAME = "logo.png";

    public void checkDownload() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        Map<String, Object> prefs = new HashMap<>();
        String absolutePath = Paths.get(PATH_TO_DOWNLOAD_DIRECTORY).toAbsolutePath().toString();
        prefs.put("download.default_directory", absolutePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(FILE_LINK).click();

        TimeUnit.SECONDS.sleep(5);

        File downloadedFile = new File(absolutePath + "/" + FILE_NAME);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until((ExpectedCondition<Boolean>) webDriver -> downloadedFile.exists());

        Assert.assertTrue(downloadedFile.exists(), "The file is not on the file system");

        downloadedFile.delete();

        driver.quit();
    }
}
