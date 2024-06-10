package Tests;

import objects.Main;
import driver.Chrome;
import objects.Modal;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Payment {
    private Chrome driver;
    private Main mainPage;
    private Modal modalPage;

    @Before
    public void setup() {
        driver = new Chrome();
        mainPage = new Main(driver.getWebDriver());
        modalPage = new Modal(driver.getWebDriver());
        mainPage.acceptCookie();
    }

    @After
    public void quit() {
        Chrome.teardown();
    }

    @Test
    public void checkIsPaymentSystemIconDisplayed() throws InterruptedException {
        boolean expectedResult1 = true;
        int expectedResult2 = 5;
        mainPage.enterDataForPay();
        Assert.assertEquals(expectedResult1, modalPage.isLogoDisplayed());
        Assert.assertEquals(expectedResult2, modalPage.getLogosCount());
    }
}