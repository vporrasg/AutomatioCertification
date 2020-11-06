package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.commonActions;
import utilities.waits;


public class registerPage extends basePage{

    public registerPage(WebDriver driver, String url) {
        super(driver, url);
    }

    private By inputFirstName =  By.xpath("//input[@id='input-firstname']");
    private By inputLastName =  By.xpath("//input[@id='input-lastname']");
    private By inputEmail =  By.xpath("//input[@id='input-email']");
    private By inputPhone =  By.xpath("//input[@id='input-telephone']");
    private By inputPassword =  By.xpath("//input[@id='input-password']");
    private By inputConfirmPassword =  By.xpath("//input[@id='input-confirm']");
    private By privacyPolicyCheckbox =  By.xpath("//input[@type='checkbox']");
    private By continueButton =  By.xpath("//input[@type='submit']");
    private By createdAccountMessage =  By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    public WebElement inputFirstName() {
        return driver.findElement(this.inputFirstName);
    }

    public WebElement inputLastName() {
        return driver.findElement(this.inputLastName);
    }

    public WebElement inputEmail() {
        return driver.findElement(this.inputEmail);
    }

    public WebElement inputPhone() {
        return driver.findElement(this.inputPhone);
    }

    public WebElement inputPassword() {
        return driver.findElement(this.inputPassword);
    }

    public WebElement inputConfirmPassword() {
        return driver.findElement(this.inputConfirmPassword);
    }

    public WebElement privacyPolicyCheckbox() {
        return driver.findElement(this.privacyPolicyCheckbox);
    }

    public WebElement continueButton() {
        return driver.findElement(this.continueButton);
    }

    public WebElement createdAccountMessage() {
        return driver.findElement(this.createdAccountMessage);
    }

    public void registerNewUser() {
        commonActions common = new commonActions(driver);
        this.inputFirstName().sendKeys("Victor");
        this.inputLastName().sendKeys("Porras");
        this.inputEmail().sendKeys(common.generateRandomEmail());
        this.inputPhone().sendKeys("88888888");
        this.inputPassword().sendKeys("Password9");
        this.inputConfirmPassword().sendKeys("Password9");
        this.privacyPolicyCheckbox().click();
        this.continueButton().click();
    }

    public void verifyUserIsLoggedAfterCreateAccount() {
        waits wait = new waits(driver);
        wait.waitForJSandJQueryToLoad();
        wait.untilElementExists(this.createdAccountMessage());
    }
}
