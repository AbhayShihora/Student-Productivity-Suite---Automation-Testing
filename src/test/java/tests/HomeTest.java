package tests;

import utils.ScreenshotUtil;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class HomeTest extends BaseTest {

    @Test
    public void registerAndLoginTest() throws InterruptedException {

        // Step 1: Click "Create one"
        driver.findElement(By.id("switchForm")).click();

        Thread.sleep(1000);

        // Step 2: Enter new user details
        driver.findElement(By.id("username")).sendKeys("Abhay");
        driver.findElement(By.id("password")).sendKeys("Abhay@1234");

        // Step 3: Click Register
        driver.findElement(By.id("submitBtn")).click();

        Thread.sleep(2000);

        // Step 4: Verify registration message
        String registerMsg = driver.findElement(By.id("msg")).getText();
        System.out.println("Register Msg: " + registerMsg);

        Assert.assertTrue(registerMsg.contains("Account created"),
                "Registration failed!");

        // Step 5: Switch back to login
        driver.findElement(By.id("switchForm")).click();

        Thread.sleep(1000);

        // Step 6: Enter same credentials
        driver.findElement(By.id("username")).sendKeys("Abhay");
        driver.findElement(By.id("password")).sendKeys("Abhay@1234");

        // Step 7: Click Login
        driver.findElement(By.id("submitBtn")).click();

        Thread.sleep(2000);

        // Step 8: Validate login success
        String loginMsg = driver.findElement(By.id("msg")).getText();
        System.out.println("Login Msg: " + loginMsg);

        try {
            Assert.assertTrue(loginMsg.contains("Login successful"),
                    "Login failed!");
        } catch (Exception e) {

            // Take screenshot if failed
            ScreenshotUtil.capture(driver, "login_failure");

            throw e;
        }

        System.out.println("Register + Login Test Passed ✅");
    }
}