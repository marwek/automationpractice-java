package com.automationpractice.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {
    private WebDriver driver;
    private int timeout = 15;
    private String pageText = "Practice Selenium";

    @FindBy(xpath = "//ul[@id='homefeatured']/li")
    @CacheLookup
    private List<WebElement> homefeatured;


    // HomePage contructor
    public HomePage() {
    }

    public HomePage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void printList() {
        for (WebElement element  : homefeatured) {
            System.out.println(element.getAttribute("value"));
        }
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
}
