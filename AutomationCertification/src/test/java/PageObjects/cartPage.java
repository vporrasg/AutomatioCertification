package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage extends basePage{

    public cartPage(WebDriver driver) {
        super(driver);
    }

    private By checkoutButton = By.xpath("//a[contains(text(),'Checkout')]");
    private By productNotBuyableMessage = By.cssSelector("#checkout-cart > div.alert.alert-danger.alert-dismissible");

    public WebElement checkoutButton() {
        return driver.findElement(this.checkoutButton);
    }

    public WebElement productNotBuyableMessage() {
        return driver.findElement(this.productNotBuyableMessage);
    }


}
