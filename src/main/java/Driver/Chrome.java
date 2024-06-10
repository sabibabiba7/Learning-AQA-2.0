package Driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
    public static void main (String [] args){
        System.setProperty( "webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}
