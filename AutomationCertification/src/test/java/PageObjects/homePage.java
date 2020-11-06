package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import utilities.waits;

public class homePage extends basePage{

    public homePage(WebDriver driver, String url) {
        super(driver, url);
    }

    private By searchTextBox = By.xpath("//input[@name='search']");
    private By myAccountButton = By.cssSelector("#top-links > ul > li.dropdown > a");
    private By registerButton = By.xpath("//a[contains(text(),'Register' )]");

    public WebElement getSearchTextBox() {
        return driver.findElement(this.searchTextBox);
    }

    public void doSearch(String productName) {
        getSearchTextBox().sendKeys(productName);
        getSearchTextBox().sendKeys(Keys.ENTER);
    }

    public WebElement myAccountButton() {
        return driver.findElement(this.myAccountButton);
    }

    public WebElement registerButton() {
        return driver.findElement(this.registerButton);
    }

    public void goToRegisterPage() {
        waits wait = new waits(driver);
        this.myAccountButton().click();
        wait.waitForJSandJQueryToLoad();
        this.registerButton().click();
    }
}
