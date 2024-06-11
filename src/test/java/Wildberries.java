import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Wildberries {
    private WebDriver driver;
    private PageFactory pageFactory;
    private MainPage mainPage;
    private CartPage cartPage;

    public Wildberries(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome");
        driver = new ChromeDriver();
        driver.get("https://www.wildberries.ru/");
        pageFactory = new PageFactory();
    }

    @Test
    public void testAddToCartAndCheck() {
        Class<? extends PageFactory> mainPage = pageFactory.getClass();
        Class<? extends PageFactory> cartPage = pageFactory.getClass();

        List<Product> products = mainPage.addProductsToCart(3);
        mainPage.goToCart();
        Assert.assertTrue(cartPage.getModule(products));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

