package simpleProcesses;

import org.openqa.selenium.WebDriver;
import utils.Driver;

public class process1Test {

    public static void main(String[] args) {

        WebDriver driver;
        driver = Driver.getWebDriver("firefox"); // I can define the web driver type here.

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Google Chrome or Firefox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        //close Google Chrome or Firefox
        Driver.quitWebDriver();
        System.exit(0); /* exit(0) generally used to indicate successful termination. exit(1) or exit(-1) or any other non-zero value indicates unsuccessful termination in general. */
    }

}