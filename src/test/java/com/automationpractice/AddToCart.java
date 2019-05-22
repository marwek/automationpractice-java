package com.automationpractice;


import com.automationpractice.pageobjects.HomePage;
import com.automationpractice.utils.DriverFactory;
import com.automationpractice.utils.DriverType;
import com.automationpractice.utils.PageUrls;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class AddToCart {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
        if(driver !=null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void addToCartFirstProductOnPopularCategoryFirefox() {
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.manage().window().maximize();
        driver.get(PageUrls.getMainUrl());

        HomePage home = new HomePage(driver);
        home.printList();

    }

}
