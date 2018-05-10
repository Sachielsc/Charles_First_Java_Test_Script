package testsByJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.ExtentManager;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SimplePageTest {

    // definitions
    WebDriver driver;
    WebDriverWait wait;
    private String baseUrl = "https://alphav3.vaultintel.com/index/hostLogin";
    private String eventsURL = "https://alphav3.vaultintel.com/incidentManagement/incidentRegisters/index";
    private String userName = "plan.6";
    private String passWord = "plan01#";
    public static ExtentReports extent;
    public static ExtentTest test;
    private String htmlFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\extentReporter";

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
    public void Init()
    {
        driver = Driver.getWebDriver();
        wait = new WebDriverWait(driver, 8);
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);

        // TODO: extentreporter not working yet
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(htmlFilePath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void LogIn()
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

    public void GoToEventsPage(){
        driver.get(eventsURL);
        wait.until(ExpectedConditions.elementToBeClickable(firstActionsButton));
    }

    public void CleanUp(){
        extent.flush();
        Driver.quitWebDriver();
    }

    @Test
    @DisplayName("My first JUnit test case (All in one)")
    void TestCase1() {
        Init();
        LogIn();
        GoToEventsPage();
        CleanUp();
    }
}





