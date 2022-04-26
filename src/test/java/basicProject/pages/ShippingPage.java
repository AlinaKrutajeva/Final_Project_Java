package basicProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.assertj.core.api.Assertions.assertThat;

public class ShippingPage extends BasePage {
    private final By shippingType = By.xpath("//input[@value='2']");
    private final By storeAddress = By.xpath("//input[@value='3210']");
    private final By userName = By.id("address_first_name");
    private final By userSurname = By.id("address_last_name");
    private final By userPhoneNumber = By.id("address_phone_number");
    private final String shippingPageUrl = "https://www.1a.lv/checkout/shipping";


    public void chooseShippingType() {
        driver.findElement(shippingType).click();
    }

    public void chooseStoreAddress() {
        driver.findElement(storeAddress).click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
    }

    public void enterUserInformation(String name, String surname, String phone) {
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userSurname).sendKeys(surname);
        driver.findElement(userPhoneNumber).sendKeys(phone);
    }

    public void validateNameSurnamePhoneNumber() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String nameText = driver.findElement(By.id("address_first_name")).getAttribute("value");
        assertThat(nameText).isEqualTo("Alina");
        String surnameText = driver.findElement(By.id("address_last_name")).getAttribute("value");
        assertThat(surnameText).isEqualTo("K");
        String phoneText = driver.findElement(By.id("address_phone_number")).getAttribute("value");
        assertThat(phoneText).isEqualTo("23456789");
    }

    public void scrollUpPage() {
        ((JavascriptExecutor) driver).executeScript("scroll(500,0)");
    }

    public void validateShippingPageUrl() {
        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo(shippingPageUrl);
    }
}
