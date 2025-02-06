package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Inputs {
    public  void herokuAppTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement inputField = driver.findElement(By.xpath("//*[@type=\"number\"]"));
        inputField.sendKeys("20");
        String actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, "20");

        inputField.sendKeys(Keys.ARROW_UP);
        String actualText2 = inputField.getAttribute("value");
        Assert.assertEquals(actualText2, "21");

        driver.quit();
    }
}
