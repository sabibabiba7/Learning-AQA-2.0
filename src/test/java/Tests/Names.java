package Tests;

import objects.Main;
import driver.Chrome;
import objects.Modal;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class Names {
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
    public void checkFieldNamesCardPay() throws InterruptedException {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Номер карты");
        expectedResult.add("Срок действия");
        expectedResult.add("CVC");
        expectedResult.add("Имя держателя (как на карте)");
        mainPage.enterDataForPay();
        Assert.assertEquals(expectedResult, modalPage.getFieldNamePayCard());
    }
}
