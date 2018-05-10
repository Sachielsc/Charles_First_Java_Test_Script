package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    // definitions
    private WebDriver driver;
    private WebDriverWait wait;
    private static String LoginPageURL = "https://alphav3.vaultintel.com/index/hostLogin";

    // Web elements
    @FindBy(id = "user")
    WebElement userNameField;
    @FindBy(css = "input#password")
    WebElement passWordField;
    @FindBy(css = "button#login-submit")
    WebElement loginButton;

    // constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 8);
        PageFactory.initElements(driver, this);
    }

    // page object methods
    public void NavigateToLoginPage()
    {
        driver.get(LoginPageURL);
    }

    public HomePage LoginWithCredentials(String username, String password)
    {
        TypeUserName(username);
        TypePassword(password);
        clickLoginButton();
        return new HomePage(driver);
    }

    public void TypeUserName(String text)
    {
        wait.until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys(text);
    }

    public void TypePassword(String text)
    {
        wait.until(ExpectedConditions.elementToBeClickable(passWordField));
        passWordField.sendKeys(text);
    }

    public void clickLoginButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
}
