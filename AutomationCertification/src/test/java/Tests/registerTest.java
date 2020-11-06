package Tests;

import PageObjects.registerPage;
import org.testng.annotations.Test;
import PageObjects.homePage;

public class registerTest extends baseTest{

    public registerTest() {
        super("chrome");
    }

    @Test(groups = {"Register"})
    public void registerNewAccountTest(){
        homePage home = new homePage(driver, getBaseURL());
        registerPage register = new registerPage(driver, getBaseURL());
        home.goToPage();
        home.goToRegisterPage();

        register.registerNewUser();
        register.verifyUserIsLoggedAfterCreateAccount();
    }
}
