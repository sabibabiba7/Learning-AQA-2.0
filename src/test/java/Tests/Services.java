package Tests;

import objects.Main;
import driver.Chrome;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Services {
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
    public void checkListOfServices() {
        String[] expectedResult = new String[]{"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        Assert.assertArrayEquals(expectedResult, mainPage.getListOfServices());
    }
}