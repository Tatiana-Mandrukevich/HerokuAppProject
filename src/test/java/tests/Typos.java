package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Typos {
    //1. Open browser, site http://the-internet.herokuapp.com/typos
    //2. Check paragraph for spelling

    public void typosTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/typos");

        String expectedResult = "This example demonstrates a typo being introduced. It does it randomly on each page load.";
        String actualResult = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actualResult, expectedResult);

        String expectedResult2 = "Sometimes you'll see a typo, other times you won't.";
        String actualResult2 = driver.findElement(By.xpath("//*/p[2]")).getText();
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }
}
