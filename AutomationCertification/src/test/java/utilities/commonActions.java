package utilities;

import org.openqa.selenium.WebDriver;

public class commonActions {
    public WebDriver driver;
    public commonActions(WebDriver driver) {
        this.driver = driver;
    }

    public String generateRandomEmail(){
        String generatedMail;
        int randomNumber = (int) (Math.random() * 9999 + 4522);
        generatedMail = "testmail" + randomNumber + "@gmail.com";
        return generatedMail;
    }
}
