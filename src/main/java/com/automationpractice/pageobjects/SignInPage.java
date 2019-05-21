package com.automationpractice.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BasePage {
    private WebDriver driver;
    private int timeout = 15;
    private static final String pageText = "Please enter your email address to create an account.";

    // SignIn page elements
    @FindBy(css = "div[class='alert alert-danger']")
    private WebElement alertAuthentication;

    @FindBy(id = "email_create")
    @CacheLookup
    private WebElement emailCreateField;

    @FindBy(id = "email")
    @CacheLookup
    private WebElement emailAddress;

    @FindBy(id = "passwd")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    @CacheLookup
    private WebElement signIn;

    @FindBy(css = "a[title='Recover your forgotten password']")
    @CacheLookup
    private WebElement forgotYourPassword;


    // SignInPage constructor
    public SignInPage() {
    }

    public SignInPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Set value to Email Address Text field.
     *
     * @return the SignInPage class instance.
     */
    public SignInPage createNewUser(String emailAddress) {
        emailCreateField.sendKeys(emailAddress);
        return this;
    }

    /**
     * Login user with password
     * @param user
     * @param userPassword
     * @return SigInPage
     */
    public SignInPage loginUser(String user, String userPassword) {
        emailAddress.sendKeys(user);
        password.sendKeys(userPassword);
        signIn.click();
        return this;
    }

    /**
     * Verify text if user has logged successfuly or not
     * @param message
     * @return
     */
    public boolean verifyLoginUser(String message) {
        return alertAuthentication.getText().toString().contains(message);
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return true/false
     */
    public SignInPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageText);
            }
        });
        return this;
    }




}
