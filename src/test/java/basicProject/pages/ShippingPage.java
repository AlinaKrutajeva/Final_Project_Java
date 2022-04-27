package basicProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.assertj.core.api.Assertions.assertThat;

public class ShippingPage extends BasePage {
    private final By shippingToAddress = By.xpath("//input[@value='1']");
    private final By shippingToOffice = By.xpath("//input[@value='2']");
    private final By shippingByInternationalPost = By.xpath("//input[@value='2']");
    private final By storeLucavsalas3 = By.xpath("//input[@value='3210']");
    private final By storeMaskavas493 = By.xpath("//input[@value='3666']");
    private final By storeMaskavas418A = By.xpath("//input[@value='3543']");
    private final By storeMazaRencenu1 = By.xpath("//input[@value='3209']");
    private final By storePriedaines37 = By.xpath("//input[@value='3205']");
    private final By userName = By.id("address_first_name");
    private final By userSurname = By.id("address_last_name");
    private final By userPhoneNumber = By.id("address_phone_number");
    private final String shippingPageUrl = "https://www.1a.lv/checkout/shipping";


    public void chooseShippingType(String shipping) {
        if ("Piegāde uz adresi".equals(shipping)) {
            driver.findElement(shippingToAddress).click();
        } else if ("Saņemšana klientu centrā".equals(shipping)) {
            driver.findElement(shippingToOffice).click();
        } else if ("Izņemšanas punktā".equals(shipping)) {
            driver.findElement(shippingByInternationalPost).click();
        }
    }

    public void chooseStoreAddress(String storeAddress) {
        if ("Lucavsalas 3".equals(storeAddress)) {
            driver.findElement(storeLucavsalas3).click();
        } else if ("Maskavas 493".equals(storeAddress)) {
            driver.findElement(storeMaskavas493).click();
        } else if ("Maskavas 418a".equals(storeAddress)) {
            driver.findElement(storeMaskavas418A).click();
        } else if ("Mazā Rencēnu 1".equals(storeAddress)) {
            driver.findElement(storeMazaRencenu1).click();
        } else if ("Priedaines 37".equals(storeAddress)) {
            driver.findElement(storePriedaines37).click();
        }
        ((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
    }

    public void enterUserInformation(String name, String surname, String phone) {
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userSurname).sendKeys(surname);
        driver.findElement(userPhoneNumber).sendKeys(phone);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollUpPage() {
        ((JavascriptExecutor) driver).executeScript("scroll(500,0)");
    }

    public void validateShippingPageUrl() {
        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo(shippingPageUrl);
    }
}
