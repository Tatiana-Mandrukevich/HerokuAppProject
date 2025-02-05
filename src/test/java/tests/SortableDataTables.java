package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

@Test
public class SortableDataTables {
    //1. Open browser, site http://the-internet.herokuapp.com/tables
    //2. Check the contents of several (3-5) table cells

    public void checkTableUsers() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");

        List<String> expectedResult = List.of(new String[] {"Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com"});

        List<String> actualResult = new LinkedList<>();
        for (int i = 1; i < expectedResult.size() + 1; i++) {
            String element = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[" + i + "]")).getText();
            actualResult.add(element);
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
