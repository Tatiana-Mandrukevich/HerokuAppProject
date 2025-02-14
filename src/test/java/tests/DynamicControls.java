package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

@Test
public class DynamicControls {
    //1. Open browser, site https://the-internet.herokuapp.com/dynamic_controls
    //2. Click the Remove button next to the checkbox
    //3. Wait for the message "It's gone"
    //4. Check that there is no checkbox
    //5. Find the input
    //6. Check that it is disabled
    //7. Click the button
    //8. Wait for the message "It's enabled!"
    //9. Check that the input is enabled

    public static final By REMOVE_BUTTON = By.xpath("//button[contains(text(), 'Remove')]");
    public static final By MESSAGE_AFTER_CHECKBOX_REMOVE_OR_ADD = By.xpath("//*[@id = 'checkbox-example']//*[@id = 'message']");
    public static final String EXPECTED_TEXT_AFTER_CHECKBOX_REMOVE = "It's gone!";
    public static final By CHECKBOX = By.id("checkbox");
    public static final By INPUT_FIELD = By.xpath("//input");
    public static final By ENABLE_BUTTON = By.xpath("//button[contains(text(), 'Enable')]");
    public static final By MESSAGE_AFTER_INPUT_ENABLE_OR_DISABLE = By.xpath("//*[@id = 'input-example']//*[@id = 'message']");
    public static final String EXPECTED_TEXT_AFTER_ENABLE_INPUT = "It's enabled!";

    public void checkDynamicControls() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(REMOVE_BUTTON).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBe(MESSAGE_AFTER_CHECKBOX_REMOVE_OR_ADD, EXPECTED_TEXT_AFTER_CHECKBOX_REMOVE));

        List<WebElement> checkboxes = driver.findElements(CHECKBOX);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkboxes.isEmpty(), "There is checkbox");

        softAssert.assertTrue(!driver.findElement(INPUT_FIELD).isEnabled(), "The field is not disabled");

        driver.findElement(ENABLE_BUTTON).click();

        wait.until(ExpectedConditions.textToBe(MESSAGE_AFTER_INPUT_ENABLE_OR_DISABLE, EXPECTED_TEXT_AFTER_ENABLE_INPUT));

        softAssert.assertTrue(driver.findElement(INPUT_FIELD).isEnabled(), "The field is not enabled");

        softAssert.assertAll();

        driver.quit();
    }
}
