package testsByJunit5;

//The following is JUnit4 (obsolete)
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

//The following is JUnit5
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.DisplayName;
 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.api.AfterEach;
 
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
    @DisplayName("Test the java method \"runTestCase1\"")
    public void runTestCase1() {
        // variable definitions
        String userEmail = "newzealand1126@gmail.com";
        String userPassWord = "7fMT3C@w4vY2yMn";

        // test steps
        LoginPage loginPage = new LoginPage(driver);
        loginPage.NavigateToLoginPage();
        HomePage homePage = loginPage.LoginWithCredentials(userEmail, userPassWord);
        homePage.WaitUntilHomePageLoadingComplete();
    }

    @AfterEach
    public void tearDown(){
        Driver.quitWebDriver();
    }
}





