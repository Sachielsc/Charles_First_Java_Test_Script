package simpleProcesses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class process1 {

    public static void main(String[] args) {
        // this is how I set a relative path in Java
        String chromeDriverDir = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe";
        // String geckoDriverDir = System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver-v0.24.0-win64\\geckodriver.exe";

        System.setProperty("webdriver.chrome.driver",chromeDriverDir);
        // System.setProperty("webdriver.gecko.driver",geckoDriverDir);

        WebDriver webDriver = new ChromeDriver();
        // WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Google Chrome or Firefox and direct it to the Base URL
        webDriver.get(baseUrl);

        // get the actual value of the title
        actualTitle = webDriver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Google Chrome or Firefox
        webDriver.quit();
    }

}