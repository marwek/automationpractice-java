package com.automationpractice.pageobjects;

import java.text.DecimalFormat;
import java.util.List;

import com.automationpractice.utils.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {
    private WebDriver driver;
    private int timeout = 15;

    // Page static fields
    private final String pageText = "Shopping-cart summary";

    // Page elements
    @FindBy(css = "#order-detail-content")
    private List<WebElement> orderDetailTable;

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr")
    private List<WebElement> cartSummaryTable;


    // Constructor
    public ShoppingCartPage() {
    }

    public ShoppingCartPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Check given name of the product and total price
     * @param productName string
     * @param priceTotal float
     * @return bool
     */
    public Boolean checkNameAndTotalPriceForProduct(String productName, float priceTotal) {
        // flags to check conditions
        Boolean pN = false;
        Boolean pT = false;
        Float pTotal = 0.00f;
        
        for (WebElement tableRow : cartSummaryTable) {
            String row = tableRow.findElement(By.xpath("//td/p[@class='product-name']/a")).getText();
            String totalPrice = tableRow.findElement(By.xpath("//td[@class='cart_total']")).getText();
            
            if (row.contains(productName)) {
                Log.info(String.format("Row product name: Has product %s", productName));
                pN = true;
            } else {
                Log.error(String.format("Row product name: Has not product %s", productName));
                pN = false;
            }

            pTotal = Float.parseFloat(totalPrice.replaceAll("\\$", ""));
            if (pTotal == priceTotal) {
                Log.info(String.format("Row total price: Has correct value %s", priceTotal));
                pT = true;
            } else {
                Log.error(String.format("Row total price: Has incorrect value %s", priceTotal));
                pT = false;
            }
        }
        if (Boolean.compare(pN, pT) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return true/false
     */
    public ShoppingCartPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageText);
            }
        });
        return this;
    }


}
