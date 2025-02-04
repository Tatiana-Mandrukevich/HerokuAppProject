package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Hovers {
    //1. Open browser, site http://the-internet.herokuapp.com/hovers
    //2. Hover over profile
    //3. Check name
    //4. Click on the link
    //5. Check that there is no 404 error (в чате решили, что можно заменить на Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);)
    //6. Repeat for each profile

    public void hoversTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/hovers");

        //first profile:
        WebElement profile1 = driver.findElement(By.xpath("//*[@alt=\"User Avatar\"]"));
        Actions actions1 = new Actions(driver).moveToElement(profile1);
        actions1.perform();

        String expectedResult = "name: user1";
        String actualResult = driver.findElement(By.tagName("h5")).getText();
        Assert.assertEquals(actualResult, expectedResult);

        driver.findElement(By.linkText("View profile")).click();

        String expectedUrl1 = "https://the-internet.herokuapp.com/users/1";
        String actualUrl1 = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl1, expectedUrl1);
//        System.out.println("Текущий URL профиля 1: " + driver.getCurrentUrl());

        driver.navigate().back();
//        System.out.println("Текущий URL после возврата: " + driver.getCurrentUrl());

        //second profile:
        WebElement profile2 = driver.findElement(By.xpath("(//*[@alt=\"User Avatar\"])[2]"));
        Actions actions2 = new Actions(driver).moveToElement(profile2);
        actions2.perform();

        String expectedResult2 = "name: user2";
        String actualResult2 = driver.findElement(By.xpath("(//*[@id='content']//h5)[2]")).getText();
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.findElement(By.linkText("View profile")).click();

        String expectedUrl2 = "https://the-internet.herokuapp.com/users/2";
        String actualUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl2, expectedUrl2);
//        System.out.println("Текущий URL профиля 2: " + driver.getCurrentUrl());

        driver.navigate().back();
//        System.out.println("Текущий URL после 2 возврата: " + driver.getCurrentUrl());

        //third profile
        WebElement profile3 = driver.findElement(By.xpath("(//*[@alt=\"User Avatar\"])[3]"));
        Actions actions3 = new Actions(driver).moveToElement(profile3);
        actions3.perform();

        String expectedResult3 = "name: user3";
        String actualResult3 = driver.findElement(By.xpath("(//*[@id='content']//h5)[3]")).getText();
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.findElement(By.linkText("View profile")).click();

        String expectedUrl3 = "https://the-internet.herokuapp.com/users/3";
        String actualUrl3 = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl3, expectedUrl3);
//        System.out.println("Текущий URL профиля 3: " + driver.getCurrentUrl());

        driver.navigate().back();
//        System.out.println("Текущий URL после 3 возврата: " + driver.getCurrentUrl());

        driver.quit();
    }
}
