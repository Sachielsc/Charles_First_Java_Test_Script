package testsByJunit;

//The following is JUnit4
//import org.junit.Before;
//import org.junit.Test;

//The following is JUnit5 (Beta)
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import pageobjects.*;
import utils.Driver;

public class PageObjectModelTest {
    // global variable definitions
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Driver.getWebDriver();
    }

    @Test
    @DisplayName("My first POM / JUnit test case")
    public void TestCase1() {
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





