package Tests;

import objects.Main;
import objects.Modal;
import driver.Chrome;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Text {
    private Chrome driver;
    private Main mainPage;

    @Before
    public void setup() {
        driver = new Chrome();
        mainPage = new Main(driver.getWebDriver());
        mainPage.acceptCookie();
    }

    @After
    public void quit() {
        Chrome.teardown();
    }

    @Test
    public void сheckTopUpBlockName() {
        String expectedResult = "Онлайн пополнение\n" +
                "без комиссии";
        Assert.assertEquals(expectedResult, mainPage.getName());
    }
}