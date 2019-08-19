package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

/* This class holds a static WebDriver so that there can only ever be one webdriver in use at once. This also means there can be no parallel testing. */
public class Driver {
    private static WebDriver webDriver;

    /* This function WerDriver will be overwritten if I put a web driver type in the attribute. TODO: To use a try and catch here to capture the invalid input as an error. */
    public static WebDriver getWebDriver() {
        if (webDriver == null || webDriver.toString().contains("null")){

            // this is how I set a relative path in Java
            String chromeDriverDir = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe";

            // This is how I declare the path of web drivers in Java
            System.setProperty("webdriver.chrome.driver", chromeDriverDir);
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

    public static WebDriver getWebDriver(String webDriverType) {
        if (webDriver == null || webDriver.toString().contains("null")){

            String webDriverDir;

            switch (webDriverType.toLowerCase()) {
                case "chrome":
                case "googlechrome":
                case "chromedriver":
                    // this is how I set a relative path in Java
                    webDriverDir = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe";

                    // This is how I declare the path of web drivers in Java
                    System.setProperty("webdriver.chrome.driver", webDriverDir);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--disable-infobars");
                    chromeOptions.setHeadless(false);
                    webDriver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                case "firefoxdriver":
                case "geckodriver":
                case "gecko":
                    // this is how I set a relative path in Java
                    webDriverDir = System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver-v0.24.0-win64\\geckodriver.exe";

                    // This is how I declare the path of web drivers in Java
                    System.setProperty("webdriver.gecko.driver",webDriverDir);
                    webDriver = new FirefoxDriver();
                    break;
            }

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
