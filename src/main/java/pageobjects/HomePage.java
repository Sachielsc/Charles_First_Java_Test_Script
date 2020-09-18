package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    // definitions
    private WebDriver driver;
    private WebDriverWait wait;

    // Web elements
    @FindBy(css="a[class='account']")
    WebElement userEmailLogInLink;

    // constructor
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 8);
        PageFactory.initElements(driver, this);
    }

    // page object methods
    public void WaitUntilHomePageLoadingComplete()
    {
        wait.until(ExpectedConditions.elementToBeClickable(userEmailLogInLink));
    }

    public void LogOutFromHomePage() {

    }
}
