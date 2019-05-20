package com.automationpractice.pageobjects;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    // HomePage contructor
    public HomePage() {
    }

    public HomePage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // public HomePage(WebDriver driver, Map<String, String> data) {
    //     this(driver);
    //     this.data = data;
    //     PageFactory.initElements(driver, this);
    // }

    // public HomePage(WebDriver driver, Map<String, String> data, int timeout) {
    //     this(driver, data);
    //     this.timeout = timeout;
    //     PageFactory.initElements(driver, this);
    // }

    // /**
    //  * Submit the form to target page.
    //  *
    //  * @return the SignInPage class instance.
    //  */
    // public SignInPage submit() {
    //     clickSignInLink();
    //     SignInPage target = new SignInPage(driver, data, timeout);
    //     PageFactory.initElements(driver, target);
    //     return target;
    // }


}
