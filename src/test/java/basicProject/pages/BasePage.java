package basicProject.pages;

import basicProject.models.Product;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class BasePage {
    public static ChromeDriver driver;

    Product product = new Product();

    private final By productNameOnPage = By.xpath("//a[@class='detailed-cart-item__name-link']");
    private final By productPriceOnPage = By.xpath("//div[@class='detailed-cart-item__column detailed-cart-item__column--price']");
    private final By checkName = By.xpath("//a[@class='detailed-cart-item__name-link']");
    private final By checkPrice = By.xpath("//p[@class='detailed-cart-item__price']");
    private final By finalProductPrice = By.xpath("//span[@class='checkout-order-summary-total__price']");

    public void openChromeByUrl(String url) {
        String driverPath = "C:\\Users\\a_lin\\IdeaProjects\\FinalProject\\src\\test\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getAndSetProductNameAndPriceFromPage() {
        String nameOnPage = driver.findElement(productNameOnPage).getText();
        product.setProductName(nameOnPage);
        String priceOnPage = driver.findElement(productPriceOnPage).getText();
        product.setProductPrice(priceOnPage);
    }

    public void validateProductNameAndPrice() {
        String checkProductName = driver.findElement(checkName).getText();
        assertThat(checkProductName).isEqualTo(product.productName);
        String checkProductPrice = driver.findElement(checkPrice).getText();
        assertThat(checkProductPrice).isEqualTo(product.productPrice);
    }

    public void validateFinalProductPrice() {
        String productFinalPrice = driver.findElement(finalProductPrice).getText();
        assertThat(productFinalPrice).isEqualTo(product.getProductPrice());
    }

    public void closeChrome() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
