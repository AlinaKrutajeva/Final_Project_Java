package basicProject.pages;

import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    private final By productBrandName = By.xpath("//input[@class='sn-suggest-input autocomplete main-search-input']");
    private final By searchButton = By.xpath("//i[@class='main-search-submit__icon icon-svg']");

    public void enterProductBrandName(String brand) {
        driver.findElement(productBrandName).sendKeys(brand);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
    }
}
