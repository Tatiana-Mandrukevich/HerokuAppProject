package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

@Test
public class NotificationMessages {
    //1. Open browser, site http://the-internet.herokuapp.com/notification_message_rendered
    //2. Click on the link "Click here"
    //3. Wait for the notification to appear
    //4. Check that the text matches expectations

    public void notificationMessagesTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");

        driver.findElement(By.linkText("Click here")).click();

        WebElement notificationMessages = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("flash-messages"))));

        try {
            while (true) {
                try {
                    if (driver.findElement(By.xpath("//div[contains(text(), 'Action unsuccesful, please try again')]"))
                            .getText().contains("Action unsuccesful, please try again")) {
                        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Action unsuccesful, please try again')]"))
                                .getText().contains("Action unsuccesful, please try again"));
                        driver.findElement(By.linkText("Click here")).click();
                    } else {
                        break;
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Сообщение Action unsuccesful, please try again не отображается, продолжаем тест.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Action successful')]"));
        Assert.assertTrue(successMessage.getText().contains("Action successful"));

        driver.quit();
    }
}
