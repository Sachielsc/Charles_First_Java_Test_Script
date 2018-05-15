package simpleProcesses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;

public class process3 {
    public static void main(String[] args) {
        WebDriver driver;
        String baseUrl = "http://www.facebook.com";
        String tagName;

        driver = Driver.getWebDriver();
        driver.get(baseUrl);

        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println("The tag name is: " + tagName);
        Driver.quitWebDriver();
        System.exit(0); /* exit(0) generally used to indicate successful termination. exit(1) or exit(-1) or any other non-zero value indicates unsuccessful termination in general. */
    }
}