package MTS;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.After
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MtsTest {
    private WebDriver driver;
    private TestCase Assert;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
    }
    @Test
    public void testOnlineRecharge() {
        WebElement title = driver.findElement(By.name("Онлайн пополнение без комиссии"));
        Assert.assertEquals("Онлайн пополнение без комиссии", title.getText());

        WebElement paymentLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        Assert.assertTrue(paymentLogo.isDisplayed());

        WebElement link = driver.findElement(By.cssSelector("<a href="/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/">Подробнее о сервисе</a>));
        link.click();
        Assert.assertEquals("ожидаемый_URL", driver.getCurrentUrl());

        driver.navigate().back();
        WebElement field = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        field.sendKeys("297777777");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        button.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

