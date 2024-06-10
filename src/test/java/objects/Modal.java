package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Modal {
    @FindBy(xpath = "//span[normalize-space()='100.00 BYN']")
    private WebElement sumForPay;
    @FindBy(xpath = "//button[contains(text(), 'Оплатить')]")
    private WebElement buttonPay;
    @FindBy(xpath = "//span[@class='pay-description__text']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//label[contains(text(), 'Номер карты') or contains(text(), 'Срок действия') or contains(text(), 'CVC') or contains(text(), 'Имя держателя (как на карте)')]")
    private List<WebElement> payCardFieldNames;
    @FindBy(xpath = "//div[contains(@class, 'cards-brands__container')]//img")
    private WebElement logoPaymentSystem;

    private WebDriver driver;

    public Modal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkDataForCommunicationPay() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(1);
        return sumForPay.isDisplayed();
    }

    public String getButtonPayText() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(1);
        return buttonPay.getText();
    }

    public String getPhoneNumber() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(1);
        return phoneNumber.getText();
    }

    public List<String> getFieldNamePayCard() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(1);
        List<String> fieldNames = new ArrayList<>();
        for (int i = 0; i < payCardFieldNames.size(); i++) {
            fieldNames.add(payCardFieldNames.get(i).getText());
        }
        return fieldNames;
    }

    public boolean isLogoDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(1);
        return logoPaymentSystem.isDisplayed();
    }

    public int getLogosCount() {
        int count = driver.findElements(By.xpath("//div[contains(@class, 'cards-brands__container')]//img")).size();
        return count;
    }
}
