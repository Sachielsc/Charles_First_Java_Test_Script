package testsByJunit;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.*;
import utils.Driver;

public class PageObjectModelTest {
    // global variable definitions
    WebDriver driver;

    @Before
    public void setUp(){
        driver = Driver.getWebDriver();
    }

    @Test
    @DisplayName("My first POM / JUnit test case")
    void TestCase1() {
        // variable definitions
        String userName = "plan.6";
        String passWord = "plan01#";

        // test steps
        LoginPage loginPage = new LoginPage(driver);
        loginPage.NavigateToLoginPage();
        HomePage homePage = loginPage.LoginWithCredentials(userName, passWord);
        homePage.WaitUntilHomePageLoadingComplete();
    }
}





