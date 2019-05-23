package com.automationpractice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.automationpractice.pageobjects.HomePage;
import com.automationpractice.pageobjects.ShoppingCartPage;
import com.automationpractice.utils.DriverFactory;
import com.automationpractice.utils.DriverType;
import com.automationpractice.utils.Log;
import com.automationpractice.utils.PageUrls;
import org.openqa.selenium.WebDriver;

public class AddToCartTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        BasicConfigurator.configure();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void addToCartFirstProductOnPopularCategoryFirefox() {
        driver = DriverFactory.getDriver(DriverType.FIREFOX);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PageUrls.getMainUrl());

        Log.startTestCase("addToCartFirstProductOnPopularCategoryFirefox");

        HomePage home = new HomePage(driver);
        home.verifyPageLoaded();
        home.addPopularProduct("Faded Short Sleeve T-shirts", 10, "M", "Blue");
        home.addToCart();
        home.proceedToCheckout(); 
        
        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
        shoppingCart.verifyPageLoaded();
        
        assertTrue(shoppingCart.checkNameAndTotalPriceForProduct("Faded Short Sleeve T-shirts", 165.10f));

        Log.endTestCase("addToCartFirstProductOnPopularCategoryFirefox");
    }
}
