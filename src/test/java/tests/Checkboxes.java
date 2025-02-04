package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Checkboxes {
    //1. Open browser, site http://the-internet.herokuapp.com/checkboxes
    //2. Check that the first checkbox is unchecked
    //3. Check the first checkbox
    //4. Check that the first checkbox is checked
    //5. Check that the second checkbox is checked
    //6. Uncheck the second checkbox
    //7. Check that the second checkbox is unchecked

    public void firstCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement firstCheckbox = driver.findElement(By.cssSelector("[type=checkbox]"));

        boolean expectedResult = false;
        boolean actualResult = firstCheckbox.isSelected();
        Assert.assertEquals(actualResult, expectedResult);

        firstCheckbox.click();

        boolean expectedResult2 = true;
        boolean actualResult2 = firstCheckbox.isSelected();
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    public void secondCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@type=\"checkbox\"][2]"));

        boolean expectedResult = true;
        boolean actualResult = secondCheckbox.isSelected();
        Assert.assertEquals(actualResult, expectedResult);

        secondCheckbox.click();

        boolean expectedResult2 = false;
        boolean actualResult2 = secondCheckbox.isSelected();
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }
}
