package simpleProcesses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class process2 {
    public static void main(String[] args) {

        // this is how I set a relative path in Java
        String localDir = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe";

        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver",localDir);

        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://www.facebook.com";
        String tagName = "";

        driver.get(baseUrl);
        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println("The tag name is: " + tagName);
        driver.quit();
        System.exit(0);
    }
}