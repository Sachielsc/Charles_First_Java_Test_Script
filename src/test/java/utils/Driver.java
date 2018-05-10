package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;

/**
 * This class holds a static WebDriver so that there can only ever be one webdriver in use at once. This also means there
 * can be no parallel testing.
 */
public class Driver {
    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (webDriver == null || webDriver.toString().contains("null")){

            // this is how I set a relative path in Java
            String localDir = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe";

            System.setProperty("webdriver.chrome.driver", localDir);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.setHeadless(false);
            webDriver = new ChromeDriver(chromeOptions);
            // webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            webDriver.manage().window().maximize();
        }

        return webDriver;
    }

    public static void quitWebDriver() {
        if (!hasQuit(webDriver)){
            webDriver.quit();
        }
    }

    public static boolean hasQuit(WebDriver driver) {
        return ((RemoteWebDriver)driver).getSessionId() == null;
    }

}
