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


    public void chooseShippingType() {
        driver.findElement(shippingType).click();
    }

    public void chooseStoreAddress() {
        driver.findElement(storeAddress).click();
    }

    public void enterName(String name) {
        ((JavascriptExecutor) driver).executeScript("scroll(0,250)");
        driver.findElement(userName).sendKeys(name);
    }

    public void enterSurname(String surname) {
        driver.findElement(userSurname).sendKeys(surname);
    }

    public void enterPhoneNumber(String phone) {
        driver.findElement(userPhoneNumber).sendKeys(phone);
    }

    public void validateNameSurnamePhoneNumber() {
        String nameText = driver.findElement(By.id("inputFirstName")).getAttribute("value");
        assertThat(nameText).isEqualTo("Alina");
        String surnameText = driver.findElement(By.id("inputLastName")).getAttribute("value");
        assertThat(surnameText).isEqualTo("K");
        String phoneText = driver.findElement(By.id(",,")).getAttribute("value");
        assertThat(phoneText).isEqualTo("23456789");
    }
}
