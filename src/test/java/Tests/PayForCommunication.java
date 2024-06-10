package Tests;

import objects.Main;
import objects.Modal;
import driver.Chrome;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PayForCommunication {
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
    public void checkPayForCommunicationService() throws InterruptedException {
        boolean expectedResult = true;
        mainPage.enterDataForPay();
        Assert.assertEquals(expectedResult, modalPage.checkDataForCommunicationPay());
    }
}