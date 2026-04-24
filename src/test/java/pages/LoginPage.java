package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By username = By.id("username");
    By password = By.id("password");
    By submitBtn = By.id("submitBtn");
    By switchForm = By.id("switchForm");
    By message = By.id("msg");

    // Actions
    public void switchToRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(switchForm)).click();
    }

    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }

    public String getMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
    }
}