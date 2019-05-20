package com.automationpractice;

import java.util.concurrent.TimeUnit;

import com.automationpractice.pageobjects.HomePage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("User login tests.")
public class LoginTests {
    public WebDriver driver;
    String pageUrl = "http://automationpractice.com";


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(pageUrl);
    }

    @Test
    public void testHomePage()
    {
        HomePage home = new HomePage(driver);
        home.clickSignInLink();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
