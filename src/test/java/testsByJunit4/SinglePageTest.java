package testsByJunit4;

import com.aventstack.extentreports.Status;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.ExtentManager;

import static utils.ExtentManager.extent;
import static utils.ExtentManager.test;

public class SinglePageTest {

    // definitions
    WebDriver driver;
    WebDriverWait wait;
    private String baseUrl = "https://alphav3.vaultintel.com/index/hostLogin";
    private String eventsURL = "https://alphav3.vaultintel.com/incidentManagement/incidentRegisters/index";
    private String userName = "plan.6";
    private String passWord = "plan01#";

    // Web elements
    @FindBy(id = "user")
    WebElement userNameField;
    @FindBy(css = "input#password")
    WebElement passWordField;
    @FindBy(css = "button#login-submit")
    WebElement loginButton;
    @FindBy(css = "#left-panel > span > i")
    WebElement expandArrow;
    @FindBy(partialLinkText = "Actions")
    WebElement firstActionsButton;

    // Step definitions
    private void Init()
    {
        driver = Driver.getWebDriver();
        wait = new WebDriverWait(driver, 8);
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
        extent = ExtentManager.GetExtent();
        test = extent.createTest("A simple test");
    }

    private void LogIn()
    {
        // Type in credentials
        wait.until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys(userName);

        wait.until(ExpectedConditions.elementToBeClickable(passWordField));
        passWordField.sendKeys(passWord);

        // log in
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(expandArrow));
    }

    private void GoToEventsPage(){
        driver.get(eventsURL);
        wait.until(ExpectedConditions.elementToBeClickable(firstActionsButton));
    }

    private void CleanUp(){
        test.log(Status.PASS, "My simple JUnit test case passes! Hooray!");
        Driver.quitWebDriver();
        extent.flush();
    }

    @Test
    public void TestCase1() {
        Init();
        LogIn();
        GoToEventsPage();
        CleanUp();
    }
}





