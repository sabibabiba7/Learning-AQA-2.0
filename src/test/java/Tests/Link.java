package Tests;

import objects.Main;
import driver.Chrome;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Link {
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
    public void сheckLinkMoreDetails() {
        String expectedResult = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assert.assertEquals(expectedResult, mainPage.getLink());
    }
}
