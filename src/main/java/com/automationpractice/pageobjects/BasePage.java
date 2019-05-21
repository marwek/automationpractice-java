package com.automationpractice.pageobjects;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    // BasePage fields
    public WebDriver driver;
    public WebDriverWait wait;
    private int timeout = 15;
    private static final String pageUrl = "http://automationpractice.com";
    private static final String pageText = "Automation Practice Website";

    // User information module NAV
    @FindBy(css = "a.login")
    @CacheLookup
    private WebElement signIn;

    @FindBy(id = "contact-link")
    @CacheLookup
    private WebElement contactUs;


    // My account
    @FindBy(css = "a[title='Manage my customer account']")
    @CacheLookup
    private WebElement myAccount;

    @FindBy(css = "a[title='My addresses']")
    @CacheLookup
    private WebElement myAddresses;

    @FindBy(css = "a[title='My credit slips']")
    @CacheLookup
    private WebElement myCreditSlips;

    @FindBy(css = "a[title='My orders']")
    @CacheLookup
    private WebElement myOrders;

    // Information
    @FindBy(css = "a[title='About us']")
    @CacheLookup
    private WebElement aboutUs;

    @FindBy(css = "a[title='New products']")
    @CacheLookup
    private WebElement newProducts;

    @FindBy(css = "a[title='Our stores']")
    @CacheLookup
    private WebElement ourStores;

    // Socials
    @FindBy(css = "a[href='https://www.facebook.com/groups/525066904174158/']")
    @CacheLookup
    private WebElement facebook;

    @FindBy(css = "a[href='https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA']")
    @CacheLookup
    private WebElement youtube;

    @FindBy(css = "a[href='https://twitter.com/seleniumfrmwrk']")
    @CacheLookup
    private WebElement twitter;

    // BasePage contructor
    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        this();
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);

    }

    /**
     * Click on About Us Link.
     *
     * @return the BasePage class instance.
     */
    public BasePage clickAboutUsLink() {
        aboutUs.click();
        return this;
    }

    /**
     * Click on Facebook Link.
     *
     * @return the BasePage class instance.
     */
    public BasePage clickFacebookLink() {
        facebook.click();
        return this;
    }

    /**
     * Click on Sign In Link.
     *
     * @return the SignInPage page instance.
     */
    public BasePage clickSignInLink() {
        signIn.click();
        return new SignInPage(driver);
    }

    /**
     * Click on Contact Us Link in nav bar.
     *
     * @return the ContactUs page instance.
     */
    public BasePage clickContactUsNavBarLink() {
        contactUs.click();
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the BasePage class instance.
     */
    public BasePage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return true/false
     */
    public BasePage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageText);
            }
        });
        return this;
    }

    /**
     * Wrapper for wait method.
     * @param elementBy
     */
    public void waitVisibility(WebElement elementBy) {
        wait.until(ExpectedConditions.visibilityOf(elementBy));
    }

    /**
     * Read web element text
     * @param elementBy
     * @return text of element
     */
    public String readText(By elementBy) {
        return driver.findElement(elementBy).getText();
    }

    /**
     * Write text to specified inputfield
     * @param elementLocation
     * @param text
     */
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }


}
