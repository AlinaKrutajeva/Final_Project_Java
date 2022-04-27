package basicProject;

import basicProject.models.Product;
import basicProject.models.User;
import basicProject.pages.BasePage;
import basicProject.pages.HomePage;
import basicProject.pages.SearchPage;
import basicProject.pages.ShippingPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalProjectBasicLevel {

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    ShippingPage shippingPage = new ShippingPage();

    static Product product = new Product();
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
        product.setProductName();
        product.setProductPrice();
        homePage.scrollDownPage();
        homePage.addProductToCart();
        homePage.goToCart();
        assertThat(product.getProductName()).isEqualTo("Bezvadu austiņas Beats Studio3 Wireless, zila");
        assertThat(product.getProductPrice()).isEqualTo("288,97 €");
        homePage.clickInCartContinueButton();
        homePage.scrollDownPage();
        homePage.enterAuthenticationData("workjob@inbox.lv", "FinalProject2022");
        homePage.clickContinueButton();
        shippingPage.chooseShippingType("Saņemšana klientu centrā");
        shippingPage.chooseStoreAddress("Lucavsalas 3");
        shippingPage.enterUserInformation(user.getUserName(), user.getUserSurname(), user.getUserPhone());
        assertThat(user.getUserName()).isEqualTo("Alina");
        assertThat(user.getUserSurname()).isEqualTo("K");
        assertThat(user.getUserPhone()).isEqualTo("23456789");
        shippingPage.scrollUpPage();
        assertThat(product.getProductPrice()).isEqualTo("288,97 €");
        shippingPage.validateShippingPageUrl();
    }

        @After
        public void closeBrowser() {
        basePage.closeChrome();
    }
}