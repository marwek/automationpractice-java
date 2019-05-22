package com.automationpractice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import com.automationpractice.pageobjects.CreateAccount;
import com.automationpractice.pageobjects.HomePage;
import com.automationpractice.pageobjects.SignInPage;
import com.automationpractice.utils.PageUrls;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("User login tests.")
public class LoginTests {
    private WebDriver driver;
    private String  authFailed = "Authentication failed";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PageUrls.getMainUrl());
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
                    .createNewUser("user1123@email.com");

        CreateAccount create = new CreateAccount(driver);
        create.clickCreateAnAccountButton()
                    .setMrRadioButtonField()
                    .setFirstName("Janek")
                    .setLastName("Kovalsky")
                    .setPassword("123456")
                    .selectDayOfBirth("12")
                    .selectMonthOfBirth("6")
                    .selectYearOfBirth("1956")
                    .setSignUpForOurNewsletter()
                    .setReceiveSpecialOffersFromOurPartners()
                    .setAddress("Łączna")
                    .setState("Iowa")
                    .setZippostalCodeTextField("678900")
                    .setMobilePhone("900900900");

        assertEquals("Janek", create.getFirstName());
        assertEquals("Kovalsky", create.getLastName());
        assertEquals("Łączna", create.getAddress());


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
