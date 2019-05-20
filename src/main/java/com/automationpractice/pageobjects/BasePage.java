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

public abstract class BasePage {
    // BasePage fields
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;
    protected String pageUrl = "http://automationpractice.com";


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
        PageFactory.initElements(driver, this);
    }

    // public BasePage(WebDriver driver, Map<String, String> data) {
    //     this(driver);
    //     this.data = data;
    //
    // }

    // public BasePage(WebDriver driver, Map<String, String> data, int timeout) {
    //     this(driver, data);
    //     this.timeout = timeout;
    //     PageFactory.initElements(driver, this);
    // }

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
     * @return the BasePage class instance.
     */
    public BasePage clickSignInLink() {
        signIn.click();
        return this;
    }

    /**
     * Click on Contact Us Link in nav bar.
     *
     * @return the BasePage class instance.
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
}
