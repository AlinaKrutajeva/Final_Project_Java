package basicProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage extends BasePage {

    public void chooseProduct() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            ((JavascriptExecutor) driver).executeScript("scroll(0,900)");
            driver.findElement(By.xpath("//span[@content='1278,99']")).click();
        }
    }

    public void addProductToCart() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,150)");
        driver.findElement(By.xpath("//button[@id='add_to_cart_btn']")).click();
    }

    public void goToCart() {
        driver.findElement(By.xpath("//a[@class='main-button']")).click();
    }

    public void clickInCartContinueButton() {
        driver.findElement(By.xpath("//input[@class='main-button cart-main-button']")).click();
    }

    public void enterAuthenticationData() {
        driver.findElement(By.xpath("//input[@class='users-session-form__input users-session-form__input--text']")).click();
    }

    public void clickContinueButton() {
        driver.findElement(By.xpath("//input[@class='users-session-form__submit']")).click();
    }

}
