package basicProject;

import basicProject.pages.BasePage;
import basicProject.pages.HomePage;
import basicProject.pages.SearchPage;
import basicProject.pages.ShippingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRunner {

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    ShippingPage shippingPage = new ShippingPage();

    @Before
    public void openBrowser(){
        basePage.openChromeByUrl("https://www.1a.lv/");
    }

//    Product product = new Product();
//    static User user = new User();

    @Test
    public void aLvTest() {
        searchPage.enterProductBrandName("Lenovo");
        searchPage.clickOnSearchButton();
        homePage.chooseProduct();
//        save
        homePage.addProductToCart();
        homePage.goToCart();
        homePage.clickInCartContinueButton();
        homePage.enterAuthenticationData();
        homePage.clickContinueButton();
//        validate
        shippingPage.chooseShippingType();
        shippingPage.chooseStoreAddress();
        shippingPage.enterName("Alina");
        shippingPage.enterSurname("K");
        shippingPage.enterPhoneNumber("23456789");
        shippingPage.validateNameSurnamePhoneNumber();
//        validate product price

    }
        @After
        public void closeBrowser(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            basePage.closeChrome();
    }
}