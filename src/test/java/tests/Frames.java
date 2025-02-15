package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class Frames {
    //1. Open browser, site https://the-internet.herokuapp.com/frames
    //2. Open iFrame
    //3. Check that the text inside the paragraph is "Your content goes here."

    public static final By IFRAME_LINK = By.linkText("iFrame");
    public static final By FRAME = By.xpath("//iframe");
    public static final String EXPECTED_TEXT_INSIDE_PARAGRAPH = "Your content goes here.";
    public static final By TEXT_INSIDE_PARAGRAPH = By.xpath("//p");

    public void checkFrame() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/frames");

        driver.findElement(IFRAME_LINK).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FRAME));

        Assert.assertEquals(driver.findElement(TEXT_INSIDE_PARAGRAPH).getText(), EXPECTED_TEXT_INSIDE_PARAGRAPH);

        driver.quit();
    }
}
