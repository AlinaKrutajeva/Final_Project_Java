package basicProject;

import basicProject.models.User;
import basicProject.pages.BasePage;
import basicProject.pages.HomePage;
import basicProject.pages.SearchPage;
import basicProject.pages.ShippingPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class FinalProjectBasicLevel {

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    ShippingPage shippingPage = new ShippingPage();

    User user = new User();

    @Before
    public void openBrowser() {
        basePage.openChromeByUrl("https://www.1a.lv/");
    }

    @Test
    public void aLvTest() {
        homePage.submitCookiesPage();
        searchPage.enterProductType("Zilas beats studio wireless");
        searchPage.clickOnSearchButton();
        homePage.scrollDownPage();
        homePage.chooseBeatsStudioProduct();
        homePage.scrollDownPage();
        homePage.addProductToCart();
        basePage.getAndSetProductNameAndPriceFromPage();
        homePage.goToCart();
        basePage.validateProductNameAndPrice();
        homePage.clickInCartContinueButton();
        homePage.scrollDownPage();
        homePage.enterAuthenticationData("workjob@inbox.lv", "FinalProject2022");
        homePage.clickContinueButton();
        shippingPage.chooseShippingType("Saņemšana klientu centrā");
        shippingPage.chooseStoreAddress("Lucavsalas 3");
        shippingPage.enterAndValidateUserInformation(user.getUserName(), user.getUserSurname(), user.getUserPhone());
        shippingPage.scrollUpPage();
        basePage.validateFinalProductPrice();
        shippingPage.validateShippingPageUrl();
    }

        @After
        public void closeBrowser() {
        basePage.closeChrome();
    }
}