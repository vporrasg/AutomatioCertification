package Tests;

import PageObjects.cartPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.homePage;
import PageObjects.searchResultsPage;
import utilities.waits;

public class productTest extends baseTest{

    public productTest() {
        super("chrome");
    }

    @Test(groups = {"Products"})
    public void addProductToCart(){
        homePage home = new homePage(driver, getBaseURL());
        searchResultsPage searchResults = new searchResultsPage(driver);
        cartPage cart = new cartPage(driver);
        waits wait = new waits(driver);

        home.goToPage();
        home.doSearch("Macbook");
        searchResults.clickFirstProduct();
        searchResults.addProductToCart();
        searchResults.verifySuccessfulMessage();
        searchResults.clickShoppingCartButton();
        cart.checkoutButton().click();
        wait.untilElementExists(cart.productNotBuyableMessage());
    }

    @Test(groups = {"Products"})
    public void verifyPriceTest(){
        homePage home = new homePage(driver, getBaseURL());
        searchResultsPage searchResults = new searchResultsPage(driver);
        String expectedPrice = "$602.00";

        home.goToPage();
        home.doSearch("Macbook");
        searchResults.clickFirstProduct();
        Assert.assertEquals(searchResults.productPrice().getText() , expectedPrice);
    }
}
