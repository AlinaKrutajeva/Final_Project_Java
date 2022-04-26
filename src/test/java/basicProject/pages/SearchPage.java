package basicProject.pages;

import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    private final By productType = By.xpath("//input[@class='sn-suggest-input autocomplete main-search-input']");
    private final By searchButton = By.xpath("//i[@class='main-search-submit__icon icon-svg']");

    public void enterProductType(String type) {
        driver.findElement(productType).sendKeys(type);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
    }
}
