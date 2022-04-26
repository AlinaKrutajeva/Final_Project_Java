package basicProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage extends BasePage {

    public void scrollDownPage() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chooseProduct() {
        driver.findElement(By.xpath("//div[@class='sn-product-inner ks-gtm-categories']")).click();
    }

    public void addProductToCart() {
        driver.findElement(By.id("add_to_cart_btn")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goToCart() {
        driver.findElement(By.xpath("//a[@class='main-button']")).click();
    }

    public void clickInCartContinueButton() {
        driver.findElement(By.xpath("//input[@class='main-button cart-main-button']")).click();
    }

    public void enterAuthenticationData() {
        driver.findElement(By.id("user_email")).sendKeys("workjob@inbox.lv");
        driver.findElement(By.id("user_password")).sendKeys("FinalProject2022");
    }

    public void clickContinueButton() {
        driver.findElement(By.xpath("//input[@value='Pievienoties']")).click();
    }
}
