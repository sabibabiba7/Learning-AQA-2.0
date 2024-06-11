import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.assertEquals;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.RunWith;

@RunWith(AllureJunit4.class)
    public class Calculator {
        private AndroidDriver<MobileElement> driver;

        @Before
        public void setUp() throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Redmi Note 9 Pro");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appPackage", "com.google.android.calculator");
            capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver<>(url, capabilities);
        }

        @Test
        public void testCalculatorOperations() {
            performOperation("2", "plus", "2", "4");
            performOperation("5", "minus", "2", "3");
            performOperation("3", "multiply", "2", "6");
            performOperation("8", "divide", "2", "4");
        }

        private void performOperation(String operand1, String operator, String operand2, String expectedResult) {
            MobileElement el1 = driver.findElementById("com.google.android.calculator:id/digit_" + operand1);
            el1.click();
            MobileElement el2 = driver.findElementByAccessibilityId(operator);
            el2.click();
            MobileElement el3 = driver.findElementById("com.google.android.calculator:id/digit_" + operand2);
            el3.click();
            MobileElement el4 = driver.findElementByAccessibilityId("equals");
            el4.click();
            MobileElement result = driver.findElementById("com.google.android.calculator:id/result_final");
            assertEquals(expectedResult, result.getText());
        }

        @After
        public void tearDown() {
            driver.quit();
        }
    }
}