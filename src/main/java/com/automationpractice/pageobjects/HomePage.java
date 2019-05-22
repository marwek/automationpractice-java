package com.automationpractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[@class='product-container']")
    @CacheLookup
    private List<WebElement> productContainer;

    // HomePage contructor
    public HomePage() {
    }

    public HomePage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Add popular product to the cart
     * @param element
     * @return
     */
    public HomePage addPopularProductToCart(int element) {
        WebElement product = homefeatured.get(element);
        System.out.println(product.getText());
        return this;
    }

    /**
     * Check if displayed product has image
     * @param element
     * @return
     */
    public HomePage productIsDisplayed(int element) {
        // WebElement image = driver.findElement(By.xpath)

        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return true/false
     */
    public HomePage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageText);
            }
        });
        return this;
    }

	
}
