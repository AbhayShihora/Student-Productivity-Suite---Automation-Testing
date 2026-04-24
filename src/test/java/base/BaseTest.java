package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.out.println("Opening browser..."); // DEBUG LINE

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://abhayshihora.github.io/Student-Productivity-Suite/index.html");
    }

    @AfterMethod
    public void tearDown() {

        // driver.quit(); // keep commented for now
    }
}