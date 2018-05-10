package testsByJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;

public class SimplePageTest {

    // Initialization
    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait;
    private String baseUrl = "https://alphav3.vaultintel.com/index/hostLogin";
    private String userName = "plan.6";
    private String passWord = "plan01#";

    // Web elements
    @FindBy(id = "password")
    WebElement userNameField;
    @FindBy(css = "input#password")
    WebElement passWordField;
    @FindBy(css = "button#login-submit")
    WebElement loginButton;

    // Step definitions
    public void Init()
    {
        // Navigate to Vault page
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public void LogIn()
    {
        // Type in credentials
        wait.until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys(userName);

        wait.until(ExpectedConditions.elementToBeClickable(passWordField));
        passWordField.sendKeys(passWord);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    @Test
    @DisplayName("Navigate to Vault & type in credentials (All in one)")
    void NavigateAndCredentials () {
        Init();
        LogIn();
    }
}





