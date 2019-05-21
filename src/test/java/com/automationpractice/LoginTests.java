package com.automationpractice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import com.automationpractice.pageobjects.CreateAccount;
import com.automationpractice.pageobjects.HomePage;
import com.automationpractice.pageobjects.SignInPage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

@DisplayName("User login tests.")
public class LoginTests {
    public WebDriver driver;
    String pageUrl = "http://automationpractice.com";
    public String  authFailed = "Authentication failed";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(pageUrl);
    }

    @Test
    public void InvalidUserLogin() {
        HomePage home = new HomePage(driver);
        home.verifyPageLoaded()
            .clickSignInLink();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.verifyPageLoaded();

        signInPage.loginUser("user@mail.com", "123456");
        assertTrue(signInPage.verifyLoginUser(authFailed));
    }

    @Test
    public void CreateNewAccount() {
        HomePage home = new HomePage(driver);
        home.clickSignInLink();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.verifyPageLoaded()
                    .createNewUser("user@email.com");

        CreateAccount create = new CreateAccount(driver);
        create.clickCreateAnAccountButton()
                    .setMrRadioButtonField();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
