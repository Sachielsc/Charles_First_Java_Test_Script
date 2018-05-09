import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class page {

    public static void main(String[] args) {
        // this is how I set a relative path in Java
        String localDir = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe";

        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver",localDir);

        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
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
            System.out.println("Test Failed");
        }

        //close Fire fox
        driver.quit();
    }

}