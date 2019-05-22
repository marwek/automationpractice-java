package com.automationpractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends BasePage {
    private WebDriver driver;
    private int timeout = 15;
    
    // Page static fields
    private String pageText = "Practice Selenium";
    private String fancyFrame = "iframe[class='fancybox-iframe']";

    // Page elements
    @FindBy(xpath = "//ul[@id='homefeatured']/li")
    @CacheLookup
    private List<WebElement> homefeatured;

    @FindBy(xpath = "//div[@class='product-container']")
    @CacheLookup
    private List<WebElement> productContainer;

    @FindBy(css = "body[id='product']")
    private WebElement productQuickView;

    @FindBy(xpath = "//*[@id='quantity_wanted_p']/a[1]")
    private WebElement quantityMinus;
    
    @FindBy(xpath = "//*[@id='quantity_wanted_p']/a[2]")
    private WebElement quantityPlus;

    @FindBy(css = "select[name='group_1']")
    private WebElement sizeSelect;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']")
    private List<WebElement> selectColour;

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
     * @param elementTitle name of the popular product
     * @param quantity number 
     * @param size given size
     * @param colour given colour
     * @return same
     */
    public HomePage addPopularProductToCart(String elementTitle, int quantity, String size, String colour) {
        // foreach - few elements on page
        for (WebElement el : homefeatured) {
            if (el.getText().contains(elementTitle)) {
                Actions action = new Actions(driver);
                action.moveToElement(el).moveToElement(driver.findElement(By.xpath("//a[@class='quick-view']"))).click();
                action.perform();
                break;
            }
        }
        waitForFancyboxFrame("body[id='product']");
        for (int i = 1; i < quantity; i++) {
            quantityPlus.click();
            pause(250);
        }
        selectSize(size);
        

        return this;
    }

    /**
     * Select size of the product
     * @param size text S/M/L
     * @return same
     */
    public HomePage selectSize(String size) {
        new Select(sizeSelect).selectByVisibleText(size);
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

    /**
     * Wait and check if element exist in inner frame
     * @param element css selector of element
     */
    public void waitForFancyboxFrame(String element) {
        try {
            driver.switchTo().frame(driver.findElement(By.cssSelector(fancyFrame)));
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("html"))));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(element))));
        } catch (WebDriverException e) {
            e.getMessage();
        }
    }


}
