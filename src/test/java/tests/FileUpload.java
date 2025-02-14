package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.Duration;

@Test
public class FileUpload {
    //1. Open browser, site https://the-internet.herokuapp.com/upload
    //2. Upload file
    //3. Check that the file name on the page matches the name of the uploaded file

    public static final String PATH_TO_FILE_TO_UPLOAD = "src/test/resources/file_to_upload.pages";
    public static final String NAME_TO_FILE_TO_UPLOAD = "file_to_upload.pages";
    public static final By INPUT_FILE_BUTTON = By.xpath("//input[@type='file']");
    public static final By UPLOAD_BUTTON = By.id("file-submit");
    public static final By UPLOAD_RESULT_MESSAGE = By.xpath("//h3");
    public static final String SUCCESSFUL_UPLOAD_RESULT_MESSAGE = "File Uploaded!";
    public static final By UPLOADED_FILE = By.id("uploaded-files");

    public void checkUploadFile() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        String absolutePath = Paths.get(PATH_TO_FILE_TO_UPLOAD).toAbsolutePath().toString();
        driver.findElement(INPUT_FILE_BUTTON).sendKeys(absolutePath);
        driver.findElement(UPLOAD_BUTTON).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBe(UPLOAD_RESULT_MESSAGE, SUCCESSFUL_UPLOAD_RESULT_MESSAGE));

        Assert.assertEquals(driver.findElement(UPLOADED_FILE).getText().replaceAll("\\s", ""), NAME_TO_FILE_TO_UPLOAD);

        driver.quit();
    }
}
