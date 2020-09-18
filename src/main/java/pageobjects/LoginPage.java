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
    private static String LoginPageURL = "http://demowebshop.tricentis.com/login";

    // Web elements
    @FindBy(id = "Email")
    WebElement emailField;
    @FindBy(id = "Password")
    WebElement passWordField;
    @FindBy(css="input[value='Log in']")
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
        TypeUserEmail(username);
        TypePassword(password);
        clickLoginButton();
        return new HomePage(driver);
    }

    public void TypeUserEmail(String text)
    {
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.sendKeys(text);
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
