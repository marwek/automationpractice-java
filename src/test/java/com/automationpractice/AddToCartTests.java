package com.automationpractice;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.automationpractice.pageobjects.HomePage;
import com.automationpractice.utils.DriverFactory;
import com.automationpractice.utils.DriverType;
import com.automationpractice.utils.PageUrls;
import org.openqa.selenium.WebDriver;

public class AddToCartTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
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
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PageUrls.getMainUrl());

        HomePage home = new HomePage(driver);
        home.verifyPageLoaded();
        home.addPopularProductToCart("Faded Short Sleeve T-shirts", 4, "M", "Blue"); 
        // home.waitVisibility(elementBy);

    }
}
