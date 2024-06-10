package Tests;

import objects.Main;
import driver.Chrome;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class Logo {
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
    public void checkLogoPaySystems() throws InterruptedException {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Visa");
        expectedResult.add("Verified By Visa");
        expectedResult.add("MasterCard");
        expectedResult.add("MasterCard Secure Code");
        expectedResult.add("Белкарт");
        expectedResult.add("МИР");
        Assert.assertEquals(expectedResult, mainPage.getPaymentLogosText());
    }
}