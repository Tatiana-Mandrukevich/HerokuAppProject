package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElements {
    //1. Open browser, site http://the-internet.herokuapp.com/add_remove_elements/
    //2. Click "Add Element" button 2 times
    //3. Click "Delete" button
    //4. Check number of elements Delete

    @Test
    public void addRemoveElementsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//*[@onclick=\"addElement()\"]")).click();
        driver.findElement(By.xpath("//*[@onclick=\"addElement()\"]")).click();
        driver.findElement(By.xpath("//*[@onclick=\"deleteElement()\"]")).click();

        List<WebElement> listButtonDelete = driver.findElements(By.xpath("//*[@onclick=\"deleteElement()\"]"));
        int numberOfElementsDelete = listButtonDelete.size();

        Integer expectedResult = 1;
        Integer actualResult = numberOfElementsDelete;
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

}
