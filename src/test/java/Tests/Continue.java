package Tests;
import objects.Main;
import driver.Chrome;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Continue {
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
    public void сheckButtonContinue() throws InterruptedException {
        boolean expectedResult = true;
        mainPage.enterDataForPay();
        Assert.assertEquals(expectedResult, mainPage.isWindowForPayPresent());
    }
}