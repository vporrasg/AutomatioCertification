package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.waits;


public class searchResultsPage extends basePage{

    public searchResultsPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButton = By.id("button-cart");
    private By successModal =  By.xpath("//div[contains(@class, 'alert alert-success alert-dismissible')]");
    private By firstProductImage =  By.cssSelector(".product-thumb > div.image");
    private By shoppingCartButton =  By.xpath("//span[contains(text(),'Shopping Cart')]");
    private By productPrice =  By.xpath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[1]/h2");

    public  WebElement getAddToCartButton() {
        return driver.findElement(this.addToCartButton);
    }

    public  WebElement shoppingCartButton() {
        return driver.findElement(this.shoppingCartButton);
    }

    public WebElement getSuccessModal() {
        return driver.findElement(this.successModal);
    }

    public WebElement firstProductImage() {
        return driver.findElement(this.firstProductImage);
    }

    public WebElement productPrice() {
        return driver.findElement(this.productPrice);
    }


    public void addProductToCart() {
        this.getAddToCartButton().click();
    }

    public void clickShoppingCartButton() {
        this.shoppingCartButton().click();
    }

    public void clickFirstProduct() {
        this.firstProductImage().click();
    }

    public void verifySuccessfulMessage() {
        waits wait = new waits(driver);
        wait.waitForJSandJQueryToLoad();
        wait.untilElementExists(this.getSuccessModal());
    }



}
