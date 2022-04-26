package basicProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage extends BasePage {

    private final By beatsStudioProduct = By.xpath("//div[@class='sn-product-inner ks-gtm-categories']");
    private final By beatsStudioInCart = By.id("add_to_cart_btn");
    private final By cartWithProduct = By.xpath("//a[@class='main-button']");
    private final By cartContinueButton = By.xpath("//input[@class='main-button cart-main-button']");
    private final By loginEmail = By.id("user_email");
    private final By loginPassword = By.id("user_password");
    private final By continueButton = By.xpath("//input[@value='Pievienoties']");


    public void scrollDownPage() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chooseBeatsStudioProduct() {
        driver.findElement(beatsStudioProduct).click();
    }

    public void addProductToCart() {
        driver.findElement(beatsStudioInCart).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goToCart() {
        driver.findElement(cartWithProduct).click();
    }

    public void clickInCartContinueButton() {
        driver.findElement(cartContinueButton).click();
    }

    public void enterAuthenticationData(String email, String password) {
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
