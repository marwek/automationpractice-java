package com.automationpractice.pageobjects;

import java.util.List;

import com.automationpractice.utils.Log;

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
    private List<WebElement> popularProductList;

    @FindBy(xpath = "//div[@class='product-container']")
    private List<WebElement> productContainer;

    @FindBy(css = "body[id='product']")
    private WebElement productQuickView;

    @FindBy(xpath = "//*[@id='quantity_wanted_p']/a[1]")
    private WebElement quantityMinus;

    @FindBy(xpath = "//*[@id='quantity_wanted_p']/a[2]")
    private WebElement quantityPlus;

    @FindBy(css = "select[name='group_1']")
    private WebElement sizeSelect;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']/li/a")
    private List<WebElement> colourList;

    @FindBy(css = "button[name='Submit']")
    private WebElement addToCart;



    @FindBy(css = "#layer_cart")
    private WebElement layerCart;

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
     * 
     * @param elementTitle name of the popular product
     * @param quantity     number
     * @param size         given size
     * @param colour       given colour
     */
    public void addPopularProduct(String elementTitle, int quantity, String size, String colour) {
        // foreach - few elements on page
        Log.info("Add popular product to the cart: " + elementTitle);
        for (WebElement el : popularProductList) {
            if (el.getText().contains(elementTitle)) {
                Log.info(String.format("--> Element %s <---", el.getAttribute("value")));
                Actions action = new Actions(driver);
                action.moveToElement(el).moveToElement(driver.findElement(By.xpath("//a[@class='quick-view']")))
                        .click();
                action.perform();
                Log.info(String.format("Click on product '%s'.", el.getText()));
            }
        }
        Log.info("Wait for Fancy box");
        waitForFancyboxFrame("body[id='product']");
        
        Log.info(String.format("Click '%d' times quantity '+' button", quantity));
        for (int i = 1; i < quantity; i++) {
            quantityPlus.click();
            pause(250);
        }
        
        Log.info("Select colour: " + colour);
        selectColour(colour);
        
        Log.info("Select size: " + size);
        selectSize(size);
    }

    /**
     * Click button Add to cart
     */
    public void addToCart() {
        addToCart.click();
        pause(1000);
    }

    /**
     * Click proceed to checkout button.
     */
    public void proceedToCheckout() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Proceed to checkout']")));
        pause(500);
        element.click();
    }

    /**
     * Select size of the product
     * 
     * @param size text S/M/L
     * @return same
     */
    public void selectSize(String size) {
        new Select(sizeSelect).selectByVisibleText(size);
    }

    public void selectColour(String colour) {
        for (WebElement el : colourList) {
            if (el.getAttribute("name").toLowerCase().contains(colour.toLowerCase())) {
                    if (!el.isSelected()) {
                        el.click();
                    }
            }
        }
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
     * 
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
