package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HerokuAppTest {

    @Test
    public void herokuAppTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//неявное ожидание, т.е. 10 секунд ждем каждый элемент (по умолчанию 4 секунды)

        WebElement myElement = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("id"))));//явное ожидание, т.е.ждем элемент 10 секунд до появления какого-то элемента

        WebElement inputField = driver.findElement(By.xpath("//*[@type=\"number\"]"));
        inputField.sendKeys("20");
        String actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, "20");

        inputField.sendKeys(Keys.ARROW_UP);
        String actualText2 = inputField.getAttribute("value");
        Assert.assertEquals(actualText2, "21");

        driver.navigate().to("https://the-internet.herokuapp.com/inputs");
        driver.navigate().forward();
        driver.navigate().back();
        driver.close();
        driver.quit();
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.manage().window().setPosition(new Point(100, 100));
        Point position = driver.manage().window().getPosition();
        int x = position.getX();
        int y = position.getY();

        Cookie cookie = new Cookie("key", "value");
        driver.manage().addCookie(cookie);

        driver.manage().getCookies();
        driver.manage().getCookieNamed("name");

        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie cookie1 : allCookies) {
            System.out.println(String.format("%s -> %s", cookie1.getName(), cookie1.getValue()));
        }

        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("name");
        driver.manage().deleteCookie(cookie);

        String handle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        WebElement myElement2 = driver.findElement(By.name("frame"));
        driver.switchTo().frame(myElement2);

        driver.switchTo().defaultContent();
        driver.getCurrentUrl();
        driver.getPageSource();

        driver.findElement(By.id("id1"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@class=\"b-main-navigation__item\"]"));
        list.isEmpty();

        WebElement myElement3 = driver.findElement(By.name("name"));
        myElement3.click();
        myElement3.sendKeys("wfwf");
        myElement3.clear();
        String fontSize = myElement3.getCssValue("font-size");
        myElement3.getTagName();//div
        myElement3.getText();

        //href="http://..."
        myElement3.getAttribute("href");

        WebElement element = driver.findElement(By.xpath("//*[@class=\"b-top-navigation-age\"]"));
        element.getText();
        element.isDisplayed();//элемент отображается: да/нет
        boolean isElementDisplayed = element.isDisplayed();
        if(!isElementDisplayed) {

        }
        element.isEnabled();//'элемент задизейблен: да/нет
        element.isSelected();
        element.click();

        Select dropdown = new Select(driver.findElement(By.id("\"dropdown\"")));
        }

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            try {
                driver.get("https://the-internet.herokuapp.com/inputs");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.id("id")));
            } finally {
                driver.quit();
            }
        }
}
