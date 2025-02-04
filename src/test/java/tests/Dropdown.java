package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class Dropdown {
    //1. Open browser, site http://the-internet.herokuapp.com/dropdown
    //2. Check that there are elements in the dropdown
    //3. Select the first element
    //4. Check that the first element is selected
    //5. Select the second element
    //6. Check that the second element is selected

    public void dropdownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");

        List<WebElement> listDropdownElements = driver.findElements(By.id("dropdown"));

        boolean expectedResult = false;
        boolean actualResult = listDropdownElements.isEmpty();
        Assert.assertEquals(actualResult, expectedResult);

        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.xpath("//*[@value=\"1\"]")).click();

        String expectedResult2 = "Option 1";
        String actualResult2 = driver.findElement(By.xpath("//*[@value=\"1\"]")).getText();
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.xpath("//*[@value=\"2\"]")).click();

        String expectedResult3 = "Option 2";
        String actualResult3 = driver.findElement(By.xpath("//*[@value=\"2\"]")).getText();
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }
}
