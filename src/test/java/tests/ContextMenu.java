package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class ContextMenu {
    //1. Open browser, site https://the-internet.herokuapp.com/context_menu
    //2. Right click on element
    //3. Check alert text
    //4. Close alert

    public static final By BOX = By.id("hot-spot");
    public static final String EXPECTED_ALERT_TEXT = "You selected a context menu";

    public void checkAlert() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(BOX)).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), EXPECTED_ALERT_TEXT);

        alert.accept();

        driver.quit();
    }
}
